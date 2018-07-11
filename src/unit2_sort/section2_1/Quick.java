package unit2_sort.section2_1;

import java.util.Arrays;

/**
 * 快速排序
 * @author beta
 *
 */
public class Quick {
	public static void sort(char[] arr,int l,int r) {
		if(l >= r) {
			return ;
		}
		int j = partition(arr,l,r);
		sort(arr,l,j-1);
		sort(arr,j+1,r);
	}

	
	private static int partition(char[] arr, int l, int r) {
		char v = arr[l];
		int j = l;
		for(int i=l+1 ;i<=r;i++) {
			if(arr[i]<v) {
				swap(arr,j+1,i);
				j++;
			}
		}
		swap(arr,l,j);
		return j;
	}
	
	private static void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void main(String[] args) {
		char[] arr = {
				'k','r','a','t','e','l','e','p','u','i','m','q','c','x','o','s'
		};
		
		Quick.sort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
}
