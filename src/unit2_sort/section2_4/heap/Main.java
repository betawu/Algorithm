package unit2_sort.section2_4.heap;

public class Main {

	public static void main(String[] args) throws Exception {
		Integer[] arr = new Integer[] {
				4,2,36,42,66,1,26,23,1,12,24,56,88,8,9,3,31
		};
		IndexMaxHeap<Integer> pq = new IndexMaxHeap<>(arr.length);
		for (int i = 0; i < arr.length; i++) {
			pq.insert(i, arr[i]);
		}
		
		while (!pq.isEmpty()) {
			System.out.print(pq.delMax() + " ");
		}
	}
}
