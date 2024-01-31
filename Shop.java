package miniproject;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

interface AuthFun {
	boolean authenticate(String usrname, String password);
}

public class Shop {
	static HashMap<String, String> userMap = new HashMap<>();

	static Scanner sc = new Scanner(System.in);
	static Products pr = new Products();

	public static void main(String[] args) {
		Shop app = new Shop();

		userMap.put("Sam", "1234");
		userMap.put("Jai", "12345");

		System.out.println("------WELCOME TO ONLINE SHOPPING SYSTEM----- \n");
		System.out.println("Enter User Name : ");
		String userName = sc.next();
		System.out.println("Enter password : ");
		String password = sc.next();
		boolean result = app.validate(userName, password);

		if (!result) {
			System.out.println("Invalid Username And Password");
			System.out.println("Try Again !!");

		} else {
			System.out.println("!!  Login Successfull  !!");
			System.out.println();
			boolean status = false;
			while (!status) {
				displayMenu();
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					Register();
					break;
				case 2:
					login();
					break;
				case 3:
					buyProduct();
					break;
				case 4:
					cancelProduct();
					break;
				case 5:
					pr.displayAllProducts();
					break;
				case 6:
					logout();
					break;
				case 7:
					status = true;
					break;
				default:
					System.out.println("Invalid choice");
				}
			}
		}
	}

	public boolean validate(String username, String password) {

		AuthFun authFun = (u, p) -> u.equals("Customer") && p.equals("Customer");
		return authFun.authenticate(username, password);
	}

	private static void displayMenu() {
		System.out.println("=================================\n");
		System.out.println("1. Register");
		System.out.println("2. Log in");
		System.out.println("3. Buy product");
		System.out.println("4. Cancel product");
		System.out.println("5. Display all products");
		System.out.println("6. Sign out");
		System.out.println("7. Exit");
		System.out.println("==================================\n");
		System.out.print("Enter your choice: \n");
		System.out.println("==================================\n");
	}

	private static void Register() {
		System.out.print("Enter username: ");
		String rusername = sc.next();
		System.out.print("Enter password: ");
		String rpassword = sc.next();

		System.out.print("Registration successful ");
	}

	private static void login() {
		System.out.print("Enter username: ");
		String username = sc.next();
		System.out.print("Enter password: ");
		int password = sc.nextInt();

		if (username.equals(userMap)) {
			System.out.print("Login sucessful ");

		}

		else {
			System.out.print("Login Unsucessful ");
		}
	}

	private static void buyProduct() {
		int loggedInUser = 0;
		if (loggedInUser == 0) {
			System.out.print("Enter product name: ");
			String productName = sc.next();
			System.out.print("Enter product price: ");

			double productPrice = sc.nextDouble();
			pr.buyProduct(productName, productPrice);
		} else {
			System.out.println("You need to log in first");
		}
	}

	private static void cancelProduct() {
		int loggedInUser = 0;
		if (loggedInUser == 0) {
			System.out.print("Enter product name: ");
			String productName = sc.next();
			pr.cancelProduct(productName);
		} else {
			System.out.println("You need to log in first");
		}
	}

	private static void logout() {
		System.out.println("Logged out");
	}
}
