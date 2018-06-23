package unit1_basic.section1_3.test;
/**
 * 双向链表
 * @author wuyuxuan
 *
 */
public class DoubleNode<T> {
	
	private class Node{
		public T data;
		public Node pre;
		public Node next;
		
		public Node(T t,Node pre ,Node next) {
			this.data = t;
			this.pre = pre;
			this.next = next;
		}
	}
	
	public Node first;
	public Node last;
	
	public DoubleNode() {
	}
	
	
	public void addFirst(T t) {
		if(first == null) {
			first = new Node(t,null,null);
			last = first;
		}else {
			Node node = new Node(t,null,first);
			first = node;
		}
	}
	
	public void addLast(T t) {
		if(last == null) {
			addFirst(t);
		}else {
			Node node = new Node(t,last,null);
			last.next = node;
			last = node;
		}
	}
	
	public void delFirst() {
		if(first.next == null) {
			first = null;
			last = null;
		}else {
			first = first.next;
		}
	}
	
	public void delLast() {
		last = last.pre;
		last.next = null;
	}
	
	//在值为i的节点之前插入
	public void insertPre(T i,T v) {
		Node cur = first;
		while(cur.data!=i) {
			cur = cur.next;
		}
		if(cur == first) {
			addFirst(v);
		}else {
			cur.pre.next = new Node(v,cur.pre,cur);
		}
	}
	
	//在值为i的节点之后插入
	public void insertAfter(T i,T v){
		Node cur = first;
		while(cur.data!=i) {
			cur = cur.next;
		}
		if(cur == last) {
			addLast(v);
		}else {
			Node node = cur.next; 
			cur.next = new Node(v,cur,cur.next);
			node.pre = cur.next;
		}
	}
	
	
	public static void main(String[] args) {
		DoubleNode<Integer> doubleNode = new DoubleNode<>();
//		doubleNode.addFirst(1);
//		doubleNode.addFirst(2);
//		doubleNode.addFirst(3);
		
		doubleNode.addLast(1);
		doubleNode.addLast(2);
		doubleNode.addLast(3);
		
//		doubleNode.delFirst();
//		doubleNode.delLast();
		
		doubleNode.insertPre(2, 0);
		doubleNode.insertPre(1, 0);
		
		doubleNode.insertAfter(3, 5);
		doubleNode.insertAfter(3, 4);
		
		DoubleNode<Integer>.Node node = doubleNode.first;
		while(node!=null) {
			System.out.println(node.data);
			node= node.next;
		}

	}
}
