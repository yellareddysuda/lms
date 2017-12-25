package com.lms.service.impl;

import com.lms.persistence.UserBookDao;
import com.lms.service.UserBookService;

public class UserBookServiceImpl implements UserBookService {

	private UserBookDao dao = new UserBookDao();

	@Override
	public boolean lendBook(String userId, String bookId) {
		return dao.lendBook(userId, bookId);
	}

	@Override
	public boolean returnBook(String userId, String bookId) {
		return dao.returnBook(userId, bookId);
	}

	@Override
	public int noOfBooksTakenByUser(String userId) {
		return dao.booksCountByUser(userId);
	}

}
