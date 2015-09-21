import java.lang.Math;

class TNode{
	int data;
	TNode left;
	TNode right;
	
	public TNode(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

class Data{
	int h;
	int d;
	
	public Data(int height, int diameter){
		this.h = height;
		this.d = diameter;
	}
}

public class DiameterBinaryTree{
	
	public Data getDiameter(TNode root){
		Data lD = null;
		Data rD = null;
		
		if(root == null){
			return new Data(0,0) ;
		}
		
		if(root.left == null && root.right == null){
			System.out.println("***1***");
			return new Data(1,1);
		}
		
		else if(root.left == null){
			System.out.println("***2***");
			rD = getDiameter(root.right);
			int h = rD.h + 1;
			int d = rD.h + 1;
			System.out.println( Math.max(h, Math.max(d,rD.d)));
			return new Data(h, Math.max(h, Math.max(d,rD.d)));
			
		}
		else if(root.right == null){
			System.out.println("***3***");
			lD = getDiameter(root.left);
			int h = lD.h + 1;
			int d = lD.h + 1;
			System.out.println(Math.max(h, Math.max(d, lD.d)));
			return new Data(h, Math.max(h, Math.max(d, lD.d)));
		}
		else 
		{
			System.out.println("***4***");
			lD = getDiameter(root.left);
			rD = getDiameter(root.right);
			int h = 1 + Math.max(lD.h, rD.h);
			System.out.println("height = " + h);
			int d = lD.h + rD.h + 1;
			System.out.println(Math.max(d, Math.max(lD.d, rD.d)));
			return new Data(h,Math.max(d, Math.max(lD.d, rD.d)));
		}
		
	}
		
	public static void main(String[] args){
		TNode r1 = new TNode(6);
		r1.left= new TNode(5);
		r1.left.left = new TNode(3);
		r1.left.right = new TNode(4);
		r1.left.left.left = new TNode(1);
		r1.left.left.right = new TNode(2);
		
		r1.right = new TNode(7);
		r1.right.left = new TNode(6);
		r1.right.right = new TNode(10);
		r1.right.right.left = new TNode(8);
		r1.right.right.left.right = new TNode(9);
		
		DiameterBinaryTree obj = new DiameterBinaryTree();
		Data myResult = obj.getDiameter(r1);
		System.out.println("resulting diameter is= " + myResult.d);
		
	}
}
