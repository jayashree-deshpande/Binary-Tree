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

public class TreeHeight{
	public int nodeCount = 0;
	public int treeHeight = 0;

	public int treeHeight(Node root, int treeHeight){
		int lHeight = 0;
		int rHeight = 0;
		
		if(root == null){
			return 0;
		}
		else
		{
			lHeight = treeHeight(root.left, lHeight++);
			rHeight = treeHeight(root.right, rHeight++);
		
			if(lHeight > rHeight){
				return (lHeight + 1);
			}
			else{
				return (rHeight + 1);
			}
		}
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
		
		System.out.println(b.treeHeight(r1, b.treeHeight));
	}
}
