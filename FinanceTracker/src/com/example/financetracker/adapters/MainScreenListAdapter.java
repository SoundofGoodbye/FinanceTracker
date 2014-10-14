package com.example.financetracker.adapters;

import java.util.List;

import com.example.financetracker.Budget;
import com.example.financetracker.R;
import com.example.financetracker.listeners.MainScreenRemoveButtonOnClickListener;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class MainScreenListAdapter extends BaseAdapter {

	private Context context;

	private List<Budget> budgetsList;

	public MainScreenListAdapter(Context context, List<Budget> budgetsList) {
		this.context = context;
		this.budgetsList = budgetsList;
		// initListWithDummyData();
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

	private void initListWithDummyData() {
		budgetsList.add(new Budget("A", "A"));
		budgetsList.add(new Budget("B", "B"));
		budgetsList.add(new Budget("C", "C"));
		budgetsList.add(new Budget("D", "D"));
		budgetsList.add(new Budget("E", "E"));
		budgetsList.add(new Budget("F", "F"));
		budgetsList.add(new Budget("G", "G"));
		budgetsList.add(new Budget("H", "H"));
		budgetsList.add(new Budget("I", "I"));
		budgetsList.add(new Budget("J", "J"));
		budgetsList.add(new Budget("K", "K"));
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View incomeMethodRowView = convertView;
		ViewHolder view;

		if (incomeMethodRowView == null) {
			// Get a new instance of the row layout view
			LayoutInflater inflater = LayoutInflater.from(context);

			// TODO: Change null to parent view group.
			incomeMethodRowView = inflater.inflate(
					R.layout.income_methods_element, null);

			// Hold the view objects in a ViewHolder so they can be reused
			// instead of finding the views again. It increases performance.
			view = new ViewHolder();
			view.enterMethodString = (TextView) incomeMethodRowView
					.findViewById(R.id.income_enter_method_string);

			view.enterAmountString = (TextView) incomeMethodRowView
					.findViewById(R.id.income_enter_amount_string);

			Button removeButton = (Button) incomeMethodRowView
					.findViewById(R.id.income_delete_method);

			initRemoveButton(removeButton, budgetsList.get(position));

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

	private void initRemoveButton(Button removeButton, Budget budget) {
		removeButton
				.setOnClickListener(new MainScreenRemoveButtonOnClickListener(
						budget, budgetsList, this));

		// (new OnClickListener() {
		// @Override
		// public void onClick(View v) {
		// budgetsList.remove(budget);
		// notifyDataSetChanged();
		// }
		// });
	}
}
