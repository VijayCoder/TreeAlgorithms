package tree_traversals;

import java.util.Stack;

class Node {
	private int data;
	private Node left;
	private Node right;
	
	//Inserting a new 
	Node(int x) {
		data=x;
		left=null;
		right=null;
	}
	
	//Inserting left/right child of the parent node depending on argument pos 
	void addChild(Node node,char pos) {
		if(pos=='l') {
			this.left=node;
		}
		else if(pos=='r') {
			this.right=node;
		}
	}
	
	//Inorder traversal starting from the node from which the method is called
	void inOrder() {
		Stack<Node> traverse=new Stack<Node>();
		Node node=this;
		while(node!=null) {
			traverse.push(node);
			node=node.left;
		}
		
		while(traverse.isEmpty()==false) {
			node=traverse.pop();
			System.out.printf("%d ",node.data);
			node=node.right;
			while(node!=null) {
				traverse.push(node);
				node=node.left;
			}
		}
	}
}

public class Tree {
	
	//Just a driver program for testing
	public static void main(String args[]) {
		Node root=new Node(3);
		Node a=new Node(5);
		Node b=new Node(2);
		Node c=new Node(1);
		Node d=new Node(4);
		Node e=new Node(6);
		root.addChild(a,'l');
		root.addChild(b,'r');
		a.addChild(c,'l');
		a.addChild(d,'r');
		b.addChild(e,'r');
		root.inOrder();
	}
}
