package com.hackathon.bbva.investor;

import android.content.Context;

import com.google.android.glass.app.Card;

public class PressCard extends Card {

	private String mTitle;
	private String mUrl;
	
	public PressCard(Context context, String title, String Url) {
		super(context);
		
		mTitle = title;
		mUrl = Url;
		
		this.setText(mTitle);
	}
	
	public String getUrl() {
		return mUrl;
	}
}
