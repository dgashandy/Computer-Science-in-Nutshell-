package praktugas;

public class Main {

	public static void main(String[] args) {
	
		RBTree tree = new RBTree();
		
		tree.root = tree.insert(tree.root, 25);
		tree.root = tree.insert(tree.root, 41);
		tree.root = tree.insert(tree.root, 23);
		tree.root = tree.insert(tree.root, 20);
		tree.root = tree.insert(tree.root, 34);
		tree.root = tree.insert(tree.root, 36);
		tree.root = tree.insert(tree.root, 53);
		tree.root = tree.insert(tree.root, 23);
		
		System.out.println("Output dalam inorder: ");
		tree.inOrder(tree.root);
		System.out.println("\nOutput dalam preorder: ");
		tree.preOrder(tree.root);
		System.out.println("\nOutput dalam postorder: ");
		tree.postOrder(tree.root);
	}

}
