package com.example.financetracker.listeners;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.financetracker.Budget;
import com.example.financetracker.adapters.MainScreenListAdapter;

public class MainScreenAddButtonOnClickListener implements OnClickListener {

	private ArrayList<Budget> budgetsList;

	private MainScreenListAdapter mainScreenListAdapter;

	private ListView incomeListView;

	private EditText incomeMethodInputField;

	private EditText incomeAmountInputField;

	private boolean checkMethodTextNull;

	private boolean checkAmountTextNull;

	Context context;

	public MainScreenAddButtonOnClickListener(Context context,
			ListView incomeListView, EditText incomeMethodInputField,
			EditText incomeAmountInputField) {
		this.incomeListView = incomeListView;
		this.incomeMethodInputField = incomeMethodInputField;
		this.incomeAmountInputField = incomeAmountInputField;
		budgetsList = new ArrayList<Budget>();

		mainScreenListAdapter = new MainScreenListAdapter(context, budgetsList);
		this.context = context;
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

			// Why not make it a bit more fun?
			Toast.makeText(this.context, methodText + "\n" + amountText + "$",
					Toast.LENGTH_SHORT).show();
			clearFields();
		} // Checking for errors in input.
		else if (!checkMethodTextNull && checkAmountTextNull) {
			incomeMethodInputField.setError("Error in method input.");
		} else if (!checkAmountTextNull && checkMethodTextNull) {
			incomeAmountInputField.setError("Error in amount input.");
		} else {
			incomeMethodInputField.setError("Error in input.");
			incomeAmountInputField.setError("Error in input.");
		}

	}

	private boolean checkValidInput(String methodText, String amountText) {

		checkMethodTextNull = (methodText != null) && !(methodText.equals(""));
		checkAmountTextNull = (amountText != null) && !(amountText.equals(""));
		boolean isValidInput = checkMethodTextNull && checkAmountTextNull;
		return isValidInput;
	}

	private void clearFields() {
		incomeMethodInputField.setText("");
		incomeAmountInputField.setText("");
	}
}
