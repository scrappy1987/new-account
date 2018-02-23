package com.qa.businessLogic;

public class BLogic {
	public boolean isValid(String accntNumber) {
		if(accntNumber.equalsIgnoreCase("9999")) {
			return false;
		}
		return true;
	}
}
