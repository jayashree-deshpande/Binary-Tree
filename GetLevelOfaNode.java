class Node7{
	int data;
	Node7 left;
	Node7 right;
	
	public Node7(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public Node7(int data, Node7 l, Node7 r){
		this.data = data;
		this.left = l;
		this.right = r;
	}
}

public class GetLevelOfaNode{
	
	public int getLevelOfNode(Node7 root, int key, int level){
		if(root == null){
			return 0;
		}
		else{
			if(root.data == key){
				System.out.println("level is = "+level);
			}
			int temp = level + 1;
			getLevelOfNode(root.left, key,temp);
			getLevelOfNode(root.right, key, temp);
		}
		return level;
	}
	
	public static void main(String[] args)
	{
		/* Constructed binary tree is
	            10
	          /   \
	        8      2
	      /  \    	\
	    3     5  	 9
	    			  \
	    			  12
	  */
		Node7 r1= new Node7(10);
		r1.left = new Node7(8);
		r1.left.left  = new Node7(3);
		r1.left.right = new Node7(5);
		r1.right = new Node7(2);
		r1.right.right = new Node7(9);
		r1.right.right.right = new Node7(12);
		
		int level = 1;
		GetLevelOfaNode obj = new GetLevelOfaNode();
		obj.getLevelOfNode(r1, 12, level);
	}
}
