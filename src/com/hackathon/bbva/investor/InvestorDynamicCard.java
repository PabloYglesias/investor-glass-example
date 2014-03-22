package com.hackathon.bbva.investor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;

import com.google.android.glass.app.Card;

public class InvestorDynamicCard extends Card {
	
	private ArrayList<InvestorCard> mList = new ArrayList<InvestorCard>();
	private int DELAY_TIME = 50000;
	
	private Handler mHandler;
	private Runnable mRunnable;
	
	private Iterator<InvestorCard> itCards;

	public void addDynamicCard(InvestorCard card) {
		mList.add(card);
	}
	
	public InvestorDynamicCard(Context context) {
		super(context);
		
		itCards = mList.iterator();
		
		mHandler = new Handler();
		mRunnable = new Runnable() {
			@Override
			public void run() {
				update();
			}
		};
		mHandler.postDelayed(mRunnable, DELAY_TIME);
	}

	private void update() {
		
		mHandler.postDelayed(mRunnable, DELAY_TIME);
	}
	
	
}
