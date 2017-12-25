package com.lms.persistence;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.lms.bean.UserBean;
import com.lms.bean.UserBookTransactionBean;

public class UserBookDao {

	UserDao userDao = new UserDao();

	private Map<String, UserBookTransactionBean> userBookMap = new HashMap<>();

	public boolean lendBook(String userId, String bookId) {
		boolean lend = false;
		UserBookTransactionBean bookTransactionBean = userBookMap.get(userId);
		if (bookTransactionBean == null) {
			bookTransactionBean = new UserBookTransactionBean();
			bookTransactionBean.setUserId(userId);
			bookTransactionBean.getBooks().add(bookId);
			bookTransactionBean.setStartDate(new Date());
			lend = true;
		} else {
			UserBean userBean = userDao.getUser(userId);
			if (bookTransactionBean.getBooks().size() <= userBean.getUserType().getBookLimit()) {
				bookTransactionBean.getBooks().add(bookId);
				userBookMap.put(userId, bookTransactionBean);
				lend = true;
			}
		}
		return lend;
	}

	public boolean returnBook(String userId, String bookId) {
		boolean returnSuccess = false;
		UserBookTransactionBean bookTransactionBean = userBookMap.get(userId);
		if (bookTransactionBean != null) {
			bookTransactionBean.getBooks().remove(bookId);
			userBookMap.put(userId, bookTransactionBean);
			returnSuccess = true;
		}
		return returnSuccess;
	}

	public int booksCountByUser(String userId) {
		UserBookTransactionBean bookTransactionBean = userBookMap.get(userId);
		if (bookTransactionBean != null) {
			return bookTransactionBean.getBooks().size();
		}
		return 0;
	}

}
