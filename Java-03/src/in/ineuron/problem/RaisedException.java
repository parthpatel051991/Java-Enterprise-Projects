package in.ineuron.problem;

import java.util.Scanner;

public class RaisedException {


	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Entered your Number ::");
		int num = sc.nextInt();
		
		if(num<0) {
			throw new RuntimeException("Negative Number not allowed");
		}else {
			System.out.println("Entered number is ::"+num);
		}
	}
	
	
	
}
