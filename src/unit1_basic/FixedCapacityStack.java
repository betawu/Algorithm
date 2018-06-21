package unit1_basic;

import java.util.Iterator;
import java.util.Scanner;

/**
 * 
 * @author beta
 *可以动态调整容量大小支持任意数据类型的栈
 */
public class FixedCapacityStack<T> {
	
	//栈中元素数量
	private int n;
	private T[] arr;
	
	public FixedCapacityStack(int capacity) {
		arr = (T[])new Object[capacity];
	}
	
	public void push(T t) {
		if(n == arr.length) {
			resize(arr.length*2);
		}
		arr[n] = t;
		n++;
	}
	
	private void resize(int size) {
		T[] newArr = (T[])new Object[size];
		for(int i=0;i<n ;i++ ) {
			newArr[i] = arr[i];
		}
		arr = newArr;
	}

	public T pop() {
		T rs = arr[n-1];
		arr[n-1] = null;
		n--;
		if(n>0&&n==arr.length/4) {
			resize(arr.length/2);
		}
		return rs;
	}
	
	public boolean isEmpty() {
		return n == 0;
	}
	
	public int size() {
		return n;
	}
	
	
	//自定义迭代器
	private class ReverseArrayIterator<T> implements Iterator<T>{

		private int i = n;
		private T[] a =(T[]) arr;
		
		@Override
		public boolean hasNext() {
			return i>0;
		}

		@Override
		public T next() {
			i--;
			return a[i];
		}
		
	}
	
	//使栈可以使用迭代器遍历
	public ReverseArrayIterator<T> iterator(){
		return new ReverseArrayIterator<>();
	}
	
	public boolean isFull() {
		return arr.length==n;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		FixedCapacityStack<String> stack = new FixedCapacityStack<>(1);
		while(!sc.hasNext("q")) {
			String s = sc.next();
			if(s.equals("-")) {
				System.out.println(stack.pop());
			}else {
				stack.push(s);
			}
		}
		
		FixedCapacityStack<String>.ReverseArrayIterator<String> iterator = stack.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
