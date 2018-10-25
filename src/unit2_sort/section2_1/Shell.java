package unit2_sort.section2_1;

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
		Character[] arr = {'s','h','e','l','l','s','o','r','t','e','x','a','m','p','l','e'};
		Shell.sort2(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void sort2(Character[] arr) {
		int l = arr.length;
		int h = 1;
		while (h<l/3) {
			h = 3 * h + 1;
		}
		
		while (h>0) {
		for (int i = h; i < l; i++) {
			for (int j = i; j >= h; j=j-h) {
				if (SortUtil.less(arr[j], arr[j - h])) {
					SortUtil.exch(arr, j, j - h);
				}
			}
		}
		h /= 3;
		}
	}
}
