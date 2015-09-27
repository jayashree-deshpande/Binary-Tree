class TreeNode1
{
	int data;
	TreeNode1 left;
	TreeNode1 right;
	TreeNode1 nextRight;
  
	public TreeNode1(int data){
		this.data = data;
		this.left = null;
		this.right = null;
		this.nextRight = null;
	}
  
}
 
public class ConnectNodesAtSameLevel{
	
	public void connect(TreeNode1 root)
	{
		// Set the nextRight for root
	    root.nextRight = null;
	 
	    // Set the next right for rest of the nodes (other than root)
	    connectRecur(root);
	}
	
	// Sets the nextRight of root and calls connectRecur() for other nodes

	/* Set next right of all descendants of root.
	   Assumption:  root is a compete binary tree */
	public void connectRecur(TreeNode1 root)
	{
		// Base case
		if (root == null)
			return;
	 
		// Set the nextRight pointer for root's left child
		if (root.left != null)
			root.left.nextRight = root.right;
	 
		// Set the nextRight pointer for root's right child
		// root.nextRight will be null if root is the right most child at its level
		if (root.right != null)
			root.right.nextRight = (root.nextRight != null)? root.nextRight.left: null;
	 
		// Set nextRight for other nodes in pre order fashion
		connectRecur(root.left);
		connectRecur(root.right);
	}

	public static void main(String[] args){
		
	 /* Constructed binary tree is
	  * 
		              10
		             /  \
		            /    \
		           /      \
		          /        \
		         7          12
		       /   \        /  \
		      /     \      /    \
		     5       8    11    15
		   /  \       \  
		  4    6       9
		  
	 */
		TreeNode1 r1				= new TreeNode1(10);
		r1.left						= new TreeNode1(7);
		r1.left.left				= new TreeNode1(5);
		r1.left.right				= new TreeNode1(8);
		r1.left.right.right			= new TreeNode1(9);
		r1.left.left.left			= new TreeNode1(4);
		r1.left.left.right			= new TreeNode1(6);
		r1.right		= new TreeNode1(12);
		r1.right.left 	= new TreeNode1(11);
		r1.right.left 	= new TreeNode1(15);
		
		ConnectNodesAtSameLevel obj = new ConnectNodesAtSameLevel();
		// Populates nextRight pointer in all nodes
		obj.connect(r1);
		 
		// Let us check the values of nextRight pointers
		System.out.println("Following are populated nextRight pointers in the tree "+
		          "(-1 is printed if there is no nextRight) \n");
		System.out.printf("nextRight of %d is %d \n", r1.data,
		         (r1.nextRight != null)? r1.nextRight.data: -1);
		System.out.printf("nextRight of %d is %d \n", r1.left.data,
		        (r1.left.nextRight != null)? r1.left.nextRight.data: -1);
		System.out.printf("nextRight of %d is %d \n", r1.right.data,
		        (r1.right.nextRight != null)? r1.right.nextRight.data: -1);
		System.out.printf("nextRight of %d is %d \n", r1.left.left.data,
		        (r1.left.left.nextRight != null )? r1.left.left.nextRight.data: -1);
		 
	}
}
