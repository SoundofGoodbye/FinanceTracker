package com.example.financetracker.views;

import com.example.financetracker.listeners.MainScreenAddButtonOnClickListener;

public class MoneyAmountView extends LinearLayout {

	private static final int INCOME_METHOD_ID = 1;

	private static final int INCOME_AMOUNT_ID = 2;

	private static final int ERROR_WHILE_GETTING_ADD_BUTTON = -1;

	private static final String TAG = MoneyAmountView.class.getSimpleName();

	private Context context;

	private ListView incomeListView;

	public MoneyAmountView(Context context) {
		super(context);
	}

	public MoneyAmountView(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
		incomeListView = (ListView) findViewById(R.id.main_screen_list_view);
		initAttributes(context, attrs);
	}

	private void initAttributes(Context context, AttributeSet attrs) {
		TypedArray typeArray = context.obtainStyledAttributes(attrs,
				R.styleable.MoneyAmountView, 0, 0);
		try {
			int buttonType = typeArray.getInteger(
					R.styleable.MoneyAmountView_methodType,
					ERROR_WHILE_GETTING_ADD_BUTTON);

			initMoneyAmountView(context, buttonType);
		} catch (Exception e) {
			Log.e(TAG,
					"Exception occured while getting attributes for MoneyAmountView.");
			e.printStackTrace();
		} finally {
			typeArray.recycle();
		}
	}

	private void initMoneyAmountView(Context context, int buttonType) {

		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.new_method_layout, this, true);

		initFieldsForPassedButtonType(buttonType);
	}

	private void initFieldsForPassedButtonType(int buttonType) {
		Button addButton = (Button) findViewById(R.id.main_screen_add_button);

		switch (buttonType) {
		case 0:
			initIncomeFields(addButton);
			break;
		case 1:
			initExpensesFields();
			addButton.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					expensesAddButtonClickListener(v);
				}
			});
			break;
		}
	}

	private void initExpensesFields() {
		// TODO Auto-generated method stub

	}

	private void initIncomeFields(Button addButton) {
		EditText incomeMethodInputField = (EditText) findViewById(R.id.income_method_input_text_field);
		incomeMethodInputField.setId(INCOME_METHOD_ID);
		String methodName = incomeMethodInputField.getText().toString().trim();

		EditText incomeAmountInputField = (EditText) findViewById(R.id.income_amount_input_text_field);
		incomeAmountInputField.setId(INCOME_AMOUNT_ID);
		String amount = incomeAmountInputField.getText().toString().trim();

		addButton.setOnClickListener(new MainScreenAddButtonOnClickListener(
				context, incomeListView, incomeMethodInputField,
				incomeAmountInputField));
	}

	public void expensesAddButtonClickListener(View v) {
		System.out.println("Expenses Button clicked!");
	}
}
