package com.hackathon.bbva.investor;

import android.content.Context;

import com.google.android.glass.app.Card;

public class InvestorCard extends Card {

	private String mTitle;
	private String mStockValue;
	private String mStockIncrement;
	
	public InvestorCard(Context context, String title, String stockValue, String stockIncrement) {
		super(context);
		
		mTitle = title;
		mStockValue = stockValue;
		mStockIncrement = stockIncrement;
		
		// Add the elements to the card
		this.setText(mTitle);
		this.setFootnote(mStockValue);
	}

	
	
}
