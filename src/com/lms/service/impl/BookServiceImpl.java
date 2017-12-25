package com.lms.service.impl;

import java.util.List;

import com.lms.bean.BookBean;
import com.lms.persistence.BookDao;
import com.lms.service.BookService;

public class BookServiceImpl implements BookService {

	private BookDao dao = new BookDao();

	@Override
	public String addBook(BookBean book) {
		return dao.addBook(book);
	}

	@Override
	public List<BookBean> searchByTitle(String title) {
		return dao.searchBookByTitle(title);
	}

	@Override
	public List<BookBean> searchByName(String bookName) {
		return dao.searchBookByName(bookName);
	}

}
