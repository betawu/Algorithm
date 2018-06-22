package unit1_basic.section1_3.test;
/**
 * 链表操作
 * @author beta
 *
 */
public class LinkedNode<T> {
	private class Node{
		private Node next;
		private T data;
		
		public Node(T t) {
			this.data = t;
		}
		public Node() {
			
		}
	}
	
	private Node root;
	
	public LinkedNode() {
		root = new Node();
	}
	
	public void add(T t) {
		LinkedNode<T>.Node node = new Node(t);
		node.next = root.next;
		root.next = node;
	}
	
	//打印链表
	public void print() {
		print(root.next);
	}
	
	private void print(LinkedNode<T>.Node node) {
		if(node == null) {
			return ;
		}
		System.out.println(node.data);
		print(node.next);
	}

	//删除链表的尾节点
	public void delLast() {
		Node cur = root;
		while(cur.next.next!=null) {
			cur = cur.next;
		}
		cur.next = null;
	}
	
	
	//删除第k个元素
	public void delete(int k) {
		root.next = delete(root.next,k);
	}
	
	private Node delete(LinkedNode<T>.Node node, int k) {
		if(k==1) {
			return node.next;
		}
		
		k--;
		node.next = delete(node.next, k);
		return node;
	}
	
	public boolean find(Node node,Integer key) {
		while(node!=null) {
			if(key.equals(node.data)) {
				return true;
			}else {
				node = node.next;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		LinkedNode<Integer> l = new LinkedNode<>();
		l.add(1);
		l.add(2);
		l.add(3);
//		l.delLast();
//		l.delete(3);
		System.out.println(l.find(l.root, 1));
		
		l.print();
		
	}
}
