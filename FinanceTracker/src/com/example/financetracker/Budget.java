package com.example.financetracker;

public class Budget {

	private String enterMethodString;

	private String enterAmountString;

	public Budget(String methodName, String amount) {
		enterMethodString = methodName;
		enterAmountString = amount;
	}

	public String getEnterMethodString() {
		return enterMethodString;
	}

	public void setEnterMethodString(String enterMethodString) {
		this.enterMethodString = enterMethodString;
	}

	public String getEnterAmountString() {
		return enterAmountString;
	}

	public void setEnterAmountString(String enterAmountString) {
		this.enterAmountString = enterAmountString;
	}
}
