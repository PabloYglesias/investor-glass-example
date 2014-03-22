package com.hackathon.bbva.investor;

import java.util.ArrayList;

import android.view.View;
import android.view.ViewGroup;

import com.google.android.glass.app.Card;
import com.google.android.glass.widget.CardScrollAdapter;

public class InvestorCardAdapter extends CardScrollAdapter {

	private ArrayList<Card> mCards;

	@Override
	public View getView(int position, View contentView, ViewGroup parent) {
		return mCards.get(position).toView();
	}

	@Override
	public int findIdPosition(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int findItemPosition(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
