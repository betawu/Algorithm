package unit2_sort.section2_4.base;

import unit2_sort.section2_1.SortUtil;
import unit2_sort.section2_4.MaxPQ;

/**
 * 优先队列
 * 初级实现 链表
 * @author beta
 *
 */
public class LinkedListPQ<T> implements MaxPQ<T>{

	private Node head;
	
	private int size;
	
	public LinkedListPQ() {
		
	}
	public LinkedListPQ(T[] arr) {
		for (T t : arr) {
			insert(t);
		}
	}
	
	private class Node {
		private T data;
		
		private Node next;
		
		private Node(T data) {
			this.data = data;
		}
	}
	
	@Override
	public void insert(T v) {
		size++;
		Node node = new Node(v);
		if (head == null) {
			head = node;
			return ;
		}
		if (SortUtil.less((Comparable)head.data, (Comparable)v)) {
			node.next = head;
			head = node;
			return ;
		}
		Node pre = head;
		Node i = head.next;
		boolean flag = false;
		while (i != null) {
			if (SortUtil.less((Comparable)i.data, (Comparable)v)) {
				node.next = i;
				pre.next = node;
				flag = true;
				break;
			}	
			pre = pre.next;
			i = i.next;
		}
		if (!flag) {
			pre.next = node;
		}
		
	}
	
	@Override
	public T max() {
		return head.data;
	}
	
	@Override
	public T delMax() {
		Node node = head;
		head = head.next;
		size--;
		return node.data;
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

