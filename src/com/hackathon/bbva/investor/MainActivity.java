package com.hackathon.bbva.investor;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import com.example.com.hackathon.bbva.investor.R;
import com.google.android.glass.widget.CardScrollView;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
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
	static LinkedList<HashMap<String, String>> msg;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.livecard);

		 mCardScrollView = new CardScrollView(this);
		//mCardScrollView.setAdapter(adapter);
		mCardScrollView.activate();
		
		mCardScrollView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				 openOptionsMenu();
			}
		});
		
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
          else if (keyCode == KeyEvent.KEYCODE_DPAD_DOWN) {
        	  finish();
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
			
			InvestorCard card1 = new InvestorCard(this, "      BBVA", "      8.719", "-0.50%", R.drawable.bbvaleft);
			InvestorCard card2 = new InvestorCard(this, "      TELE5",  "      8.374", "-0.52%", R.drawable.telecincofull, true);
			InvestorCard card3 = new InvestorCard(this, "      DIA",  "     6.124", "+0.41%", R.drawable.dialeft);
			
			ArrayList<InvestorCard> listInvestor = new ArrayList<InvestorCard>();
			listInvestor.add(card1);
			listInvestor.add(card2);
			listInvestor.add(card3);
			
			//CardScrollView mCardScrollView = new CardScrollView(this);
			mInvestorAdapter = new InvestorCardAdapter();
			mInvestorAdapter.addInvestorCard(card1);
			mInvestorAdapter.addInvestorCard(card2);
			mInvestorAdapter.addInvestorCard(card3);
			
			InvestorDynamicCard card4 = new InvestorDynamicCard(this, listInvestor, mCardScrollView, mInvestorAdapter);
			mInvestorAdapter.addInvestorCard(card4);
			
			mCardScrollView.setAdapter(mInvestorAdapter);
			return true;
		case R.id.press_news:
			loadData(1);
			return true;
		case R.id.press_events:
			loadData(2);
			return true;
		case R.id.press_presentations:
			loadData(3);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
		
	}

	@Override
	public void onOptionsMenuClosed(Menu menu) {
	}
	
	
	private void loadData(final int i) {
	    	if(i==1){
	    	this.runOnUiThread(new Runnable() {
	    		  public void run() {
	    			  
	    			  AssetManager assetManager = getAssets();
	    			  InputStream inputStream = null;
	    			  try {
	    			      inputStream = assetManager.open("press.xml");
	    			  }
	    			  catch (IOException e){
	    			      Log.e("message: ",e.getMessage());
	    			  }
	    				XMLParser parser = new XMLParser(inputStream); 
	                    msg = parser.parse();
	                    setData(msg, i);	
	    		  }
	    		});
	    	
	    	}else if(i==2){
	        	this.runOnUiThread(new Runnable() {
	      		  public void run() {
	      			  
	      			  AssetManager assetManager = getAssets();
	      			  InputStream inputStream = null;
	      			  try {
	      			      inputStream = assetManager.open("events.xml");
	      			  }
	      			  catch (IOException e){
	      			      Log.e("message: ",e.getMessage());
	      			  }
	      				XMLParser parser = new XMLParser(inputStream); 
	                      msg = parser.parse();
	                      setData(msg, i);	
	      		  }
	      		});
	      	
	      	}
	    	if(i==3){
	        	this.runOnUiThread(new Runnable() {
	        		  public void run() {
	        			  
	        			  AssetManager assetManager = getAssets();
	        			  InputStream inputStream = null;
	        			  try {
	        			      inputStream = assetManager.open("presentation.xml");
	        			  }
	        			  catch (IOException e){
	        			      Log.e("message: ",e.getMessage());
	        			  }
	        				XMLParser parser = new XMLParser(inputStream); 
	                        msg = parser.parse();
	                        setData(msg, i);	
	        		  }
	        		});
	        	
	        	}
	    	
	    }   
	
	private void setData(LinkedList<HashMap<String, String>> data, int type){
    	
		mPressAdapter.clear();
		
		for (HashMap<String, String> hm : data) {
			PressCard card = new PressCard(this, hm.get(DATA_TITLE), hm.get(DATA_LINK), type);
			mPressAdapter.addPressCard(card);
		}
		
    	mCardScrollView.setAdapter(mPressAdapter);
    }   
}
