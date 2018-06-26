package unit1_basic.section1_5.test.test1_5_1;

import java.util.Arrays;

import unit1_basic.section1_5.UF;

/**
 * 使用路径压缩的quick-union算法
 * @author beta
 *
 */
public class PathCompressedQuickUnion implements UF{
	private int[] arr;
	private int count;
	
	public PathCompressedQuickUnion(int n) {
		arr = new int[n];
		for(int i=0;i<arr.length;i++) {
			arr[i] = i;
		}
		count = n;
	}

	@Override
	public void union(int p, int q) {
		if(!connected(p, q)) {
			arr[find(p)] = find(q);
			count--;
		}
	}

	@Override
	public int find(int p) {
		int i = p;
		while(p!=arr[p]) {
			p=arr[p];
		}
		
		//路径压缩
		while(i!=arr[i]) {
			int index = i;
			i = arr[i];
			arr[index] = p;
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
		PathCompressedQuickUnion uf = new PathCompressedQuickUnion(10);
		
//		Queue<Integer> m = new LinkedList<>();
//		m.add(43);
//		m.add(38);
//		m.add(65);
//		m.add(94);
//		m.add(21);
//		m.add(89);
//		m.add(50);
//		m.add(72);
//		m.add(61);
//		m.add(10);
//		m.add(67);
//		
//		System.out.println(uf.count);
//		
//		while(!m.isEmpty()) {
//			int x = m.remove();
//			int i =x/10;
//			int j = x - i*10;
//			if(uf.find(i)==uf.find(j)) {
//				System.out.println(i+"="+j);
//			}
//			uf.union(i, j);
//		}	
//		
//		System.out.println(uf.count);
		uf.arr = new int[]{1,1,1,8,3,1,5,1,8,8};
		System.out.println(Arrays.toString(uf.arr));
		uf.find(4);
		System.out.println(Arrays.toString(uf.arr));
	}
	
}
