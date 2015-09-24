class Node_1{
	int data;
	Node_1 left;
	Node_1 right;
	
	public Node_1(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class NodeAtKDistanceFromRoot{
	
	public void getNodeAtKDistance(Node_1 root, int d, int k){
		if(root == null){
			return;
		}
		int temp = d + 1;
		if(k == d)
		{
			System.out.println( " " + root.data );
			return ;
		}
		else
		{      
			getNodeAtKDistance(root.left, temp,k);
			getNodeAtKDistance(root.right, temp,k);
		}
		
	}
	
	public static void main(String[] args)
	{
	/* Constructed binary tree is
		            1
		          /   \
		        2      3
		      /  \    /
		    4     5  8 
	 */
		Node_1 r1 = new Node_1(1);
		r1.left = new Node_1(2);
		r1.right = new Node_1(3);
		r1.left.left  = new Node_1(4);
		r1.left.right = new Node_1(5);
		r1.right.left = new Node_1(8);  
		
		int d = 0;
		NodeAtKDistanceFromRoot obj = new NodeAtKDistanceFromRoot();
		obj.getNodeAtKDistance(r1, d, 1);
	}
}
