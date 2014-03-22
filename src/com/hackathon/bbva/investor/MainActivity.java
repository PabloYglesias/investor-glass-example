package com.hackathon.bbva.investor;

import com.example.com.hackathon.bbva.investor.R;
import com.google.android.glass.widget.CardScrollView;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.RelativeLayout;

/**
 * Activity showing the options menu.
 */
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.livecard);
		
		InvestorCard card1 = new InvestorCard(this, "BBVA", "44.5", "+0.56%", R.drawable.bbva_left);
		InvestorCard card2 = new InvestorCard(this, "DIA", "41.5", "+0.56%", R.drawable.dialeft);
		
		CardScrollView mCardScrollView = new CardScrollView(this);
		InvestorCardAdapter adapter = new InvestorCardAdapter();
		adapter.addInvestorCard(card1);
		adapter.addInvestorCard(card2);
		
		mCardScrollView.setAdapter(adapter);
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
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	@Override
	public void onOptionsMenuClosed(Menu menu) {
		// No hace nada, para salir hacer swipe hacia abajo
		
	}
}
