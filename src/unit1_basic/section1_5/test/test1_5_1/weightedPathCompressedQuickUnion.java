package unit1_basic.section1_5.test.test1_5_1;

import java.util.Arrays;

import unit1_basic.section1_5.UF;

/**
 * 带权重的路径压缩quick-union算法
 * @author beta
 *
 */
public class weightedPathCompressedQuickUnion implements UF{

	private int[] arr;
	private int[] num;
	private int count;
	
	public weightedPathCompressedQuickUnion(int n) {
		arr = new int[n];
		num = new int[n];
		count = n;
		for(int i=0;i<arr.length;i++) {
			arr[i] = i;
			num[i] = 1;
		}
	}
	
	@Override
	public void union(int p, int q) {
		p = find(p);
		q = find(q);
		if(p!=q) {
			if(num[p] >= num[q]) {
				arr[q] = p;
				num[p] +=num[q];
			}else {
				arr[p] = q;
				num[q] += num[p];
			}
			count--;
		}
	}

	@Override
	public int find(int p) {
		int i = p;
		while(p!=arr[p]) {
			p = arr[p];
		}
		
		while(i!=arr[i]) {
			int index = i;
			i = arr[i];
			arr[index] = p;
		}
		
		return p;
	}

	@Override
	public boolean connected(int p, int q) {
		return find(q)==find(p);
	}

	@Override
	public int count() {
		return count;
	}

	public static void main(String[] args) {
		weightedPathCompressedQuickUnion uf = new weightedPathCompressedQuickUnion(8);
		uf.union(0, 1);
		uf.union(2, 3);
		uf.union(4, 5);
		uf.union(6, 7);
		uf.union(0, 2);
		uf.union(4, 6);
		uf.union(0, 4);
		System.out.println(uf.count());
		
		System.out.println(Arrays.toString(uf.arr));
		uf.find(7);
		System.out.println(Arrays.toString(uf.arr));
	}
}
