package unit2_sort.section2_4.heap;

import unit2_sort.section2_1.SortUtil;
import unit2_sort.section2_4.MaxPQ;

/**
 * 优先队列
 * 二叉堆实现
 * @author beta
 *
 */
public class HeapPQ<T> implements MaxPQ<T>{

	private T[] arr;
	
	private int size;
	
	public HeapPQ() {
		arr = (T[]) new Object[10];
	}
	
	public HeapPQ(T[] arr) {
		this.arr = (T[]) new Object[arr.length];
		for (T t : arr) {
			insert(t);
		}
	}
	
	@Override
	public void insert(T v) {
		arr[size] = v;
		swim(size);
		size++;
		if (size >= arr.length) {
			resize(arr.length * 2);
		}
	}

	@Override
	public T max() {
		return arr[0];
	}

	@Override
	public T delMax() {
		T temp = arr[0];
		arr[0] = arr[size - 1];
		arr[size - 1] = null;
		size--;
		sink(0);
		if (size <= arr.length / 4 && arr.length / 2 != 0) {
			resize(arr.length / 2);
		}
		return temp;
	}

	//下沉
	private void sink(int i) {
		while ((2 * i + 1) <= size-1) {
			int k = 2 * i + 1;
			if (k < size - 1 && SortUtil.less((Comparable)arr[k], (Comparable)arr[k +1])) {
				k++;
			}
			if (SortUtil.less((Comparable)arr[i], (Comparable)arr[k])) {
				SortUtil.exch(arr, k, i);
				i = k;
				continue;
			}
			break;
		}
	}
	
	//上浮
	private void swim(int i) {
		while (i > 0) {
			int k = (i - 1) / 2;
			if (SortUtil.less((Comparable)arr[k], (Comparable)arr[i])) {
				SortUtil.exch(arr, i, k);
				i = k;
				continue;
			}
			break;
		}
 	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	private void resize(int i) {
		T[] newArr = (T[]) new Object[i];
		System.arraycopy(arr, 0, newArr, 0, size);
		arr = newArr;
	}
	
}
