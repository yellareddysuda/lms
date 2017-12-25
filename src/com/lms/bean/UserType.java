package com.lms.bean;

public enum UserType {

	STUDENT(3), STAFF(10);
	private final int bookLimit;

	UserType(int bookLimit) {
		this.bookLimit = bookLimit;
	}

	public int getBookLimit() {
		return bookLimit;
	}

}
