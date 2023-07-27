package in.ineuron;

import java.util.Random;

public class Customer implements Bank {

	private Integer accountNo;
	private String accountHolder;
	private Double accountBalance;

	public Customer(Integer accountNo, String accountHolder, Double accountBalance) {
		super();
		this.accountNo = accountNo;
		this.accountBalance = accountBalance;
		this.accountHolder = accountHolder;

		accountNo = (new Random().nextInt(100000000));
		System.out.println("Your Account No is :: " + accountNo);
		System.out.println("A/C holder name is :: " + accountHolder);
		System.out.println("Your Account Balance is ::" + accountBalance);

	}

	@Override
	public String deposit(Double amount) {

		String response = null;

		try {
			if (amount<0) {
				throw new RuntimeException("Invalid amount. Deposit failed.");
			} else {
				accountBalance +=amount;
				response = "Amount deposited :: " + amount + "\n" + "New Account Balanced is ::" + accountBalance;
			}

		} catch (Exception e) {
			response = e.getMessage() + "Please enter valid amount";
		}

		return response;
	}

	@Override
	public String withdraw(Double amount) {

		String response = null;

		try {
			if (amount>0) {
				if (accountBalance < amount) {
					throw new RuntimeException("Insufficient balance. Withdrawal failed.");
				} else {
					accountBalance -=amount;
					response = "Amount witdrawed :: " + amount + "\n" + "New Account Balanced is ::" + accountBalance;
				} 
			}else {
				response ="Invalid amount. Withdrawal failed.Please enter valid amount.";
			}

		} catch (Exception e) {
			response = e.getMessage() + "Please enter right amount";
		}

		return response;
	}

	@Override
	public String checkBalance() {

		return "Your Account Balance is :: " + accountBalance;
	}

}
