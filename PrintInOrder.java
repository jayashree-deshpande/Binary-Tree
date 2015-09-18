import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node{
	public int data;
	public Node left;
	public Node right;
	
	public Node(int data)
	{
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public Node(int data, Node l, Node r){
		this.data = data;
		this.left = l;
		this.right = r;
	}
}

public class PrintInOrder{
	public int nodeCount = 0;
	public int treeHeight = 0;
	
	public void printInOrder(Node root)
	{
		if(root == null){
			return;
		}
		
		printInOrder(root.left);
		System.out.print(" " + root.data);
		printInOrder(root.right);
			
	}
	
	public static void main(String[] args){
		
		Node r1 = new Node(5);
		r1.left = new Node(3);
		r1.right = new Node(7);
		r1.left.left = new Node(1);
		r1.left.right = new Node(4);
		r1.right.left = new Node(6);
		r1.right.right = new Node(10);
		r1.right.right.left = new Node(8);
		
		/*Node r2 = new Node(5);
		r2.left = new Node(3);
		r2.right = new Node(7);
		r2.left.left = new Node(1);
		r2.left.right = new Node(4);
		r2.right.left = new Node(6);
		r2.right.right = new Node(10);*/
	
		BinaryTree b = new BinaryTree();
		
		b.printInOrder(r1);
		
	}
}
