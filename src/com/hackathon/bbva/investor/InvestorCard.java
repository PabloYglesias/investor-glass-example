package com.hackathon.bbva.investor;

import android.content.Context;

import com.example.com.hackathon.bbva.investor.R;
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
	private int mIdImage;
	private boolean mIsFull = false;
	
	public InvestorCard(Context context, String title, String stockValue, String stockIncrement, int idImage, boolean isFull) {
		super(context);
		
		mTitle = title;
		mStockValue = stockValue;
		mStockIncrement = stockIncrement;
		mIdImage = idImage;
		mIsFull = isFull;
		
		setUI();
	}
	
	public InvestorCard(Context context, String title, String stockValue, String stockIncrement, int idImage) {
		super(context);
		
		mTitle = title;
		mStockValue = stockValue;
		mStockIncrement = stockIncrement;
		mIdImage = idImage;
		
		setUI();
	}

	public void copy(InvestorCard card) {
		
		mTitle = card.mTitle;
		mStockValue = card.mStockValue;
		mStockIncrement = card.mStockIncrement;
		mIdImage = card.mIdImage;
		
		mIsFull = card.mIsFull;
		
		this.clearImages();
		
		setUI();
	}
	
	private void setUI() {
		if (mIsFull)
			this.setImageLayout(ImageLayout.FULL);
		else
			this.setImageLayout(ImageLayout.LEFT); //para la izquierda
		this.addImage(mIdImage);
		// Add the elements to the card
		this.setText(mTitle + "\n" + mStockValue);
		this.setFootnote(mStockIncrement);
	}
	
}
