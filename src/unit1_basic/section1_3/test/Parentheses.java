package unit1_basic.section1_3.test;

import java.util.Stack;

/**
 * 算法1.3.4练习题
 * @author beta
 *
 */
public class Parentheses {
	public static boolean parenthese(String s) {

		
		Stack<Character> stack = new Stack<>();
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			if(c!=']'&&c!='}'&&c!=')') {
				stack.push(c);
			}else {
				Character pop = stack.pop();
				if(pop == '(') {
					if(c != ')') {
						return false;
					}
				}else if(pop=='['){
					if(c != ']') {
						return false;
					}
				}else if(pop == '{') {
					if(c != '}') {
						return false;
					}
				}
			}
		}
		
		if(stack.isEmpty()) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
//		String s = "[()]{}{[()()]()}";
		String s = "[(])";
		boolean flag = Parentheses.parenthese(s);
		System.out.println(flag);
	}
}
