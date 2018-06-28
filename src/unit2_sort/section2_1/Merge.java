package unit2_sort.section2_1;

import java.util.Arrays;

/**
 * 归并排序
 * @author beta
 *
 */
public class Merge {
	//原地归并
	public static void merge(char[] arr,int l,int mid,int r) {
		int i = l;
		int j = mid+1;
		char[] a = new char[arr.length];
		for(int k=0;k<arr.length;k++) {
			a[k] = arr[k];
		}
		
		for(int n=0;n<a.length;n++) {
			if(i>mid) {
				//左侧数组用尽
				arr[n] = a[j];
				j++;
			}else if(j>r) {
				//右侧数组用尽
				arr[n] = a[i];
				i++;
			}else if(a[i]<a[j]) {
				arr[n] = a[i];
				i++;
			}else {
				arr[n] = a[j];
				j++;
			}
			System.out.println(Arrays.toString(arr));
		}
	}
	
	public static void main(String[] args) {
		char[] arr = {'e','e','g','m','r','a','c','e','r','t'};
		merge(arr, 0, (arr.length-1)/2, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
}
