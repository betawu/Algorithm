package unit2_sort.section2_1;

import java.util.Arrays;

/**
 * 归并排序
 * @author beta
 *
 */
public class Merge {
	//辅助函数
	private static char[] aux;
	
	//原地归并
	public static void merge(char[] arr,int l,int mid,int r) {
		int i = l;
		int j = mid+1;
		
		for(int k=l;k<=r;k++) {
			aux[k] = arr[k];
		}
		
		for(int n=l;n<=r;n++) {
			if(i>mid) {
				//左侧数组用尽
				arr[n] = aux[j];
				j++;
			}else if(j>r) {
				//右侧数组用尽
				arr[n] = aux[i];
				i++;
			}else if(aux[i]<aux[j]) {
				arr[n] = aux[i];
				i++;
			}else {
				arr[n] = aux[j];
				j++;
			}
		}
	}
	
	//自上到下归并排序
	public static void sort(char[] arr) {
		aux = new char[arr.length];
		sort(arr,0,arr.length-1);
	}
	
	private static void sort(char[] arr, int l, int r) {
		if(l==r) {
			return ;
		}
		
		int mid = l+(r-l)/2;
		sort(arr, l, mid);
		sort(arr, mid+1, r);
		merge(arr, l, mid, r);
	}

	public static void main(String[] args) {
//		char[] arr = {'e','e','g','m','r','a','c','e','r','t'};
//		merge(arr, 0, (arr.length-1)/2, arr.length-1);
//		System.out.println(Arrays.toString(arr));
		
		char[] a = {'m','e','r','g','e','s','o','r','t','e','x','a','m','p','l','e'};
		sort(a);
		System.out.println(Arrays.toString(a));
	}
}
