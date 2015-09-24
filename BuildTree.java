import java.util.ArrayList;
import java.util.List;

class BTree{
	char data;
	BTree left;
	BTree right;
	
	public List<BTree> myList = new ArrayList<>();
	
	public BTree(char data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public BTree(char data, BTree l, BTree r){
		this.data = data;
		this.left = l;
		this.right = r;
	}
	
	public boolean equals(BTree node) {
		  return (this.data == node.data);
		}
}

public class BuildTree{
	public static List<BTree> inOrder = new ArrayList<>();
	public static List<BTree> preOrder = new ArrayList<>();
	
	public boolean isNodeOnLeft(BTree root, BTree n){
		if(root == null || n == null){
			return false;
		}
		
		if(inOrder.indexOf(root) > inOrder.indexOf(n)){
			return true;
		}
		else{
			return false;
		}
		
	}
	
	public void buildTree(BTree root){
		
		if(root == null){
			return;
		}
		else{
			
			if(root.myList.isEmpty()){
				return;
			}
			else{
				for(int i=0 ; i<root.myList.size(); i++)
				{
					if(isNodeOnLeft(root, root.myList.get(i))){
						if(root.left == null){
							root.left = new BTree(root.myList.get(i).data);
							System.out.print(" "+ root.left.data);
						}
						else{
							root.left.myList.add(root.myList.get(i));
						}
					}
					else{
						if(root.right == null){
							root.right = new BTree(root.myList.get(i).data);
							System.out.print(" "+ root.right.data);
						}
						else{
							root.right.myList.add(root.myList.get(i));
						}
						
					}
				}
			}
			buildTree(root.left);
			buildTree(root.right);
		}
		
	}
	
	public static void main(String[] args){
		BTree D = new BTree('D');
		BTree B = new BTree('B');
		BTree E = new BTree('E');
		BTree A = new BTree('A');
		BTree F = new BTree('F');
		BTree C = new BTree('C');
		
		inOrder.add(D);
		inOrder.add(B);
		inOrder.add(E);
		inOrder.add(A);
		inOrder.add(F);
		inOrder.add(C);
		
		preOrder.add(A);
		preOrder.add(B);
		preOrder.add(D);
		preOrder.add(E);
		preOrder.add(C);
		preOrder.add(F);
		
		BuildTree obj = new BuildTree();
		BTree r1 = preOrder.get(0);
		for(int i=1; i<preOrder.size(); i++){
			r1.myList.add(preOrder.get(i));
		}
		obj.buildTree(r1);
	}
}
