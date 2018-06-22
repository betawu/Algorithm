package unit1_basic.section1_3.test;

import java.util.Stack;

/**
 * 中序表达式转后续表达式
 * @author beta
 *in:((1+2)*((3-4)*(5-6)))
 *out:12+34-56-**
 */
public class InOrderToPostOrder {

	public static void main(String[] args) {
		String in = "((1+2)*((3-4)*(5-6)))";
		
		Stack<String> stack = new Stack<>();
		for(int i=0;i<in.length();i++) {
			String s = in.charAt(i)+"";
			
			if(s.equals(")")) {
				String y = stack.pop();
				String ops = stack.pop();
				String x = stack.pop();
				stack.push(x+y+ops);
			}else if(s.equals("(")){
				
			}else{
				stack.push(s);
			}
		}
		
		System.out.println(stack.pop());
	}
}
