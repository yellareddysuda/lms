package com.lms.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserBookTransactionBean {

	private String userId;
	private List<String> books;
	private boolean deleted;
	private Date startDate;
	private Date endDate;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<String> getBooks() {
		if (books == null) {
			books = new ArrayList<>();
		}
		return books;
	}

	public void setBooks(List<String> books) {
		this.books = books;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
