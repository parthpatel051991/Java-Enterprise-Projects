package in.ineuron;

import java.util.Arrays;

public class Binary {

	public static void binarySearchInteger(int key, int[] arr) {

		Arrays.sort(arr);
		
	//	System.out.println(Arrays.toString(arr));

		int low = 0;
		int high = arr.length - 1;

		while (low <= high) {

			int mid = low + high;

			if (key == arr[mid]) {
				System.out.println("Key :: " + key + " is found at index:: " + mid);
				break;
			} else if (key < arr[mid]) {
				high = mid - 1;
			} else if (key > arr[mid]) {
				low = mid + 1;
			}

		}

		if (low > high) {
			System.out.println("key is not found ");
		}

	}
}
