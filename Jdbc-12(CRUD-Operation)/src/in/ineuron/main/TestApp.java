package in.ineuron.main;

import java.sql.SQLException;
import java.util.Scanner;

import in.ineuron.apps.Delete;
import in.ineuron.apps.Insert;
import in.ineuron.apps.Select;
import in.ineuron.apps.Update;

public class TestApp {

	public static void main(String[] args) {
		
		String reply;

		Scanner scanner = new Scanner(System.in);

		do {
			
			try {
				System.out.println("Welcome to Student Database. Choose the option for your task from the Menu.");
				System.out.println();
				System.out.println("Opertation Menu \n" + "1.Check All Student details \n" + "2.Insert data \n" + "3.Update data \n"
						+ "4.Delete data");
				System.out.println("select your option: ");
				int option = Integer.parseInt(scanner.nextLine());

				System.out
						.println("===================================================================================");

				switch (option) {
					case 1:
						Select.selectApp();
						break;
					case 2:
						Insert.insertApp();
						break;
					case 3:
						Update.updateApp();
						break;
					case 4:
						Delete.deleteApp();
						break;
					default:
						System.out.println("choose valid option . Thank you");
						break;
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				System.out.println("Continue ? Reply Yes to continue or/ to exit enter No ");
				reply = scanner.nextLine();
				System.out.println("====================================================");
			}
						
		} while (reply.equalsIgnoreCase("yes"));

		scanner.close();

	}


	}


