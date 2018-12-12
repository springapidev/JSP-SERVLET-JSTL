package com.apress.projsp;

public class PhoneNumber {
	
	private String std;
	private String number;
	
	/**
	 * Returns the number.
	 * @return String
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * Returns the std.
	 * @return String
	 */
	public String getStd() {
		return std;
	}

	/**
	 * Sets the number.
	 * @param number The number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * Sets the std.
	 * @param std The std to set
	 */
	public void setStd(String std) {
		this.std = std;
	}

}
