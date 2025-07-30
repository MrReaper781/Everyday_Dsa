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

	public static void inOrder(Node root){
		if(root != null){
			inOrder(root.left);
			System.out.print(root.data+" ");
			inOrder(root.right);
		}
	}

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
	}

	public static void main(String[] args){
		int[] arr = {5, 1, 3, 4, 2, 7};
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
	}
}