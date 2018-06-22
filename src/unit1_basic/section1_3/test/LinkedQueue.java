package unit1_basic.section1_3.test;

/**
 * 用环形链表实现队列
 * @author beta
 *
 */
public class LinkedQueue<T> {
	private class Node{
		private Node next;
		private T data;
		
		public Node(T t) {
			this.data = t;
		}
		public Node() {
			
		}
	}
	private Node last;
	
	public void enQueue(T t) {
		if(last == null) {
			last = new Node(t);
			last.next = last;
		}else {
			Node node = new Node(t);
			node.next = last.next;
			last.next = node;
			last = last.next;
		}
	}
	
	public T deQueue() {
		Node node = last.next;
		last.next = last.next.next;
		node.next = null;
		return node.data;
	}
	
	public static void main(String[] args) {
		LinkedQueue<Integer> q = new LinkedQueue<>();
		q.enQueue(1);
		q.enQueue(2);
		q.enQueue(3);
		
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		
	}
}
