package com.lms.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.lms.bean.BookBean;

public class BookDao {

	private static final String BOOK = "BK_";
	private static int bookNumber = 0;
	private Map<String, BookBean> bookMap = new HashMap<>();

	public String addBook(BookBean book) {
		String bookId = BOOK + (++bookNumber);
		bookMap.put(bookId, book);
		return bookId;
	}

	public BookBean getBook(String bookId) {
		return bookMap.get(bookId);
	}

	public List<BookBean> searchBookByTitle(String title) {
		List<BookBean> bookList = new ArrayList<>();
		for (Entry<String, BookBean> entry : bookMap.entrySet()) {
			BookBean book = entry.getValue();
			if (title != null && book.getBookTitle().contains(title)) {
				bookList.add(book);
			}
		}
		return bookList;
	}

	public List<BookBean> searchBookByName(String bookName) {
		List<BookBean> bookList = new ArrayList<>();
		for (Entry<String, BookBean> entry : bookMap.entrySet()) {
			BookBean book = entry.getValue();
			if (bookName != null && book.getBookName().contains(bookName)) {
				bookList.add(book);
			}
		}
		return bookList;
	}

}
