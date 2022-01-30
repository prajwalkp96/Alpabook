package com.ty.alphabook.controller;

import java.util.Scanner;

import com.ty.alphabook.service.UserStatusService;

public class UserStatusController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		UserStatusService user = new UserStatusService();
		System.out.println("******************ALPHA BOOK*************************");
		for (;;) {
			System.out.println("\n1.ADD USER \n2.UPLOAD STATUS \n3.EXIT");
			System.out.println("ENTER CHOICE: ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				user.insertUser();
			}
				break;
			case 2: {
				user.insertstatus();
			}
				break;
			case 3: {
				System.exit(0);
			}
			default: {
				System.out.println("ENTER VALID CHOICE");
			}

			}

		}
	}
}
