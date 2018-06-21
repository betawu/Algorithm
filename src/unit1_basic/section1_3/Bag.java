package unit1_basic.section1_3;

import java.util.Iterator;

/**
 * 使用链表实现背包
 * @author beta
 */
public class Bag<T>{
	private class Node{
		public Node next;
		public T data;
		public Node(T t) {
			data = t;
		}
	}
	
	public Node first;

	public void add(T t) {
		if(first == null) {
			first = new Node(t);
		}else {
			Node node = new Node(t);
			node.next = first;
			first = node;
		}
	}
	
	public BagIterator iterator() {
		return new BagIterator();
	}
	
	private class BagIterator implements Iterator<T>{

		private Node cur = first;
		
		@Override
		public boolean hasNext() {
			return cur != null;
		}

		@Override
		public T next() {
			Node node = cur;
			cur = cur.next;
			return node.data;
		}
	}
	
	public static void main(String[] args) {
		Bag<Integer> bag = new Bag<>();
		for(int i=0;i<5;i++) {
			bag.add(i);
		}
		Bag<Integer>.BagIterator iterator = bag.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
