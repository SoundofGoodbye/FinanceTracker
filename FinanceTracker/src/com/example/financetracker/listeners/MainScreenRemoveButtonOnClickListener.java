package com.example.financetracker.listeners;

import java.util.List;

import com.example.financetracker.Budget;
import com.example.financetracker.adapters.MainScreenListAdapter;

import android.view.View;
import android.view.View.OnClickListener;

public class MainScreenRemoveButtonOnClickListener implements OnClickListener {

	private Budget budgetToRemove;

	private List<Budget> budgetsList;

	private MainScreenListAdapter mainScreenListAdapter;

	public MainScreenRemoveButtonOnClickListener(Budget budgetToRemove,
			List<Budget> budgetsList,
			MainScreenListAdapter mainScreenListAdapter) {
		this.budgetToRemove = budgetToRemove;
		this.budgetsList = budgetsList;
		this.mainScreenListAdapter = mainScreenListAdapter;
	}

	@Override
	public void onClick(View v) {
		budgetsList.remove(budgetToRemove);
		mainScreenListAdapter.notifyDataSetChanged();
	}
}
