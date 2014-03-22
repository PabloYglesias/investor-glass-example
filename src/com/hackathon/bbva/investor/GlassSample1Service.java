package com.hackathon.bbva.investor;

import java.util.ArrayList;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.speech.RecognizerIntent;
import android.util.Log;

import com.google.android.glass.app.Card;
import com.google.android.glass.timeline.TimelineManager;
import com.google.android.glass.widget.CardScrollView;

public class GlassSample1Service extends Service {
	
	private String TAG = GlassSample1Service.class.getName();

	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		onStocks();
		return START_STICKY;
	}
	
	/*
	private void processPrompt(Intent intent) {
		
		ArrayList<String> promptResults = intent.getExtras().getStringArrayList(RecognizerIntent.EXTRA_RESULTS);
		Log.d(TAG, "promptResults:" + promptResults);
		
		if(!promptResults.isEmpty()) {
			
			String result = promptResults.get(0);
			
			if (result.equals("news")) {
				onNews();
				
			}
			else if (result.equals("stocks")) {
				onStocks();
			}
		}
	}
	*/
	
	private void onStocks() {
		
		//InvestorCard card1 = new InvestorCard(this, "BBVA", "44.5", "+0.56%");
			
		Card card1 = new Card(this);
		card1.setText("Esto es una static card");
		card1.setFootnote("Y esto es su footer!");
		
		/*
		CardScrollView mCardScrollView = new CardScrollView(this);
		InvestorCardAdapter adapter = new InvestorCardAdapter();
		
		mCardScrollView.setAdapter(adapter);
		*/

		// A–adir card al timeline
		TimelineManager.from(this).insert(card1);
	}
	
	private void onNews() {
		
	}
	
}
