package unit1_basic.section1_3.test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 反转队列
 * @author beta
 *
 */
public class TurnQueue {
	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();
		q.add(1);
		q.add(2);
		q.add(3);
		
		while(!q.isEmpty()) {
			stack.push(q.remove());
		}
		while(!stack.isEmpty()) {
			q.add(stack.pop());
		}
		
		while(!q.isEmpty()) {
			System.out.println(q.remove());
		}
	}
}
