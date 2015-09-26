class Node9{
	int data;
	Node9 left;
	Node9 right;
	
	Node9(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class FindAncestors{
	
	public boolean printAncestors(Node9 root, int target){
		if(root == null){
			return false;
		}
		
		if(root.data == target){
			return true;
		}
		
		/* If target is present in either left or right subtree of this node,
	     then print this node */
		if(printAncestors(root.left, target) ||
	       printAncestors(root.right, target))
		{
			System.out.println(root.data);
			return true;
		}
		return false;
	}
	
	public static void main(String[] args)
	{
	 
		/* Construct the following binary tree
	              		1
	              	  /   \
					 2     3
	        	    /       \
	               4     	 5
	             /
	            7
		 */
		Node9 r1			= new Node9(1);
		r1.left				= new Node9(2);
		r1.left.left		= new Node9(4);
		r1.left.left.left  	= new Node9(7);
		
		r1.right			= new Node9(3);
		r1.right.right 		= new Node9(5);
		
		
		FindAncestors obj = new FindAncestors();
		obj.printAncestors(r1, 5);
	 }
}
