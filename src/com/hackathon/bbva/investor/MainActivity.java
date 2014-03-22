package com.hackathon.bbva.investor;

import java.util.HashMap;
import java.util.LinkedList;

import com.example.com.hackathon.bbva.investor.R;
import com.google.android.glass.widget.CardScrollView;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.os.Handler;

/**
 * Activity showing the options menu.
 */
public class MainActivity extends Activity {
	
	InvestorCardAdapter mInvestorAdapter = new InvestorCardAdapter();
	PressCardAdapter mPressAdapter = new PressCardAdapter();
	CardScrollView mCardScrollView;
	
	static final String DATA_TITLE = "T";
	static final String DATA_LINK  = "L";
	static final String DATA_ENCLOSURE  = "E";

	static LinkedList<HashMap<String, String>> data;

	
	static String feedUrl = "http://prensa.bbva.com/view_manager.html?root=9882,22&rss=1";	
	
	
	private ProgressDialog progressDialog;


	private final Handler progressHandler = new Handler() {
		@SuppressWarnings("unchecked")
		public void handleMessage(Message msg) {
			if (msg.obj != null) {
				data = (LinkedList<HashMap<String, String>>)msg.obj;
				setData(data);					
			}
			progressDialog.dismiss();
	    }
	};
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.livecard);

		 mCardScrollView = new CardScrollView(this);
		//mCardScrollView.setAdapter(adapter);
		mCardScrollView.activate();
		
		RelativeLayout mLayout = (RelativeLayout) findViewById(R.id.mainLayout);
		mLayout.addView(mCardScrollView);
		
		openOptionsMenu();
	}
	
	/**
	 * Captura el Tap para mostrar el menu
	 */
	@Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
          if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER) {
              openOptionsMenu();
              return true;
          }
          return false;
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case R.id.stop:
			finish();
			return true;
		case R.id.stocks:
			
			InvestorCard card1 = new InvestorCard(this, "BBVA", "44.5", "+0.56%", R.drawable.bbvaleft);
			InvestorCard card2 = new InvestorCard(this, "DIA", "41.5", "+0.56%", R.drawable.dialeft);
			
			//CardScrollView mCardScrollView = new CardScrollView(this);
			mInvestorAdapter = new InvestorCardAdapter();
			mInvestorAdapter.addInvestorCard(card1);
			mInvestorAdapter.addInvestorCard(card2);
			
			mCardScrollView.setAdapter(mInvestorAdapter);
			return true;
		case R.id.press_news:
			loadData();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
		
	}

	@Override
	public void onOptionsMenuClosed(Menu menu) {
	}
	
	
	private void loadData() {
    	progressDialog = ProgressDialog.show(
    			MainActivity.this,
    			"", 
    			"Por favor espere mientras se cargan los datos...", 
    			true);
    	
    	new Thread(new Runnable(){
    		@Override
    		public void run() {
    			XMLParser parser = new XMLParser(feedUrl); 
                Message msg = progressHandler.obtainMessage();
                msg.obj = parser.parse();
    			progressHandler.sendMessage(msg);
    		}}).start();
	  }
	
	private void setData(LinkedList<HashMap<String, String>> data){
    	
		mPressAdapter.clear();
		
		for (HashMap<String, String> hm : data) {
			PressCard card = new PressCard(this, hm.get(DATA_TITLE), hm.get(DATA_LINK));
			mPressAdapter.addPressCard(card);
		}
		
    	mCardScrollView.setAdapter(mPressAdapter);
    }   
}
