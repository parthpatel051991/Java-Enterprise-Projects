package in.ineuron;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SecondSmallestLargest {

	public static int findSecondLargestNumber(List<Integer> list) {

		if (list.size() < 2) {
			throw new IllegalArgumentException("List must have atleast 2 Elements.");
		}

		Collections.sort(list);

		return list.get(list.size() - 2);
	}

	public static int findSecondSmallestNumber(List<Integer> list) {

		if (list.size() < 2) {
			throw new IllegalArgumentException("List must have atleast 2 Elements.");
		}

		Collections.sort(list);

		return list.get(1);
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the number for integers :: ");
		int count = sc.nextInt();

		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < count; i++) {

			System.out.print("Enter the integer no " + (i + 1) + " :: ");
			int element = sc.nextInt();
			list.add(element);
		}

		
			System.out.println("Second Largest Number is :: " + findSecondLargestNumber(list));
			System.out.println("Second Smallest Number is :: " + findSecondSmallestNumber(list));
		
		
		sc.close();

	}

}
