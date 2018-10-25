package unit2_sort.section2_4.base;

import unit2_sort.section2_1.SortUtil;
import unit2_sort.section2_4.MaxPQ;

/**
 * 优先队列
 * 初级实现  数组（有序）
 * @author beta
 *
 */
public class ArrayInOrderPQ<T> implements MaxPQ<T>{

	private T[] arr;
	
	private int size;
	
	public ArrayInOrderPQ() {
		arr = (T[]) new Object[10];
	}
	
	public ArrayInOrderPQ(T[] arr) {
		this.arr = (T[]) new Object[2 * arr.length];
		for (T t : arr) {
			insert(t);
		}
	}
	
	@Override
	public void insert(T v) {
		T[] newArr = (T[]) new Object[arr.length];
		boolean flag = true;
		if (size == 0) {
			arr[0] = v;
			size++;
			return ;
		}
		for (int i = 0; i < size; i++) {
			if(flag) {
				if (SortUtil.less((Comparable)v, (Comparable)arr[i])) {
					newArr[i] = v;
					newArr[i+1] = arr[i];
					flag = false;
				}
				else {
					newArr[i] = arr[i];
				}
			}
			else {
				newArr[i+1] = arr[i];
			}
		}
		if (flag) {
			newArr[size] = v;
		}
		arr = newArr;
		size++;
		if (size >= arr.length) {
			resize(2 * arr.length);
		}
	}

	@Override
	public T max() {
		return arr[size-1];
	}

	@Override
	public T delMax() {
		size--;
		T temp = arr[size];
		arr[size] = null;
		if (size <= arr.length / 4 && arr.length / 2 != 0) {
			resize(arr.length / 2);
		}
		
		return temp;
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
