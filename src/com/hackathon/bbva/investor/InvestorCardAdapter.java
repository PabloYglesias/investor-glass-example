package com.hackathon.bbva.investor;

import java.util.ArrayList;

import android.view.View;
import android.view.ViewGroup;

import com.google.android.glass.widget.CardScrollAdapter;

public class InvestorCardAdapter extends CardScrollAdapter {

	private ArrayList<InvestorCard> mCards;

	@Override
	public View getView(int position, View contentView, ViewGroup parent) {
		return mCards.get(position).toView();
	}

	@Override
	public int findIdPosition(Object arg0) {
		return 0;
	}

	@Override
	public int findItemPosition(Object arg0) {
		return 0;
	}

	@Override
	public int getCount() {
		return mCards.size();
	}

	@Override
	public Object getItem(int position) {
		return mCards.get(position);
	}

	
	
}
