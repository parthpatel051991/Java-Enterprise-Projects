package in.ineuron;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	
	public static void main(String[] args) {
		
		int []a = {45,54,23,67,8,9,34,12,40};
		System.out.println("array is ::" +Arrays.toString(a));
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the key to be found ::");
		int key = sc.nextInt();
		
		Binary.binarySearchInteger(key, a);

	}

}
