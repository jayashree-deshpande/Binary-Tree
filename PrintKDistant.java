class Node_2{
	int data;
	Node_2 left;
	Node_2 right;
	
	public Node_2(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public Node_2(int data, Node_2 l, Node_2 r){
		this.data = data;
		this.left = l;
		this.right = r;
	}
}

public class PrintKDistant{
	public void getNodeAtKDistance(Node_2 root , int k)    
	{
	   if(root == null) 
	      return;
	   if(k == 0)
	   {
	      System.out.println( " " + root.data );
	      return ;
	   }
	   else
	   {      
		   getNodeAtKDistance( root.left, k-1 ) ;
		   getNodeAtKDistance( root.right, k-1 ) ;
	   }
	}
	
	public static void main(String[] args){
		/* Constructed binary tree is
		            1
		          /   \
		        2      3
		      /  \    /
		    4     5  8 
		 */
		Node_2 r1 = new Node_2(1);
		r1.left	= new Node_2(2);
		r1.right = new Node_2(3);
		r1.left.left = new Node_2(4);
		r1.left.right = new Node_2(5);
		r1.right.left = new Node_2(8); 
		
		PrintKDistant obj = new PrintKDistant();
		obj.getNodeAtKDistance(r1, 2);
	}
}
