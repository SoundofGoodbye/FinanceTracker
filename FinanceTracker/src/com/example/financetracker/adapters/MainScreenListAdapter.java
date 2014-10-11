package com.example.financetracker.adapters;

import java.util.List;

import com.example.financetracker.Budget;
import com.example.financetracker.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MainScreenListAdapter extends BaseAdapter {

	private Context context;

	private List<Budget> budgetsList;

	public MainScreenListAdapter(Context context, List<Budget> budgetsList) {
		this.context = context;
		this.budgetsList = budgetsList;
	}

	@Override
	public int getCount() {
		return budgetsList.size();
	}

	@Override
	public Object getItem(int position) {
		return budgetsList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View incomeMethodRowView = convertView;
		ViewHolder view;

		if (incomeMethodRowView == null) {
			// Get a new instance of the row layout view
			LayoutInflater inflater = LayoutInflater.from(context);

			incomeMethodRowView = inflater.inflate(
					R.layout.income_methods_element, null);

			// Hold the view objects in an object, that way the don't need to be
			// "re-  finded"
			view = new ViewHolder();
			view.enterMethodString = (TextView) incomeMethodRowView
					.findViewById(R.id.income_enter_method_string);

			view.enterAmountString = (TextView) incomeMethodRowView
					.findViewById(R.id.income_enter_amount_string);

			incomeMethodRowView.setTag(view);
		} else {
			view = (ViewHolder) incomeMethodRowView.getTag();
		}

		Budget currentBudget = budgetsList.get(position);

		String enterMethodString = currentBudget.getEnterMethodString();
		view.enterMethodString.setText(enterMethodString);

		String enterAmountString = currentBudget.getEnterAmountString();
		view.enterAmountString.setText(enterAmountString);

		return incomeMethodRowView;
	}

	private static class ViewHolder {

		public TextView enterMethodString;

		public TextView enterAmountString;
	}
}
