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

public class TreeIdentity{
	public int nodeCount = 0;
	public int treeHeight = 0;
	
	public boolean treeIdentity(Node root1, Node root2){
		
		if(root1 == null && root2 == null){
			return true;
		}
		else if(root1 == null){
			return false;
		}
		else if(root2 == null){
			return false;
		}
		
			
		if(root1.data != root2.data){
			return false;
		}
		else if(!treeIdentity(root1.left, root2.left)){
			return false;
		}
		else if(!treeIdentity(root1.right, root2.right)){
			return false;
		}
			
		return true;
		
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
		
		System.out.println(b.treeIdentity(r1, r2));
		
	}
	
}
