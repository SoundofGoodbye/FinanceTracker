package com.example.financetracker.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.financetracker.R;
import com.example.financetracker.listeners.MainScreenAddButtonOnClickListener;

/**
 * A custom view that represents a {@link Button button}, two {@link EditText}
 * fields and a {@link ListView}. Those specific elements are used in more than
 * one place so it is convenient to wrap them in a custom view. The view also
 * attaches a {@link MainScreenAddButtonOnClickListener click listener} to the
 * button when it is created.
 * 
 * @author marto
 * 
 */
public class MoneyAmountView extends LinearLayout {

	/**
	 * Used to help logging information properly. This tag represents the class
	 * name.
	 */
	private static final String TAG = MoneyAmountView.class.getSimpleName();

	public MoneyAmountView(Context context) {
		super(context);
	}

	/**
	 * This will create a new view by inflating it from the XML file (holding
	 * button, two edit text fields and a list view). It will also get the
	 * additional properties (if any) from the Styled attributes.
	 * 
	 * @param context
	 * @param attrs
	 */
	public MoneyAmountView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initAttributes(context, attrs);
		initMoneyAmountView(context);
	}

	/**
	 * This method is responsible for mapping attribute values from attrs.xml
	 * file to local variables so they can be properly handled. The available
	 * values are defined in the attrs.xml file and are then used in the XML
	 * file where the view is actually used.
	 * 
	 * @param context
	 *            - used to obtain the typed array.
	 * @param attrs
	 *            - used to obtain the typed array.
	 */
	private void initAttributes(Context context, AttributeSet attrs) {
		TypedArray typeArray = context.obtainStyledAttributes(attrs,
				R.styleable.MoneyAmountView, 0, 0);
		try {
			// TODO: Get styled attributes here if any.
		} catch (Exception e) {
			Log.e(TAG,
					"Exception occured while getting attributes for MoneyAmountView.");
			e.printStackTrace();
		} finally {
			typeArray.recycle();
		}
	}

	private void initMoneyAmountView(Context context) {
		// Inflate the XML file so we can get the elements from it and also
		// give our view a body.
		inflateXmlToView(context);

		initAddButton(context);
	}

	/**
	 * Get the XML file representing the view and inflate it so we can use the
	 * elements inside of the XML file and work with them.
	 * 
	 * @param context
	 *            - Use the current context to get the inflater object.
	 */
	private void inflateXmlToView(Context context) {

		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.money_amount_layout, this, true);
	}

	/**
	 * Pass the input fields and the ListView to a new
	 * {@link MainScreenAddButtonOnClickListener click listener} that is set to
	 * the button.
	 * 
	 * @param context
	 *            - the views context that is passed to the add button's click
	 *            listener.
	 */
	private void initAddButton(Context context) {
		Button addButton = (Button) findViewById(R.id.main_screen_add_button);
		EditText methodInputField = (EditText) findViewById(R.id.income_method_input_text_field);
		EditText amountInputField = (EditText) findViewById(R.id.income_amount_input_text_field);
		ListView incomeListView = (ListView) findViewById(R.id.main_screen_list_view);

		addButton.setOnClickListener(new MainScreenAddButtonOnClickListener(
				context, incomeListView, methodInputField, amountInputField));
	}
}
