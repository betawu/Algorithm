package unit2_sort;

import java.util.Arrays;

/**
 * 希尔排序
 * @author beta
 *
 */
public class Shell {
	public static void sort(char[] arr) {
		int l = arr.length;
		int h =1;
		while(h<l) {
			h = h*3+1;
		}
		h/=3;
		while(h>0) {
			for(int i=h;i<l;i++) {
				for(int j=i;j>=h&&arr[j-h]>arr[j];j-=h) {
					char temp = arr[j-h];
					arr[j-h] = arr[j];
					arr[j] = temp;
				}
			}
			h/=3;
			System.out.println(Arrays.toString(arr));
		}
		
	}
	
	public static void main(String[] args) {
		char[] arr = {'s','h','e','l','l','s','o','r','t','e','x','a','m','p','l','e'};
		Shell.sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
