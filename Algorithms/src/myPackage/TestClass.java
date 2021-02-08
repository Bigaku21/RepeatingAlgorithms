package myPackage;

import java.util.Iterator;

public class TestClass {

	public static void main(String[] args) {
		testSorting(new BubbleSort());
		testSearch(new BinarySearch());
	}
	
	static void testSorting(Sorting sort) {
		int[] array= {4,1,6,8,3,8888,34,333,4356,2,54,6778};
		ArrayToString("Unsorted",array);
		sort.sort(array, true);
		ArrayToString("Sorted asc",array);
		sort.sort(array, false);
		ArrayToString("Sorted desc",array);
	}
	
	static void testSearch(Search search) {
		int[] array= {4,1,6,8,3,8888,34,333,4356,2,54,6778};
		int index = search.searchInt(array, 333);
		System.out.println("Found at index "+index);
	}
	
	static void ArrayToString(String name, int[] array) {
		String str = name+ " array:";
		for (int i = 0; i < array.length; i++) {
			str += " " + array[i];
		}
		System.out.println(str);
	}
	
}
