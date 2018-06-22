package unit1_basic.section1_3.test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * 补全表达式左括号
 * @author beta
 *
 */
public class Test1_3_9 {
	//输入1+2)*3-4)*5-6)))
	//输出((1+2)*((3-4)*(5-6)))
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Stack<String> ops = new Stack<>();
		Stack<String> val = new Stack<>();
		
		while(!sc.hasNext("q")) {
			String s = sc.next();
			if(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")) {
				ops.push(s);
			}else if(s.equals(")")){
				String y = val.pop();
				String x = val.pop();
				String z = ops.pop();
				val.push("("+x+z+y+")");
			}else {
				val.push(s);
			}
		}
		
		System.out.println(val.pop());
		
	}

}
