package latihanJava;

public class Main{
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		
		bt.addNode(new Node(5));
		bt.addNode(new Node(4));
		bt.addNode(new Node(6));
		bt.addNode(new Node(7));
		bt.addNode(new Node(3));
		bt.inorder();
		
		System.out.println("");
		System.out.println("Searching 3....");
		System.out.println(BinaryTree.searchValue(bt.root, 3));
		System.out.println("");
		
		bt.inorder();

	System.out.println("");
	System.out.println("Deleting 5....");
	bt.deleteKey(5);
	bt.inorder();
	}
}
