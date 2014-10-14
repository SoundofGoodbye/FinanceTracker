package com.example.financetracker.adapters;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.financetracker.Budget;
import com.example.financetracker.R;
import com.example.financetracker.listeners.MainScreenRemoveButtonOnClickListener;

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

			// We pass the parent here so the android system doesn't ignore the
			// layout parameters from the XML file. If parent is null the
			// default parameters will be used and setting width/height etc on
			// the child elements will not work.
			incomeMethodRowView = inflater.inflate(
					R.layout.income_methods_element, parent, false);

			// Hold the view objects in a ViewHolder so they can be reused
			// instead of finding the views again. It increases performance.
			view = new ViewHolder();
			view.enterMethodString = (TextView) incomeMethodRowView
					.findViewById(R.id.income_enter_method_string);

			view.enterAmountString = (TextView) incomeMethodRowView
					.findViewById(R.id.income_enter_amount_string);

			view.removeButton = (Button) incomeMethodRowView
					.findViewById(R.id.income_delete_method);

			incomeMethodRowView.setTag(view);
		} else {
			view = (ViewHolder) incomeMethodRowView.getTag();
		}

		Budget currentBudget = budgetsList.get(position);

		String enterMethodString = currentBudget.getEnterMethodString();
		view.enterMethodString.setText(enterMethodString);

		String enterAmountString = currentBudget.getEnterAmountString();
		view.enterAmountString.setText(enterAmountString);

		initRemoveButton(view.removeButton, currentBudget);
		return incomeMethodRowView;
	}

	/**
	 * Sets the onclick listener to the remove button by passing the list with
	 * all the rows along with and object that holds information about the the
	 * current row. This information is used by the remove button to clear the
	 * row that the button is at.
	 * 
	 * @param removeButton
	 *            - the remove button in the view
	 * @param budget
	 *            - a budget object that holds the information from the two edit
	 *            text views for the current row.
	 */
	private void initRemoveButton(Button removeButton, Budget budget) {
		removeButton
				.setOnClickListener(new MainScreenRemoveButtonOnClickListener(
						budget, budgetsList, this));
	}

	private static class ViewHolder {

		public TextView enterMethodString;

		public TextView enterAmountString;

		public Button removeButton;
	}
}
