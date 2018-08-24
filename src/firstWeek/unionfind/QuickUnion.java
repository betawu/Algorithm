package firstWeek.unionfind;

public class QuickUnion {
	private int[] ids;
	
	public QuickUnion(int n) {
		this.ids = new int[n];
		for(int i=0;i<n;i++) {
			ids[i] = i;
		}
	}
	
	private int root(int i) {
		while(i != ids[i]) {
			i = ids[i];
		}
		return i;
	}
	
	public void union(int p,int q) {
		int pn = root(p);
		int qn = root(q);
		ids[pn] = ids[qn];
	}
	
	public boolean connected(int p,int q) {
		return root(p) == root(q);
	}
}
