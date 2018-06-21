package unit1_basic;

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
		if(n>0&&n==arr.length/4) {
			resize(arr.length/2);
		}
		T rs = arr[n-1];
		arr[n-1] = null;
		n--;
		return rs;
	}
	
	public boolean isEmpty() {
		return n == 0;
	}
	
	public int size() {
		return n;
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
	}
}
