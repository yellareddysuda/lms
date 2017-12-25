package com.lms.service;

public interface UserBookService {

	public boolean lendBook(String userId, String bookId);

	public boolean returnBook(String userId, String bookId);
	
	public int noOfBooksTakenByUser(String userId);

}
