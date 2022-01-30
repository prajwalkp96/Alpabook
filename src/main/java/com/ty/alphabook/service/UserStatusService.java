package com.ty.alphabook.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ty.alphabook.dao.UserStatusDao;
import com.ty.aplhabook.dto.Status;
import com.ty.aplhabook.dto.User;

public class UserStatusService {

	Scanner s = new Scanner(System.in);
	User user = new User();
	Status status = new Status();
	UserStatusDao userStatusDao = new UserStatusDao();

	public void insertUser() {
		System.out.println("******************ALPHA BOOK*************************");
		System.out.println("1.LOGIN \n2.SIGNUP");
		System.out.println("ENTER YOUR CHOICE");
		int choice = s.nextInt();

		switch (choice) {
		case 1: {
			System.out.println("enter user email id");
			String mail = s.next();
			User user = userStatusDao.checkLogin(mail);

			if (user != null && user.getMailid().equals(mail)) {
				System.out.println("enter user password");
				String pwd = s.next();
				if (user.getPassword().equals(pwd)) {
					System.out.println("----------------------------------------------------------------------------");
					System.out.println("LOGIN SUCCESSFULL");
					System.out.println(
							"************ WELCOME " + user.getFirstname() + " " + user.getLastname() + "***********");
					System.out.println("LOGIN TIME :" + LocalTime.now());
					System.out.println("----------------------------------------------------------------------------");
					System.out.println("FIRST NAME: " + user.getFirstname());
					System.out.println("LAST NAME: " + user.getLastname());
					List<Status> statuslist = user.getStatus();
					int count = 1;
					if (status != null) {
						for (Status sta : statuslist)
							System.out.println("OLD STATUS :" + count++ + " " + sta.getStatus());
						System.out.println("DATE :" + status.getDate());
					}
				} else {
					System.out.println("INCORRECT PASSWORD");
					for (int i = 1; i <= 3; i++) {
						System.out.println("ENTER VALID PASSWORD");
						pwd = s.next();
						if (!(pwd.equals(user.getPassword()))) {
							System.out.println("RE-ENTER VALID PASSWORD");
						} else {
							System.out.println("LOGIN SUCCESSFULL");
							System.out.println(
									"************ WELCOME " + user.getFirstname() + " " + user.getLastname() + "***********");
							System.out.println("LOGIN TIME :" + LocalTime.now());
							System.out.println("----------------------------------------------------------------------------");
							System.out.println("FIRST NAME: " + user.getFirstname());
							System.out.println("LAST NAME: " + user.getLastname());
							List<Status> statuslist = user.getStatus();
							int count = 1;
							if (status != null) {
								for (Status sta : statuslist)
									System.out.println("OLD STATUS :" + count++ + " " + sta.getStatus());
								System.out.println("DATE :" + status.getDate());
							}
							break;
						}
					}
				}
			} else {
				System.out.println("Incorrect Mail-ID");
			}
		}
			break;
		case 2: {
			System.out.println("Enter email Id");
			String mail = s.next();
			System.out.println("Enter password");
			String pwd = s.next();
			System.out.println("Enter first name");
			String first_name = s.next();
			System.out.println("Enter second name");
			String second_name = s.next();
			System.out.println("Enter contact number");
			long contact = s.nextLong();
			System.out.println("Enter date of birth");
			String dob = s.next();
			System.out.println("Enter gender");
			String gender = s.next();
			user.setMailid(mail);
			user.setPassword(pwd);
			user.setFirstname(first_name);
			user.setLastname(second_name);
			user.setContactno(contact);
			user.setDob(dob);
			user.setGender(gender);
			System.out.println("1.SUMBIT \n2.CANCEL");
			System.out.println("ENTER YOUR CHOICE: ");
			int ch2 = s.nextInt();
			switch (ch2) {
			case 1: {
				userStatusDao.saveUser(user);
				System.out.println("User Signup Successfull");
			}
				break;
			case 2: {
				System.out.println("Singup Cancelled");
			}
				break;
			}
		}
		}
	}

	public void insertstatus() {
		System.out.println("enter user email id");
		String mail = s.next();
		User user = userStatusDao.checkLogin(mail);

		if (user != null && user.getMailid().equals(mail)) {
			System.out.println("enter user password");
			String pwd = s.next();
			if (user.getPassword().equals(pwd)) {
				System.out.println("1.POST STATUS \n2.LOGOUT");
				System.out.println("ENTER YOUR CHOICE");
				int ch = s.nextInt();
				switch (ch) {
				case 1: {
					Status status1 = new Status();
					System.out.println("Post Your Status");
					String st = s.next();
					status.setStatus(st);
					status.setDate(LocalDate.now());
					status.setTime(LocalTime.now());
					List<Status> list1 = new ArrayList<Status>();
					list1 = user.getStatus();
					list1.add(status);
					user.setStatus(list1);
					userStatusDao.postStatus(status, user);
					System.out.println("Status added successfully");
				}
					break;
				case 2: {
					System.out.println("Logout Successfull");
				}
					break;
				}
			} else {
				System.out.println("Invalid Password");
			}
		} else {
			System.out.println("Invalid User Id");
		}
	}
}
