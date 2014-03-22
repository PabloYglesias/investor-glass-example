package com.hackathon.bbva.investor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import com.example.com.hackathon.bbva.investor.R;
import com.google.android.glass.app.Card;

public class InvestorDynamicCard extends InvestorCard {
	
	private ArrayList<InvestorCard> mList;
	private int DELAY_TIME = 1000;
	
	private Handler mHandler;
	private Runnable mRunnable;
	private InvestorCardAdapter mContainer;
	
	private Iterator<InvestorCard> itCards;
	
	public InvestorDynamicCard(Context context, ArrayList<InvestorCard> list, InvestorCardAdapter container) {
		super(context, "Test", "Test", "Test", R.drawable.bbvaleft);
		
		mList = list;
		
		mContainer = container;
		itCards = mList.iterator();
		
		mHandler = new Handler();
		mRunnable = new Runnable() {
			@Override
			public void run() {
				update();
			}
		};
		mHandler.postDelayed(mRunnable, 100);
	}

	private void update() {
		
		if (!itCards.hasNext())
			itCards = mList.iterator();
		
		InvestorCard invCard = itCards.next();
		this.copy(invCard);
		
		Log.e("Dynamic cards", "changing card: " + invCard.getText());
		
		mContainer.notifyDataSetChanged();
		mHandler.postDelayed(mRunnable, 1000);
	}
	
	
}
