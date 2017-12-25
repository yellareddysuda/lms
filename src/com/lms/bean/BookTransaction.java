package com.lms.bean;

public class BookTransaction {

	private String bookId;
	private short quantity;
	private short availableQuantity;

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public short getQuantity() {
		return quantity;
	}

	public void setQuantity(short quantity) {
		this.quantity = quantity;
	}

	public short getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(short availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

}
