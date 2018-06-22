package unit1_basic.section1_3.test;

import java.util.Stack;

/**
 * 求出后序表达式的值
 * @author beta
 *
 */
public class EvaluatePostfix {
	public static void main(String[] args) {
		String str = "12+34-56-**";//3
		
		Stack<String> stack = new Stack<>();
		
		for(int i=0;i<str.length();i++) {
			String s = str.charAt(i)+"";
			if(s.equals("+")) {
				String y = stack.pop();
				String x = stack.pop();
				stack.push((Integer.parseInt(x)+Integer.parseInt(y))+"");
			}else if(s.equals("-")) {
				String y = stack.pop();
				String x = stack.pop();
				stack.push((Integer.parseInt(x)-Integer.parseInt(y))+"");
			}else if(s.equals("/")) {
				String y = stack.pop();
				String x = stack.pop();
				stack.push((Integer.parseInt(x)/Integer.parseInt(y))+"");
			}else if(s.equals("*")) {
				String y = stack.pop();
				String x = stack.pop();
				stack.push((Integer.parseInt(x)*Integer.parseInt(y))+"");
			}else {
				stack.push(s);
			}
		}
		System.out.println(stack.pop());
	}
}
