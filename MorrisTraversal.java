class TNode1{
	int data;
	TNode1 left;
	TNode1 right;
	
	public TNode1(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public TNode1(int data, TNode1 l, TNode1 r){
		this.data = data;
		this.left = l;
		this.right = r;
	}
}

public class MorrisTraversal{
	/* Function to traverse binary tree without recursion and 
	   without stack */
	void getMorrisTraversal(TNode1 root)
	{
		TNode1 current = root;
		TNode1 pre = null;
	 
		if(root == null)
			return; 
	 
		while(current != null)
		{                 
			if(current.left == null)
			{
				System.out.print(" " +current.data);
				current = current.right;      
			}    
			else
			{
				/* Find the inorder predecessor of current */
				pre = current.left;
				while(pre.right != null && pre.right != current)
					pre = pre.right;
	 
				/* Make current as right child of its inorder predecessor */
				if(pre.right == null)
				{
					pre.right = current;
					current = current.left;
				}
	             
				/* Revert the changes made in if part to restore the original 
	        	tree i.e., fix the right child of predecssor */   
				else 
				{
					pre.right = null;
					System.out.print(" "+current.data);
					current = current.right;      
				} /* End of if condition pre->right == NULL */
			} /* End of if condition current->left == NULL*/
		} /* End of while */
	}
	
	public static void main(String[] args){
	/* Constructed binary tree is
			            1
			          /   \
			        2      3
			      /  \
			    4     5
	*/
		TNode1 r1 = new TNode1(1);
		r1.left = new TNode1(2);
		r1.right = new TNode1(3);
		r1.left.left  = new TNode1(4);
		r1.left.right = new TNode1(5); 
		
		MorrisTraversal obj = new MorrisTraversal();
		obj.getMorrisTraversal(r1);
	}
}



