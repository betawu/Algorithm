package unit1_basic.section1_5.test.test1_5_1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import unit1_basic.section1_5.UF;

/**
 * 随机连接
 * @author beta
 *
 */
public class ErdosRenyi{

	private int[] arr;
	private int[] num;
	private int count;
	private int size;
	
	public ErdosRenyi(int n) {
		arr = new int[n];
		num = new int[n];
		for(int i=0;i<arr.length;i++) {
			arr[i] = i;
			num[i] = 1;
		}
		size = n;
	}
	
	public void union(int p, int q) {
		if(!connected(p, q)) {
			if(num[find(p)]>num[find(q)]) {
				arr[find(q)] = find(p);
				num[find(p)] += num[find(q)];
			}else {
				arr[find(p)] = find(q);
				num[find(q)] +=num[find(p)];
			}
			size--;
			count++;
		}
	}

	public int find(int p) {
		while(p!=arr[p]) {
			p = arr[p];
		}
		return p;
	}

	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	public int size() {
		return size;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		ErdosRenyi erdosRenyi = new ErdosRenyi(Integer.parseInt(s));
		Random r = new Random();
		while(erdosRenyi.size != 1) {
			int p = r.nextInt(Integer.parseInt(s));
			int q = r.nextInt(Integer.parseInt(s));
			erdosRenyi.union(p, q);
		}
		System.out.println(erdosRenyi.count);
		System.out.println(Arrays.toString(erdosRenyi.arr));
	}
}
