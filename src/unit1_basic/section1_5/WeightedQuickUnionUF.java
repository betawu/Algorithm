package unit1_basic.section1_5;

import java.util.Arrays;

/**
 * 加权并查集
 * @author beta
 *
 */
public class WeightedQuickUnionUF implements UF{

	private int[] arr;
	private int count;
	//每个节点所连接的节点的数量
	private int[] num;
	
	public WeightedQuickUnionUF(int n) {
		arr = new int[n];
		num = new int[n];
		for(int i=0;i<arr.length;i++) {
			arr[i] = i;
			num[i] = 1;
		}
		count = n;
	}
	
	@Override
	public void union(int p, int q) {
		if(find(p)!=find(q)) {
			if(num[find(p)]>=num[find(q)]) {
				arr[find(q)] = find(p);
				num[find(p)]+=num[find(q)];
			}else {
				arr[find(p)] = find(q);
				num[find(q)] +=num[find(p)];
			}
			count--;
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
		return find(p)==find(q);
	}

	@Override
	public int count() {
		return count;
	}

	public static void main(String[] args) {
		WeightedQuickUnionUF uf = new WeightedQuickUnionUF(8);
		uf.union(0, 1);
		uf.union(2, 3);
		uf.union(4, 5);
		uf.union(6, 7);
		uf.union(0, 2);
		uf.union(4, 6);
		uf.union(0, 4);
		System.out.println(uf.count());
		
		System.out.println(Arrays.toString(uf.arr));
	}
}
