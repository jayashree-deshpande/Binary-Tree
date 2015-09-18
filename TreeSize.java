import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Stack;

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

public class TreeSize{
	public int nodeCount = 0;
	public int treeHeight = 0;
	
	public int treeSize(Node root)
	{
		//int nodeCount = 0;
		if(root == null)
		{
			return nodeCount;
		}
		
		treeSize(root.left);
		nodeCount++;
		treeSize(root.right);
		
		return nodeCount;
		
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
		
		BinaryTree b = new BinaryTree();
		
		System.out.println(" \n total nodes in the tree = " + b.treeSize(r1));
	}
	
}
