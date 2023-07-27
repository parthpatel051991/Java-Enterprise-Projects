package in.ineuron;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApiMethods {

	
	public static void main(String[] args) {
		
		//filtering objects from Array list
		
		ArrayList<Integer> list = new ArrayList<>();
		
		list.add(0);
		list.add(10);
		list.add(33);
		list.add(55);
		list.add(60);
		list.add(23);
		
		System.out.println("list :: "+list);
		
		List<Integer> evenlist = list.stream().filter((i)-> i %2 ==0).collect(Collectors.toList());
		
		System.out.println("Filtered list with even number ::"+evenlist);
		
		// evenlist.forEach(System.out::println);
		
		System.out.println("=======================================================================");
		
		//Sorting collections
		
		System.out.println("Before sorting :: "+list);
		
		//using Stream Api
		
		//over here behind the scene Comparable(predefined api for natural sorting order) is used -- compareTo(Object obj)
		List<Integer> naturalSortedlist = list.stream().sorted().collect(Collectors.toList());
		
		System.out.println("After sorting ::"+naturalSortedlist);
		
		//Customized sorting by using Comparator (for userdefined class for cutomized sorting order)-> compare(Obj1,Obj2)
		
		
		List<Integer> decsendingSortedList = list.stream().sorted((i1,i2)-> i2.compareTo(i1)).collect(Collectors.toList());
		
		System.out.println("After sorting in decsending order ::"+decsendingSortedList);
		
		
	}
}
