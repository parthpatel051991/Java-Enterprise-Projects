package in.ineuron.Solution;

import java.util.Scanner;

import in.ineuron.Customer;

public class BankApp {

	public static void main(String[] args) {

		System.out.println("Welcome to Bank");

		Scanner sc = new Scanner(System.in);

		System.out.println("Entered Details to open account");

		System.out.print("Enter your Full Name :: ");
		String accountHolder = sc.nextLine();

		System.out.print("Enter Your Initial Amount to Open Account :: ");
		Double accountBalance = sc.nextDouble();

		System.out.println("=================================================================");
		
		Customer customer = new Customer(null, accountHolder, accountBalance);

		System.out.println("===================================================================");
		System.out.println("How can we help you today ?");

		Boolean flag = true;
		while (flag) {
			System.out.println("============================================================");
			System.out.println("Choose your Operations ");
			System.out.println("1.Deposit ");
			System.out.println("2.Withdraw ");
			System.out.println("3.Check Balance ");
			System.out.println("4.Exit ");
			System.out.println("===========================================================");

			System.out.println("Enter your option::");
			int option = sc.nextInt();

			switch (option) {
			case 1:
				System.out.print("Enter your Deposit amount ::");
				Double depoAmt=sc.nextDouble();
				System.out.println(customer.deposit(depoAmt));
				break;
			case 2:
				System.out.print("Enter your Withdrawal amount ::");
				Double withdrawAmt=sc.nextDouble();
				System.out.println(customer.withdraw(withdrawAmt));
				break;
			case 3:
				System.out.println(customer.checkBalance()); 
				break;
			case 4:
				
				flag=false;
				System.out.println("Thank You "+accountHolder+" .. See you again");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
				break;
			}

		}
		
		sc.close();

	}

}
