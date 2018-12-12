package com.apress.projsp;

public class Person {

	private String name;
	private int age;
	private Address address;

	public Person() {
		setName("A N Other");
		setAge(21);
		this.address = new Address();
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Address getAddress() {
		return address;
	}

}
