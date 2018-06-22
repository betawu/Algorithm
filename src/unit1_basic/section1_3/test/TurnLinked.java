package unit1_basic.section1_3.test;

import java.util.Stack;

/**
 * 反转链表
 * @author beta
 *
 */


public class TurnLinked<T> {
	
	//用栈实现反转链表
	public Node turn(Node node) {
		Stack<Node> stack = new Stack<>();
		
		while(node!=null) {
			stack.push(node);
			node = node.next;
		}

		Node n = null;
		if(!stack.isEmpty()) {
			n = stack.pop();
		}
		Node cur = n;
		while(!stack.isEmpty()) {
			cur.next = stack.pop();
			cur = cur.next;
		}
		cur.next = null;
		return n;
	}
	
	//使用迭代方式解答
	public Node turn2(Node first) {
		Node node = null;
		
		
		return node;
	}
	
	//使用递归方式解答
	public Node turn3(Node node) {
		return null;
	}
}
