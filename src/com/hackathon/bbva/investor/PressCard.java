package com.hackathon.bbva.investor;

import android.content.Context;

import com.example.com.hackathon.bbva.investor.R;
import com.google.android.glass.app.Card;

public class PressCard extends Card {

	private String mTitle;
	private String mUrl;
	private int mType;
	
	public PressCard(Context context, String title, String Url, int type) {
		super(context);
		
		mTitle = title;
		mUrl = Url;
		mType = type;
		
		this.setText(mTitle);
		
		if (mType == 1) {
			this.addImage(R.drawable.img_news);
		}
		else if (mType == 2) {
			this.addImage(R.drawable.img_events);
		}
		else if (mType == 3) {
			this.addImage(R.drawable.img_presentations);
		}
	}
	
	public String getUrl() {
		return mUrl;
	}
}
