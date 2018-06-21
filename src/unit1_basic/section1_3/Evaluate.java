package unit1_basic.section1_3;

import java.util.Scanner;
import java.util.Stack;

/**
 * 
 * @author beta
 *使用栈实现算数表达式求值
 *(1+(2+3)*(4*5))
 */
public class Evaluate {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//操作数栈
		Stack<String> ops = new Stack<>();
		//运算符栈
		Stack<Double> val = new Stack<>();

		while (!sc.hasNext("q")) {
			String s = sc.next();
			if(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")) {
				ops.push(s);
			}else if(s.equals("(")) {
				
			}else if(s.equals(")")) {
				double x = val.pop();
				double y = val.pop();
				String str = ops.pop();
				System.out.println(str);
				if(str.equals("+")) {
					double i = x+y;
					System.out.println("+:"+i);
					val.push(i);
				}else if(str.equals("-")) {
					double i = y-x;
					System.out.println(i);
					val.push(i);
				}else if(str.equals("*")) {
					double i = x*y;
					System.out.println(i);
					val.push(i);
				}else {
					double i = y/x;
					System.out.println(i);
					val.push(i);
				}
			}else {
				val.push(Double.valueOf(s));
			}
		}
	}
	
}
