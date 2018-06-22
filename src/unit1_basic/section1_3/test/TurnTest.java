package unit1_basic.section1_3.test;

public class TurnTest {
private Node root;
	
	public TurnTest() {
		root = new Node();
	}
	
	public void add(Integer t) {
		Node node = new Node(t);
		node.next = root.next;
		root.next = node;
	}
	
	//打印链表
	public void print() {
		print(root.next);
	}
	
	private void print(Node node) {
		if(node == null) {
			return ;
		}
		System.out.println(node.data);
		print(node.next);
	}
	
	public static void main(String[] args) {
		TurnTest test = new TurnTest();
		test.add(1);
		test.add(2);
		test.add(3);
		
		test.print();
		
		TurnLinked<Integer> turnLinked = new TurnLinked<>();
		Node node = turnLinked.turn(test.root.next);
		while(node!=null) {
			System.out.println(node.data);
			node = node.next;
		}
	}
}
