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
			System.out.println("Enter '0' to contiue.");
			Scanner scan = new Scanner(System.in);
			int num = scan.nextInt();
			if (num != 0) {
				scan.close();
				break;
			}

		}

	}

	private void selectOperation() {
		Scanner scan = new Scanner(System.in);
		System.out.println("1. Add Book");
		System.out.println("2. Add User");
		System.out.println("3. Lend Book");
		System.out.println("4. Retrun Book");
		System.out.println("5. No. Of Book Borrowed by User");
		System.out.println("6. Book Search Book By Title");
		System.out.println("7. Book Search Book By Name");
		System.out.println("8. User Search By userName");
		System.out.println("Select Operation by Entering 1 - 8, enter 9 for Exit.");

		String num = scan.nextLine();
		switch (num) {
		case "1":
			addBook(scan);
			break;
		case "2":
			addUser(scan);
			break;
		case "3":
			lendBook(scan);
			break;
		case "4":
			returnBook(scan);
			break;
		case "5":
			bookCountBorrowedByUser(scan);
			break;
		case "6":
			bookSearchByTitle(scan);
			break;
		case "7":
			bookSearchByName(scan);
			break;
		case "8":
			userSearchByUserName(scan);
			break;
		default:
			break;
		}
	}

	private void addBook(Scanner scan) {
		BookBean bean = new BookBean();
		System.out.print("Enter Book Title: ");
		String bookTitle = scan.nextLine();
		System.out.print("Enter Book Name: ");
		String bookName = scan.nextLine();
		System.out.print("Enter Book Author: ");
		String author = scan.nextLine();
		bean.setAuthor(author);
		bean.setBookName(bookName);
		bean.setBookTitle(bookTitle);
		bookService.addBook(bean);
		System.out.println("Book added successfully.");
	}

	private void addUser(Scanner scan) {
		UserBean user = new UserBean();
		UserDetailsBean userDetailsBean = new UserDetailsBean();
		System.out.print("Enter Username:");

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
		System.out.println("User added successfully.");

	}

	private void lendBook(Scanner scan) {
		System.out.print("Enter UserId:");

		String userId = scan.nextLine();

		System.out.print("Enter BookId:");
		String bookId = scan.nextLine();
		boolean lend = userBookService.lendBook(userId, bookId);

		if (lend) {
			System.out.println("Book issued.");
		} else {
			System.out.println("Book Cannot be issued.");
		}

	}

	private void returnBook(Scanner scan) {
		System.out.print("Enter UserId:");

		String userId = scan.nextLine();

		System.out.print("Enter BookId:");
		String bookId = scan.nextLine();
		boolean returnSuccess = userBookService.lendBook(userId, bookId);

		if (returnSuccess) {
			System.out.println("Book Successfully Returned.");
		} else {
			System.out.println("Book Returned Fail.");
		}

	}

	private void bookCountBorrowedByUser(Scanner scan) {
		System.out.print("Enter UserId:");

		String userId = scan.nextLine();
		int booksCount = userBookService.noOfBooksTakenByUser(userId);

		System.out.println("Books count by User - " + booksCount);

	}

	private void bookSearchByTitle(Scanner scan) {
		System.out.print("Enter Title:");

		String title = scan.nextLine();
		List<BookBean> books = bookService.searchByTitle(title);
		System.out.println("No.Of books found in search is : " + books.size());
		for (BookBean book : books) {
			System.out.println(book.getBookTitle());
		}

	}

	private void bookSearchByName(Scanner scan) {
		System.out.print("Enter Name:");

		String name = scan.nextLine();
		List<BookBean> books = bookService.searchByTitle(name);
		System.out.println("No.Of books found in search is : " + books.size());
		for (BookBean book : books) {
			System.out.println(book.getBookName());
		}

	}

	private void userSearchByUserName(Scanner scan) {
		System.out.print("Enter Username:");

		String name = scan.nextLine();
		List<UserBean> users = userService.usersByName(name);
		System.out.println("No.Of Users found in search is : " + users.size());
		for (UserBean user : users) {
			System.out.println(user.getUserName());
		}

	}
}
