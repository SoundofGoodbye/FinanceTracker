package com.example.financetracker.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.example.financetracker.R;

/**
 * Custom view that will display information about the money left after the
 * expenses have been subtracted from the income.
 * 
 * @author marto
 * 
 */
public class MoneyLeftView extends LinearLayout {

	/**
	 * Constructor that is most likely to be called when the view is created in
	 * an XML file. This constructor will initialize the attributes passed in
	 * the XML file.
	 * 
	 * @param context
	 * @param attrs
	 */
	public MoneyLeftView(Context context, AttributeSet attrs) {
		super(context, attrs);

		// Initialize the money left view.
		initMoneyLeftView(context);
	}

	/**
	 * Get the XML file representing the view and inflate it so we can use the
	 * elements inside of the XML file and work with them.
	 * 
	 * @param context
	 *            - Use the current context to get the inflater object.
	 */
	private void inflateXmlToView(Context context) {
		// Inflate the XML file so we can get the elements from it and also
		// give our view a body.
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		inflater.inflate(R.layout.money_left_layout, this, true);
	}

	/**
	 * All initialization for creating the money left view should be called
	 * inside this method as it is called inside the constructor.
	 * 
	 * @param context
	 *            - used for initialization purposes like inflating.
	 */
	private void initMoneyLeftView(Context context) {
		inflateXmlToView(context);
	}
}
