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

public class DFS{
//	public int nodeCount = 0;
//	public int treeHeight = 0;

	public void DFS(Node root){
		
		if(root == null){
			return;
		}
		
		Stack<Node> s = new Stack<>();
		s.push(root);
		
		while(!s.empty())
		{
			Node top = s.pop();
			System.out.print(" " + top.data);
			
			if(top.right != null)
			{
				s.push(top.right);
			}
			
			if(top.left != null)
			{
				s.push(top.left);
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
		
		b.DFS(r1);
		
	}
}
