package com.main;

import java.util.List;
import java.util.Scanner;

import com.lms.bean.BookBean;
import com.lms.bean.UserBean;
import com.lms.bean.UserDetailsBean;
import com.lms.bean.UserType;
import com.lms.service.BookService;
import com.lms.service.UserBookService;
import com.lms.service.UserService;
import com.lms.service.impl.BookServiceImpl;
import com.lms.service.impl.UserBookServiceImpl;
import com.lms.service.impl.UserServiceImpl;

public class LMS {

	private BookService bookService = new BookServiceImpl();
	private UserService userService = new UserServiceImpl();
	private UserBookService userBookService = new UserBookServiceImpl();

	public static void main(String args[]) {
		LMS lms = new LMS();
		while (true) {
			lms.selectOperation();
		}
	}

	private void selectOperation() {
		System.out.println("1. Add Book");
		System.out.println("2. Add User");
		System.out.println("3. Lend Book");
		System.out.println("4. Retrun Book");
		System.out.println("5. No. Of Book Borrowed by User");
		System.out.println("6. Book Search Book By Title");
		System.out.println("7. Book Search Book By Name");
		System.out.println("8. User Search By userName");
		System.out.println("Select Operation by Entering 1 - 8, enter 9 for Exit.");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		switch (num) {
		case 1:
			addBook();
			break;
		case 2:
			addUser();
			break;
		case 3:
			lendBook();
			break;
		case 4:
			returnBook();
			break;
		case 5:
			bookCountBorrowedByUser();
			break;
		case 6:
			bookSearchByTitle();
			break;
		case 7:
			bookSearchByName();
			break;
		case 8:
			userSearchByUserName();
			break;
		default:
			scan.close();
			System.exit(0);
			break;
		}
		scan.close();
	}

	private void addBook() {
		BookBean bean = new BookBean();
		System.out.print("Enter Book Title: ");
		Scanner scan = new Scanner(System.in);
		String bookTitle = scan.nextLine();
		System.out.print("Enter Book Name: ");
		String bookName = scan.nextLine();
		System.out.print("Enter Book Author: ");
		String author = scan.nextLine();
		bean.setAuthor(author);
		bean.setBookName(bookName);
		bean.setBookTitle(bookTitle);
		bookService.addBook(bean);
		scan.close();
	}

	private void addUser() {
		UserBean user = new UserBean();
		UserDetailsBean userDetailsBean = new UserDetailsBean();
		System.out.print("Enter Username:");
		Scanner scan = new Scanner(System.in);
		String userName = scan.nextLine();
		System.out.print("User type: 1 - Student, 2 - Staff");
		int num = scan.nextInt();
		if (num == 2) {
			user.setUserType(UserType.STAFF);
		} else {
			System.out.println("Invalid type, so by default considering UserType is Student.");
			user.setUserType(UserType.STUDENT);
		}

		System.out.print("Enter Fist Name: ");
		String firstName = scan.nextLine();
		userDetailsBean.setFirstName(firstName);
		System.out.print("Enter Last Name: ");
		String lastName = scan.nextLine();
		userDetailsBean.setLastName(lastName);
		System.out.print("Enter Mobile Number: ");
		String mobile = scan.nextLine();
		userDetailsBean.setMobileNo(mobile);
		System.out.print("Enter Email id: ");
		String email = scan.nextLine();
		userDetailsBean.setEmail(email);
		user.setUserName(userName);
		user.setUserDetails(userDetailsBean);
		userService.addUser(user);
		scan.close();
	}

	private void lendBook() {
		System.out.print("Enter UserId:");
		Scanner scan = new Scanner(System.in);
		String userId = scan.nextLine();

		System.out.print("Enter BookId:");
		String bookId = scan.nextLine();
		boolean lend = userBookService.lendBook(userId, bookId);

		if (lend) {
			System.out.println("Book issued.");
		} else {
			System.out.println("Book Cannot be issued.");
		}
		scan.close();
	}

	private void returnBook() {
		System.out.print("Enter UserId:");
		Scanner scan = new Scanner(System.in);
		String userId = scan.nextLine();

		System.out.print("Enter BookId:");
		String bookId = scan.nextLine();
		boolean returnSuccess = userBookService.lendBook(userId, bookId);

		if (returnSuccess) {
			System.out.println("Book Successfully Returned.");
		} else {
			System.out.println("Book Returned Fail.");
		}
		scan.close();
	}

	private void bookCountBorrowedByUser() {
		System.out.print("Enter UserId:");
		Scanner scan = new Scanner(System.in);
		String userId = scan.nextLine();
		int booksCount = userBookService.noOfBooksTakenByUser(userId);

		System.out.println("Books count by User - " + booksCount);
		scan.close();
	}

	private void bookSearchByTitle() {
		System.out.print("Enter Title:");
		Scanner scan = new Scanner(System.in);
		String title = scan.nextLine();
		List<BookBean> books = bookService.searchByTitle(title);
		System.out.println("No.Of books found in search is : " + books.size());
		for (BookBean book : books) {
			System.out.println(book.getBookTitle());
		}
		scan.close();
	}

	private void bookSearchByName() {
		System.out.print("Enter Name:");
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		List<BookBean> books = bookService.searchByTitle(name);
		System.out.println("No.Of books found in search is : " + books.size());
		for (BookBean book : books) {
			System.out.println(book.getBookName());
		}
		scan.close();
	}

	private void userSearchByUserName() {
		System.out.print("Enter Username:");
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		List<UserBean> users = userService.usersByName(name);
		System.out.println("No.Of Users found in search is : " + users.size());
		for (UserBean user : users) {
			System.out.println(user.getUserName());
		}
		scan.close();
	}
}
