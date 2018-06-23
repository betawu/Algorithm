package unit1_basic.section1_5;

import java.util.LinkedList;
import java.util.Queue;

/**
 * quick-find 并查集
 * @author beta
 *
 */
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
		
		Queue<Integer> m = new LinkedList<>();
		m.add(43);
		m.add(38);
		m.add(65);
		m.add(94);
		m.add(21);
		m.add(89);
		m.add(50);
		m.add(72);
		m.add(61);
		m.add(10);
		m.add(67);
		
		while(!m.isEmpty()) {
			int x = m.remove();
			int i =x/10;
			int j = x - i*10;
			if(uf.find(i)==uf.find(j)) {
				System.out.println(i+"="+j);
			}
			uf.union(i, j);
		}	
		
		System.out.println(uf.count);
	}
}
