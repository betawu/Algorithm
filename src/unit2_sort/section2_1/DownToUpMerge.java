package unit2_sort.section2_1;

import java.util.Arrays;

/**
 * 自下而上归并排序
 * @author beta
 *
 */
public class DownToUpMerge {
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
	
	public static void sort(char[] arr) {
		int len = arr.length;
		aux = new char[len];
		//从小数组合并到大数组
		for(int sz =1;sz<len;sz +=sz) {
			for(int l=0;l<len;l+=sz+sz) {
				merge(arr, l, l+sz-1, Math.min(l+sz+sz-1, len-1));//mid是右边界索减去左边界索引引除以2 不是整个区间长度
			}
		}
	}
	
	public static void main(String[] args) {
		char[] a = {'m','e','r','g','e','s','o','r','t','e','x','a','m','p','l','e'};
		sort(a);
		System.out.println(Arrays.toString(a));
	}
}
