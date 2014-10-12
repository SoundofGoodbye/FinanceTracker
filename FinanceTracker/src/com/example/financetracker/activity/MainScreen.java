package com.example.financetracker.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.financetracker.Budget;
import com.example.financetracker.R;
import com.example.financetracker.adapters.MainScreenListAdapter;

public class MainScreen extends Activity {

	private static final String TAG = MainScreen.class.getSimpleName();

	private List<Budget> budgetsList;

	private ListView incomeListView;

	private MainScreenListAdapter mainScreenListAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_screen_layout);
//		incomeListView = (ListView) findViewById(R.id.main_screen_list_view);
		// TODO: Get elements from database
		budgetsList = new ArrayList<Budget>();
		mainScreenListAdapter = new MainScreenListAdapter(this, budgetsList);
		incomeListView.setAdapter(mainScreenListAdapter);
	}
}
