package praktugas;

public class RBTree {
	node root;
	//Method untuk pembuatan tinggi tree
	
	int height(node n) {
		if (n == null) return 0;
		return n.height;
	}
	
	//Method untuk nilai maksimum dari 2 int
	int maks(int a, int b) {
		if (a > b) {
			return a;
	}
		else {
			return b;
		}
	}
	
	//Method berotasi kekanan
	node rightRotasi(node y) {
		node x = y.left;
		node t2 = x.right;
		
		x.right = y;
		y.left = t2;
		
		y.height = maks(height(y.left), height(y.right))+ 1;
		x.height = maks(height(x.left), height(x.right) + 1);
		
	return x;
	}
	
	//Method berotasi kekiri
	node leftRotasi(node x) {
		node y = x.right;
		node t2 = y.left;
		
		y.left = x;
		x.right = t2;
		
		x.height = maks(height(x.left), height(x.right)) + 1;
		y.height = maks(height(y.left), height(y.right)) + 1;
		return y;
	}
	
	//Method untuk mendapatkan seimbang
	int getBalance(node n) {
		if (n == null)
			return 0;
	return height(n.left) - height(n.right);
	}
	
	//Method untuk menampilkan inorder dari tree
	void inOrder(node n) {
		if (n != null) {
			inOrder(n.left);
			System.out.print(n.data + " ");
			inOrder(n.right);
		}
	}
	//Method untuk menampilkan preorder dari tree
	void preOrder(node n) {
		if (n != null) {
			System.out.print(n.data + " ");
			preOrder(n.left);preOrder(n.right);
		}
	}
	
	//Method untuk menampilkan postorder dari tree
	void postOrder(node n) {
		if (n != null) {
			postOrder(n.left);
			postOrder(n.right);
			System.out.print(n.data + " ");
		}
	}
	
	//Method untuk insertion
	node insert(node n, int data) {
		if (n == null)
			return (new node(data));
		if (data < n.data)
			n.left = insert(n.left, data);
		else if (data > n.data)
			n.right = insert(n.right, data);
		else return n;
		
		n.height = 1 + maks(height(n.left), height(n.right));
		int balance = getBalance(n);
		
		if (balance > 1 && data < n.left.data)
			return rightRotasi(n);
		if (balance < -1 && data > n.right.data)
			return leftRotasi(n);
		if (balance > 1 && data > n.left.data) {
			n.left = leftRotasi(n.left);
			return rightRotasi(n);
	}
		if(balance < -1 && data < n.right.data) {
			n.right = rightRotasi(n.right);
			return leftRotasi(n);
		}
	return n;
	}
}

