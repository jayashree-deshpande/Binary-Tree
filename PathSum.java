class TNode2{
	int data;
	TNode2 left;
	TNode2 right;
	
	public TNode2(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public TNode2(int data, TNode2 l, TNode2 r){
		this.data = data;
		this.left = l;
		this.right = r;
	}
}

public class PathSum{
	
	public boolean hasPathSum(TNode2 root, int[] p, int nCount, int sum){
		int nodeSum = 0;
		if(root == null){
			return false;
		}
		else{
			p[nCount] = root.data;
			nCount++ ;
			
			if(root.left == null && root.right == null){
				//int nodeSum = 0;
				for(int j=0 ; j<nCount; j++){
					nodeSum = nodeSum + p[j];
					//System.out.print(" " + p[j]);
				}
				System.out.println();
				System.out.println(nodeSum);
				if(nodeSum == sum)
				{
					return true;
					
				}
				else{
					return false;
				}
			}
			else{
				boolean lResult = hasPathSum(root.left, p, nCount, sum);
				boolean rResult = hasPathSum(root.right, p, nCount, sum);
				return (lResult || rResult);
			}
		}
	}
	/* Driver program to test above functions*/
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
		TNode2 r1= new TNode2(10);
		r1.left = new TNode2(8);
		r1.left.left  = new TNode2(3);
		r1.left.right = new TNode2(5);
		r1.right = new TNode2(2);
		r1.right.right = new TNode2(9);
		r1.right.right.right = new TNode2(12);
		
		int[] path = new int[1000];
		int pathLength = 0;
		int sum = 30;
		
		PathSum obj = new PathSum();
		boolean result = obj.hasPathSum(r1, path, pathLength, sum);
		System.out.println("*******" + result);
		if(result)
			System.out.println("hasPathSum = " + result);
		else
			System.out.println("hasPathSum = " + result);
		
	}
}
