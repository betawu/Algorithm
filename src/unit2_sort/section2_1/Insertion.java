package unit2_sort.section2_1;

import java.util.Arrays;

/**
 * 插入排序
 * @author beta
 *
 */
public class Insertion {
	public static void sort(int[] arr) {
		for(int i=1;i<arr.length;i++) {
			for(int j=i;j>0;j--) {
				if(arr[j]<arr[j-1]) {
					exchange(arr,j,j-1);
				}else {
					break;
				}
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}

	private static void exchange(int[] arr,int j, int i) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp; 
	}
	
	public static void main(String[] args) {
		int[] arr = {3,4,2,1,6,9,8,7,5};
		Insertion.sort(arr);
	}
}
