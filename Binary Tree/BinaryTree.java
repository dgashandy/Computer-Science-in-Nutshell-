package latihanJava;

public class BinaryTree {
	public Node root;
	
	void deleteKey(int key) {
		root = deleteRec(root, key);
	}
	Node deleteRec(Node root, int value) {
		if (root == null)
			return root;
		if (value < root.getValue())
			root.leftchild = deleteRec(root.leftchild, value);
		else if (value > root.getValue())root.rightchild = deleteRec(root.rightchild, value);
		else {
			if (root.leftchild == null)
				return root.rightchild;
			
			else if (root.rightchild == null)
				return root.leftchild;
			
			root.enterValue(minValue(root.rightchild));
			root.rightchild = deleteRec(root.rightchild, root.getValue());
		}
		return root;
	}
	
	int minValue(Node root) {
		int minv = root.getValue();
		
		while (root.leftchild != null) {
			minv = root.leftchild.getValue();
			root = root.leftchild;
		}
		return minv;
	}
	
	void inorder() {
		inorderRec(root);
	}
	void inorderRec(Node root) {
		if (root != null) {
			inorderRec(root.leftchild);
			System.out.print(root.getValue() + " ");
			inorderRec(root.rightchild);
		}
	}
	public void addNode(Node node){
		if(root == null){
			root = node;
	}
		else {insertNode(root,node);
		}
	}
	
	private void insertNode (Node parent , Node node){
		if(parent.getValue() > node.getValue()){
			if(parent.leftchild == null){
				parent.leftchild = node;
			}
			else{
				insertNode(parent.leftchild, node);
			}
		}
		else{
			if(parent.rightchild == null){
				parent.rightchild = node;
	}
			else{
				insertNode(parent.rightchild, node);
			}
		}
	}
	
	public static boolean searchValue(Node root, int value){
		if(root == null){
			return false;
		}
	else{
		if(root.getValue()==value){
			return true;
		}
		else if(root.getValue() > value){
			return searchValue(root.leftchild, value);
		}
		else{
			return searchValue(root.rightchild, value);
			}
		}
	}
}
