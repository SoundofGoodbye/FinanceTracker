package com.example.financetracker.listeners;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ListView;

import com.example.financetracker.Budget;
import com.example.financetracker.adapters.MainScreenListAdapter;

public class MainScreenAddButtonOnClickListener implements OnClickListener {

	private ArrayList<Budget> budgetsList;

	private MainScreenListAdapter mainScreenListAdapter;

	private ListView incomeListView;

	private EditText incomeMethodInputField;

	private EditText incomeAmountInputField;

	public MainScreenAddButtonOnClickListener(Context context,
			ListView incomeListView, EditText incomeMethodInputField,
			EditText incomeAmountInputField) {
		this.incomeListView = incomeListView;
		this.incomeMethodInputField = incomeMethodInputField;
		this.incomeAmountInputField = incomeAmountInputField;
		budgetsList = new ArrayList<Budget>();

		mainScreenListAdapter = new MainScreenListAdapter(context, budgetsList);
	}

	@Override
	public void onClick(View v) {
		String methodText = incomeMethodInputField.getText().toString();
		String amountText = incomeAmountInputField.getText().toString();

		boolean isInputValid = checkValidInput(methodText, amountText);
		if (isInputValid) {
			budgetsList.add(new Budget(methodText, amountText));
			incomeListView.setAdapter(mainScreenListAdapter);
			mainScreenListAdapter.notifyDataSetChanged();
			clearFields();
		} else {
			// TODO: Add proper error message to show invalid input.
		}
	}

	private boolean checkValidInput(String methodText, String amountText) {
		boolean checkIfNullFields = methodText != null || amountText != null;
		boolean checkEmptyFields = !(methodText.equals("") || amountText
				.equals(""));
		boolean isValidInput = checkIfNullFields && checkEmptyFields;
		return isValidInput;
	}

	private void clearFields() {
		incomeMethodInputField.setText("");
		incomeAmountInputField.setText("");
	}
}
