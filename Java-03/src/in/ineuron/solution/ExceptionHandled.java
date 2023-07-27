package in.ineuron.solution;

import java.util.Scanner;

public class ExceptionHandled {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Entered your Number :: ");
		try {
			int num = sc.nextInt();

			if (num < 0) {
				throw new RuntimeException("Negative Number not allowed");
			} else {
				System.out.println("Entered number is ::" + num);
			} 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			sc.close();
		}
	}

}
