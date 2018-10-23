package unit2_sort.section2_1;

public class SortUtil {

	public static <T extends Comparable<T>> boolean less(T v, T w) {
		return v.compareTo(w) < 0;
	}
	
	public static <T extends Comparable<T>> void exch(T[] arr, int i, int j) {
		T temp = arr[i];
		arr[j] = arr[i];
		arr[i] = temp;
	}
	
	public static <T extends Comparable<T>> boolean isSort(T[] arr) {
		for (int i = 0; i < arr.length-1; i++) {
			if (arr[i].compareTo(arr[i + 1]) > 0) {
				return false;
			}
		}
		return true;
	}
	
}
