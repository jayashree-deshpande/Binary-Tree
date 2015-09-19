import java.util.Stack;

class Node5{
	int data;
	Node5 left;
	Node5 right;
	
	public Node5(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public Node5(int data, Node5 l, Node5 r){
		this.data = data;
		this.left = l;
		this.right = r;
	}
}

public class SpiralLevelOrder{
	
	void printGivenLevel(Node5 root){
		
		Stack<Node5> stack1 = new Stack<>();
		Stack<Node5> stack2 = new Stack<>();
		Node5 Head = null;
		
		if(root == null){
			return;
		}
		else
		{
			stack1.push(root);
			
			while(!stack1.isEmpty() || !stack2.isEmpty())
			{
				while(!stack1.isEmpty()){
					Head = stack1.pop();
					System.out.print(" "+ Head.data);
					
					if(Head.right != null)
					{
						stack2.push(Head.right);	
					}
					
					if(Head.left != null) 
					{
						stack2.push(Head.left);	
					}
				}				
				
				while(!stack2.isEmpty())
				{
					Head = stack2.pop();
					System.out.print(" "+ Head.data);
					
					if(Head.left != null) 
					{
						stack1.push(Head.left);
					}
					
					if(Head.right != null)
					{
						stack1.push(Head.right);
					}
					
				}
			}
		}
	}
	
	public static void main(String[] args){
		
		Node5 r1 = new Node5(5);
		r1.left = new Node5(3);
		r1.left.left = new Node5(1);
		r1.left.left.left = new Node5(10);
		r1.left.left.right = new Node5(11);
		r1.left.right = new Node5(4);
		r1.left.right.left = new Node5(12);
		r1.left.right.right = new Node5(13);
		
		r1.right = new Node5(7);
		r1.right.left = new Node5(8);
		r1.right.left.left = new Node5(14);
		r1.right.left.right = new Node5(15);
		r1.right.right = new Node5(9);
		r1.right.right.left = new Node5(16);
		r1.right.right.right = new Node5(17);
		
		
		SpiralLevelOrder obj = new SpiralLevelOrder();
		obj.printGivenLevel(r1);
	}
}
