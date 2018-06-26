package unit1_basic.section1_5.test.test1_5_1;

import java.util.Arrays;

import unit1_basic.section1_5.UF;

/**
 * 
 * @author beta
 *
 */
public class HeightQuickUnion implements UF{

	private int[] arr;
	private int[] height;
	private int count;
	
	public HeightQuickUnion(int n) {
		arr = new int[n];
		height = new int[n];
		count = n;
		for(int i =0;i<arr.length;i++) {
			arr[i] = i;
			height[i] = 1;
		}
	}
	
	@Override
	public void union(int p, int q) {
		if(!connected(p, q)) {
			if(height[find(p)]>height[find(q)]) {
				arr[find(q)] = find(p);
			}else if(height[find(p)]>height[find(q)]){
				arr[find(q)] = find(p);
				height[find(p)]++;
			}else {
				arr[find(p)] = find(q);
			}
		}
	}

	@Override
	public int find(int p) {
		while(p!=arr[p]) {
			p = arr[p];
		}
		return p;
	}

	@Override
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	@Override
	public int count() {
		return count;
	}
	
	public static void main(String[] args) {
		HeightQuickUnion uf = new HeightQuickUnion(10);
		uf.arr = new int[] {0,0,0,0,4,4,5,6,7,8,9};
		uf.union(3, 6);
		System.out.println(Arrays.toString(uf.arr));
	}

}
