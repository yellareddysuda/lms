package com.lms.service;

import java.util.List;

import com.lms.bean.BookBean;

public interface BookService {

	public String addBook(BookBean book);

	public List<BookBean> searchByTitle(String title);

	public List<BookBean> searchByName(String name);
}
