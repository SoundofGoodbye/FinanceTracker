package com.example.financetracker.activity;

import java.util.ArrayList;
import java.util.List;

import com.example.financetracker.Budget;
import com.example.financetracker.R;
import com.example.financetracker.adapters.MainScreenListAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

public class MainScreen extends Activity {

	private static final String TAG = MainScreen.class.getSimpleName();

	private List<Budget> budgetsList;

	private ListView incomeListView;

	private MainScreenListAdapter mainScreenListAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_screen_layout);
		incomeListView = (ListView) findViewById(R.id.main_screen_list_view);
		// TODO: Get elements from database
		budgetsList = new ArrayList<Budget>();
		mainScreenListAdapter = new MainScreenListAdapter(this, budgetsList);
		incomeListView.setAdapter(mainScreenListAdapter);
	}

	public void addButtonClickListener(View view) {
		EditText incomeMethodInputField = (EditText) findViewById(R.id.income_method_input_text_field);
		String methodName = incomeMethodInputField.getText().toString().trim();
		EditText incomeAmountInputField = (EditText) findViewById(R.id.income_amount_input_text_field);
		String amount = incomeAmountInputField.getText().toString().trim();

		boolean checkIfNullFields = methodName != null || amount != null;
		boolean checkEmptyFields = !(methodName.equals("") || amount.equals(""));
		boolean checkValidInput = checkIfNullFields && checkEmptyFields;

		if (checkValidInput) {
			budgetsList.add(new Budget(methodName, amount));
			mainScreenListAdapter = new MainScreenListAdapter(this, budgetsList);
			incomeListView.setAdapter(mainScreenListAdapter);
			mainScreenListAdapter.notifyDataSetChanged();

			clearInputFields(incomeMethodInputField, incomeAmountInputField);
		} else if (!checkEmptyFields) {
			clearInputFields(incomeMethodInputField, incomeAmountInputField);
		} else {
			Log.e(TAG, "Unexpected error while getting text from input fields");
		}
	}

	private void clearInputFields(EditText incomeMethodInputField,
			EditText incomeAmountInputField) {
		// TODO: get labels from string.xml
		incomeMethodInputField.setText("");
		incomeMethodInputField.setHint("Enter input method");
		incomeAmountInputField.setText("");
		incomeAmountInputField.setHint("Enter amount");
	}
}
