package firstWeek.unionfind;

import java.util.Arrays;

public class QuickFind {
	private int[] ids;
	
	public QuickFind(int n) {
		this.ids = new int[n];
		for(int i=0;i<n;i++) {
			ids[i] = i;
		}
	}
	
	public void union(int p,int q) {
		int pn = ids[p];
		int qn = ids[q];
		for(int i=0;i<ids.length;i++) {
			if(ids[i] == pn) {
				ids[i] = qn;
			}
		}
	}
	
	public boolean connected(int p , int q) {
		return ids[p] == ids[q];
	}
	
	public static void main(String[] args) {
		QuickFind uf = new QuickFind(10);
		uf.union(1, 2);
		uf.union(3, 4);
		uf.union(5, 6);
		uf.union(7, 8);
		uf.union(9, 8);
		uf.union(0, 5);
		System.out.println(uf.connected(1, 8));
		System.out.println(Arrays.toString(uf.ids));
	}
}
