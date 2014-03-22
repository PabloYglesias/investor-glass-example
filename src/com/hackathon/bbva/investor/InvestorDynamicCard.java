package com.hackathon.bbva.investor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.view.View;

import com.example.com.hackathon.bbva.investor.R;
import com.google.android.glass.app.Card;

public class InvestorDynamicCard extends InvestorCard {
	
	private ArrayList<InvestorCard> mList;
	private int DELAY_TIME = 50000;
	
	private Handler mHandler;
	private Runnable mRunnable;
	private View mContainer;
	
	private Iterator<InvestorCard> itCards;
	
	public InvestorDynamicCard(Context context, ArrayList<InvestorCard> list, View container) {
		super(context, "", "", "", R.drawable.bbvaleft);
		
		mList = list;
		
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
		
		if (!itCards.hasNext())
			itCards = mList.iterator();
		
		InvestorCard invCard = itCards.next();
		this.copy(invCard);
		
		mContainer.postInvalidate();
		mHandler.postDelayed(mRunnable, DELAY_TIME);
	}
	
	
}
