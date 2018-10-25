package unit2_sort.section2_4.base;

import java.lang.reflect.Array;

import unit2_sort.section2_1.SortUtil;
import unit2_sort.section2_4.MaxPQ;

/**
 * 优先队列初级实现
 * 
 * 基于数组的乱序的优先队列
 * @author beta
 *
 */
public class ArrayOutOfOrderPQ<T> implements MaxPQ<T>{

	private T[] arr;
	
	private int size;
	
	public ArrayOutOfOrderPQ() {
		arr = (T[]) new Object[10];
		size = 0;
	}
	
	public ArrayOutOfOrderPQ(T[] arr) {
		this.arr = (T[]) new Object[arr.length];
		for (T t : arr) {
			insert(t);
		}
	}
	
	@Override
	public void insert(T v) {
		arr[size] = v;
		
		size++;
		if (size >= arr.length) {
			resize(2 * arr.length);
		}
	}

	private void resize(int i) {
		T[] newArr = (T[]) new Object[i];
		System.arraycopy(arr, 0, newArr, 0, size);
		arr = newArr;
	}

	@Override
	public T max() {
		int i = getMaxIndex();
		return arr[i];
	}

	private int getMaxIndex() {
		int max = 0;
		for (int i = 1; i < size; i++) {
			if (SortUtil.less((Comparable)arr[max], (Comparable)arr[i])) {
				max = i;
			}
		}
		return max;
	}

	@Override
	public T delMax() {
		size--;
		int max = getMaxIndex();
		T rs = arr[max];
		SortUtil.exch(arr, max, size);
		arr[size] = null;
		if (size <= arr.length / 4 && arr.length / 2 != 0) {
			resize(arr.length / 2);
		}
		return rs;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

}
