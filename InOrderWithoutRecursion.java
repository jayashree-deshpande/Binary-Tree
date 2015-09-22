import java.util.Stack;

class TreeNode{
	int data;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public TreeNode(int data, TreeNode l, TreeNode r){
		this.data = data;
		this.left = l;
		this.right = r;
	}
}

public class InOrderWithoutRecursion{
	
	public void printInOrderWithoutRecursion(TreeNode root){
		TreeNode current = root;
		Stack<TreeNode> myStk = new Stack<>();
		boolean done = false;
		while(!done){
			if(current != null){
				myStk.push(current);
				current = current.left;
			}
			else if(!myStk.isEmpty()){
				current = myStk.pop();
				System.out.print(" "+current.data);
				current = current.right;
			}
			else{
				done = true;
			}
				
		}
	}	
	public static void main(String[] args){
		/* Constructed binary tree is
			            1
			          /   \
			        2      3
			      /  \
			    4     5
		 */
		TreeNode r1 = new TreeNode(1);
		r1.left = new TreeNode(2);
		r1.right = new TreeNode(3);
		r1.left.left  = new TreeNode(4);
		r1.left.right = new TreeNode(5); 
		
		InOrderWithoutRecursion obj = new InOrderWithoutRecursion();
		obj.printInOrderWithoutRecursion(r1);	  
			
	}
}
		
		
		
		
