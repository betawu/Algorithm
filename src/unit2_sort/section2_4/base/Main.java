package unit2_sort.section2_4.base;

import unit2_sort.section2_4.MaxPQ;
import unit2_sort.section2_4.heap.HeapPQ;

public class Main {
	public static void main(String[] args) {
		Integer[] arr = new Integer[] {
				4,2,36,42,66,1,26,23,1,12,24,56,88,8,9,3,31
		};
//		ArrayOutOfOrderPQ<Integer> pq = new ArrayOutOfOrderPQ<>(arr);
//		MaxPQ<Integer> pq = new ArrayInOrderPQ<>(arr);
//		MaxPQ<Integer> pq = new LinkedListPQ<>(arr);
		MaxPQ<Integer> pq = new HeapPQ<>(arr);
		while (!pq.isEmpty()) {
			System.out.print(pq.delMax()+" ");
		}
		
		
	}
}
