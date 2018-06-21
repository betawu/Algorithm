package unit1_basic.section1_3;
/**
 * 
 * @author beta
 *链表实现栈
 */
public class LinkedStack<T> {
	private class Node{
		public T data;
		public Node next;
		
		public Node() {
			
		}
	}
	private Node first;
	private int size;
	
	public LinkedStack() {
	}

	public boolean isEmpty() {
		return size==0;
	}
	
	public int size() {
		return size;
	}
	
	public void push(T t) {
		size++;
		if(first == null) {
			first = new Node();
			first.data = t;
		}else {
			Node node = new Node();
			node.data = t;
			node.next = first;
			first = node;
		}
	}
	
	public T pop() {
		size--;
		Node node = first;
		first = first.next;
		return node.data;
	}
	
	
	public static void main(String[] args) {
		LinkedStack<String> stack = new LinkedStack<>();
		String[] arr = {"a","b","c"};
		for(int i=0;i<arr.length;i++) {
			stack.push(arr[i]);
		}
		
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
}
