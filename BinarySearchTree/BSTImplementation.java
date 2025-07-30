public class BSTImplementation{
	static class Node{
		int data;
		Node left;
		Node right;

		Node(int data){
			this.data = data;
			this.left = this.right = null;
		}
	}

	// Insert operation in a tree
	public static Node insert(Node root, int val){
		if(root == null){
			root = new Node(val);
			return root;
		}

		if(root.data > val){
			root.left = insert(root.left, val);
		}

		if(root.data < val){
			root.right = insert(root.right, val);
		}

		return root;
	}

	// Inorder traversal in a tree
	public static void inOrder(Node root){
		if(root != null){
			inOrder(root.left);
			System.out.print(root.data+" ");
			inOrder(root.right);
		}
	}

	// Search operation in a tree
	public static boolean search(Node root, int key){
		if(root == null){
			return false;
		}

		if(root.data == key){
			return true;
		}

		if(root.data > key){
			return search(root.left, key);
		}

		if(root.data < key){
			return search(root.right, key);
		}
		return false;
	}

	// Delete operation in a tree
	public static Node delete(Node root, int val){
		if(root == null) return null;
		if(root.data < val){
			root.right = delete(root.right, val);
		}else if(root.data > val){
			root.left = delete(root.left, val);
		}else{
			// Case 1
			if(root.left == null && root.right == null){
				return null;
			}

			// Case 2
			if(root.left == null){
				return root.right;
			}
			if(root.right == null){
				return root.left;
			}

			// Case 3
			Node IS = findInOrderSuccessor(root.right);
			root.data = IS.data;
			root.right = delete(root.right, IS.data);
		}
		return root;
	}

	public static Node findInOrderSuccessor(Node root){
		while(root.left != null){
			root = root.left;
		}
		return root;
	}

	public static void main(String[] args){
		// int[] arr = {5, 1, 3, 4, 2, 7};
		int[] arr = {8, 5, 3, 1, 4, 6, 10, 11, 14};
		Node root = null;

		for(int i=0; i<arr.length; i++){
			root = insert(root, arr[i]);
		}

		inOrder(root);
		System.out.println();

		if(search(root, 4)){
			System.out.println("Found");
		}else{
			System.out.println("Not found");
		}	

		root = delete(root, 5);
		inOrder(root);
	}
}