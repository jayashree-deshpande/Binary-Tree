class MyNode{
	int data;
	MyNode left;
	MyNode right;
	
	public MyNode(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public MyNode(int data, MyNode n1, MyNode n2){
		this.data = data;
		this.left = n1;
		this.right = n2;
	}
}

class BData{
	int h;
	boolean b;
	
	public BData(int height, boolean isBalanced){
		this.h = height;
		this.b = isBalanced;
		System.out.println("height = " + this.h + " isBalanced= " + this.b);
	}
}

public class HeightBalanced{
	BData lBalanced = null;
	BData rBalanced = null;
	
	public BData isBalanced(MyNode root){
		int lH = 0;
		int rH = 0;
		
		if(root == null){
			return new BData(0,false);
		}
		
		System.out.println("data = " + root.data);
		
		if(root.left == null && root.right == null){
			System.out.println("****0***");
			return new BData(1, true);
		}
		else if(root.left == null){
			System.out.println("****1***");
			rBalanced = isBalanced(root.right);
			if(rBalanced.b){
				rH = rBalanced.h + 1;
			}
			return new BData(rH, rBalanced.b);
		}
		else if(root.right == null){
			System.out.println("****2***");
			lBalanced = isBalanced(root.left);
			if(lBalanced.b){
				lH = lBalanced.h + 1;
			}
			return new BData(lH, lBalanced.b);
		}
		else{
			lBalanced = isBalanced(root.left);
			rBalanced = isBalanced(root.right);
			
			if(lBalanced.b == false || rBalanced.b == false){
				return new BData(java.lang.Math.max(lBalanced.h, rBalanced.h)+1, false);
			}
			
			System.out.println("lBalanced.h= " + lBalanced.h + "rBalanced.h= " + rBalanced.h);
			if(java.lang.Math.abs(lBalanced.h - rBalanced.h) > 1){
				System.out.println("****3***");
				return new BData(java.lang.Math.max(lBalanced.h, rBalanced.h)+1, false);
			}
			else{
				System.out.println("****4***");
				return new BData(java.lang.Math.max(lBalanced.h, rBalanced.h)+1, true);
			}
			 
		}
	}
	
	public static void main(String[] args){
		
		MyNode r1 = new MyNode(5);
		r1.left= new MyNode(3);
		r1.right = new MyNode(7);
		r1.left.left = new MyNode(1);
		r1.left.right = new MyNode(4);
		r1.right.left = new MyNode(6);
		r1.right.right = new MyNode(10);
		r1.right.right.right = new MyNode(8);
		r1.right.right.right.right = new MyNode(12);
		
		HeightBalanced obj = new HeightBalanced();
		System.out.println(obj.isBalanced(r1).b);
	}
}

