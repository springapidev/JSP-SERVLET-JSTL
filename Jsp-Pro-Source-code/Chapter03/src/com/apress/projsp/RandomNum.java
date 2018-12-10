package com.apress.projsp;

public class RandomNum {

	private int num;

	public RandomNum() {
		reset();
	}

	public void reset() {
	  setNum(10);
	}
	
	public void setNum(int num) {
		this.num = new Double(Math.random() * num).intValue();
	}

	public int getNum() {
		return num;
	}
}
