package com.example.financetracker.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public class MoneyAmountView extends View {

	private Context context;

	public MoneyAmountView(Context context) {
		super(context);
		this.context = context;
		// initView();
	}

	// private void initView() {
	// context.getTheme().obtainStyledAttributes(attrs);
	// }

	public MoneyAmountView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public MoneyAmountView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}
}
