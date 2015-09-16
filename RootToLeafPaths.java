class Node1{
	public int data;
	public Node left;
	public Node right;
	
	public Node1(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public Node1(int data, Node l, Node r){
		this.data = data;
		this.left = l;
		this.right = r;
	}
	
}

public class RootToLeafPaths{
	
	public void pathRootToLeaf(Node root, int[] p, int pL){
		if(root == null){
			return;
		}
		
		p[pL] = root.data;
		pL++;
			
		if(root.left == null && root.right == null){
			for(int j=0 ; j<pL; j++){
				System.out.print(" " + p[j]);
			}
			System.out.println();
		}
		else{
			pathRootToLeaf(root.left, p, pL);
			pathRootToLeaf(root.right, p, pL);
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
		
		RootToLeafPath o1 = new RootToLeafPath();
		int[] path = new int[1000];
		int pathLength = 0;
		o1.pathRootToLeaf(r1, path, pathLength);
	}
}
