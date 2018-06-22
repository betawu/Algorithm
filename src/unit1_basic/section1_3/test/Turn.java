package unit1_basic.section1_3.test;

import java.util.Stack;

/**
 * 10进制转换为2进制
 * @author beta
 *
 */
public class Turn {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		Integer i = 50;
		while(i!=0) {
			stack.push(i%2);
			i/=2;
		}
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
}
