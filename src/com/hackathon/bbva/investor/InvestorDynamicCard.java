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
import com.google.android.glass.widget.CardScrollView;

public class InvestorDynamicCard extends InvestorCard {
	
	private ArrayList<InvestorCard> mList;
	private int DELAY_TIME = 3000;
	
	private Handler mHandler;
	private Runnable mRunnable;
	private InvestorCardAdapter mAdapter;
	private CardScrollView mContainer;
	
	private Iterator<InvestorCard> itCards;
	
	public InvestorDynamicCard(Context context, ArrayList<InvestorCard> list, CardScrollView container, InvestorCardAdapter adapter) {
		super(context, list.get(0).getTitle(), list.get(0).getStockValue(), list.get(0).getStockIncrement(), list.get(0).getImageID());
		
		mList = list;
		
		mAdapter = adapter;
		mContainer = container;
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
		
		Log.e("Dynamic cards", "changing card: " + invCard.getText());
		
		mAdapter.notifyDataSetChanged();
		mContainer.postInvalidate();
		
		mHandler.postDelayed(mRunnable, DELAY_TIME);
	}
	
	
}
