class Node4{
	int data;
	Node4 left;
	Node4 right;
	
	public Node4(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public Node4(int data, Node4 n1, Node4 n2){
		this.data = data;
		this.left = n1;
		this.right = n2;
	}
}

public class LeafCount{
	int count = 0;
	
	public int getLeafCount(Node4 root){
		
		if(root == null){
			return 0 ;
		}
		
		if(root.left == null || root.right == null){
			count++;
			System.out.println(" leaf is " + root.data + "count is= " + count);
		}
		else{
			getLeafCount(root.left);
			getLeafCount(root.right);
			
		}
		
		return count;
	}
	
	public static void main(String[] args){
		
		Node4 r1 = new Node4(5);
		r1.left= new Node4(3);
		r1.right = new Node4(7);
		r1.left.left = new Node4(1);
		r1.left.right = new Node4(4);
		r1.right.left = new Node4(6);
		r1.right.right = new Node4(10);
		r1.right.right.left = new Node4(8);
		
		LeafCount obj = new LeafCount();
		System.out.println("The total count is = " + obj.getLeafCount(r1));
	}
}

