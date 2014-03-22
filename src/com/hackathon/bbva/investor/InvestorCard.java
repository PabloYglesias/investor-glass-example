package com.hackathon.bbva.investor;

import android.content.Context;

import com.google.android.glass.app.Card;

/*
card.setImageLayout(ImageLayout.FULL); //para el fondo
card.setImageLayout(ImageLayout.LEFT); //para la izquierda
card.addImage(R.drawable.card_chocolate_background);
*/

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
		this.setText(stockValue);
		this.setFootnote(mStockValue);
	}

	
	
}
