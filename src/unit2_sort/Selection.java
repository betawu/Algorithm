package unit2_sort;

import java.util.Arrays;

/**
 * 选择排序
 * @author beta
 *
 */
public class Selection {
	public static void sort(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			int min = i;
			for(int j=i;j<arr.length;j++) {
				if(arr[min]>arr[j]) {
					min = j;
				}
			}
			exchange(arr,min,i);
		}
		
		show(arr);
	}

	private static void show(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}

	private static void exchange(int[] arr,int min, int i) {
		int temp = arr[min];
		arr[min] = arr[i];
		arr[i] = temp;
	}
	
	public static void main(String[] args) {
		int[] arr = {3,4,2,1,6,9,8,7,5};
		Selection.sort(arr);
	}
}
