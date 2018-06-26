package unit1_basic.section1_5.test.test1_5_1;

import java.util.Arrays;

import unit1_basic.section1_5.UF;

public class QuickFindUF implements UF {

	private int[] id;
	private int count;
	
	public QuickFindUF(int n) {
		id = new int[n];
		for(int i=0;i<n;i++) {
			id[i] = i;
		}
		count = n;
	}
	
	@Override
	public void union(int p, int q) {
		if(find(p)!= find(q)) {
			int n = find(p);
			for(int i=0;i<id.length;i++) {
				if(find(i)==n) {
					id[i] = find(q);
				}
			}
			count--;
			System.out.println(Arrays.toString(id));
		}
	}

	@Override
	public int find(int p) {
		return id[p];
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
		QuickFindUF uf = new QuickFindUF(10);
		uf.union(9, 0);
		uf.union(3, 4);
		uf.union(5, 8);
		uf.union(7, 2);
		uf.union(2, 1);
		uf.union(5, 7);
		uf.union(0, 3);
		uf.union(4, 2);
	}
	
}