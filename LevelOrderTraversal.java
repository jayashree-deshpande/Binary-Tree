class Node2{
	int data;
	Node2 left;
	Node2 right;
	
	public Node2(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public Node2(int data, Node2 l, Node2 r){
		this.data = data;
		this.left = l;
		this.right = r;
	}
}

public class LevelOrderTraversal{
	
	public int treeHeight(Node2 root){
		
		if(root == null){
			return 0;
		}
		else{
			/* Compute the height of each subtree */
			int lHeight = treeHeight(root.left);
			//System.out.println("lHeight" + lHeight);
			int rHeight = treeHeight(root.right);
			//System.out.println(" rHeight " + rHeight);
			
			if(lHeight > rHeight){
				
				return (lHeight + 1);
				
			}
			else{
				return (rHeight + 1);
			}
		}
	}
	
	/* Function to print level order traversal a tree*/
	void printLevelOrder(Node2 root)
	{
	  int h = treeHeight(root);
	  int i;
	  for(i=1; i<=h; i++)
	    printGivenLevel(root, i);
	}  
	
	/* Print nodes at a given level */
	public void printGivenLevel(Node2 root, int level)
	{
		if(root == null)
			return;
		
		if(level == 1)
			System.out.printf("%d ", root.data);
		
		else if (level > 1)
		{
			printGivenLevel(root.left, level-1);
			printGivenLevel(root.right, level-1);
		}
	}
	
	
	public static void main(String[] args){
		
		Node2 r1 = new Node2(5);
		r1.left= new Node2(3);
		r1.right = new Node2(7);
		r1.left.left = new Node2(1);
		r1.left.right = new Node2(4);
		r1.right.left = new Node2(6);
		r1.right.right = new Node2(10);
		r1.right.right.left = new Node2(8);
		
		LevelOrderTraversal obj = new LevelOrderTraversal();
		System.out.println(obj.treeHeight(r1));
		obj.printLevelOrder(r1);
	}
}
	
