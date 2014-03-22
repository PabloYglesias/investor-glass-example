package com.hackathon.bbva.investor;

import java.util.ArrayList;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.widget.RemoteViews;

import com.example.com.hackathon.bbva.investor.R;
import com.google.android.glass.app.Card;
import com.google.android.glass.timeline.LiveCard;
import com.google.android.glass.timeline.TimelineManager;
import com.google.android.glass.widget.CardScrollView;

public class GlassSample1Service extends Service {
	
	private static final String LIVE_CARD_INVESTOR = "INVESTOR";
	private LiveCard mLiveCard;
	private RemoteViews mLiveCardRemoveViews;
	private int mCounter;
	private Handler mHandler;
	private Runnable mRunnable;
	
	/*
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
	

	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		publishLiveCard();
		return START_STICKY;

	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		mHandler = null;
		unPublishCard();
	}

	/**
	 * Sample 2: Si la liveCard no existe la crea y la publica 
	 */
	private void publishLiveCard() {
		if (mLiveCard == null) {
			mLiveCard = TimelineManager.from(this).createLiveCard(LIVE_CARD_INVESTOR);

			// Referencia a la RemoveView de la LiveCard para poder modificarla luego
			mLiveCardRemoveViews = new RemoteViews(getPackageName(), R.layout.livecard);
			InvestorCard card1 = new InvestorCard(this, "BBVA", "44.5", "+0.56%", R.drawable.bbvaleft);
			
			//mLiveCardRemoveViews.addView(null, card1.toView());
			mLiveCard.setViews(mLiveCardRemoveViews);
			
			Intent intent = new Intent(this, MainActivity.class);
			mLiveCard.setAction(PendingIntent.getActivity(this, 0, intent, 0));
			mLiveCard.publish(LiveCard.PublishMode.REVEAL);
			
			// Init card ui update
			initCardUpdate();
		}

	}

	/**
	 * Si la liveCard existe la despublica y destruye
	 */
	private void unPublishCard() {
		if (mLiveCard != null) {
			mLiveCard.unpublish();
			mLiveCard = null;
			mLiveCardRemoveViews = null;
		}
	}
	
	
	
	/**
	 * Actualiza la interfaz de la LiveCard
	 */
	public void updateCard() {
		/*
		if (mLiveCardRemoveViews != null) {
			mLiveCardRemoveViews.setTextViewText(R.id.tvLiveCard1, String.valueOf(mCounter));	
			mLiveCard.setViews(mLiveCardRemoveViews);
			mHandler.postDelayed(mRunnable, 1000);
		}
		*/
	}

	private void initCardUpdate() {
		/*
		mHandler = new Handler();
		mRunnable = new Runnable() {
			@Override
			public void run() {
				mCounter++;
				updateCard();
			}
		};
		mHandler.postDelayed(mRunnable, 1000);
		*/
	}
	
}
