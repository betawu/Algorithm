package unit1_basic;
/**
 * 链表实现队列
 */
public class LinkedQueue<T> {
	private class Node{
		public T data;
		public Node next;
		
		public Node(T t) {
			data = t;
		}
	}
	
	//头出尾进
	private Node first;
	private Node last;
	private int size;
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public void enqueue(T t) {
		if(first == null) {
			first = new Node(t);
			last = first;
		}else {
			LinkedQueue<T>.Node node = new Node(t);
			last.next = node;
			last = node;
		}
		size++;
	}
	
	public T dequeue() {
		Node node = null;
		if(first.next == null) {
			node = first;
			first =null;
			last = null;
		}else {
			node = first;
			first = first.next;
		}
		size--;
		return node.data;
	}
	
	
	public static void main(String[] args) {
		LinkedQueue<Integer> queue = new LinkedQueue<>();
		for(int i=0;i<5;i++) {
			queue.enqueue(i);
		}
		
		while (!queue.isEmpty()) {
			System.out.println(queue.dequeue());
		}
	}
}
