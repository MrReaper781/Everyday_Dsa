public class Practice{
	static class Node{
		int data;
		Node left;
		Node right;

		Node(int data){
			this.data = data;
			this.left = this.right = null;
		}
	}

	public static Node insert(Node root, int data){
		if(root == null){
			return new Node(data);
		}
		if(root.data > data){
			root.left = insert(root.left, data);
		}
		if(root.data < data){
			root.right = insert(root.right, data);
		}
		return root;
	}

	public static void inOrder(Node root){
		if(root == null){
			return;
		}
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}

	public static boolean search(Node root, int data){
		if(root == null) return false;
		if(root.data == data){
			return true;
		}else if(root.data > data){
			return search(root.left, data);
		}else if(root.data < data){
			return search(root.right, data);
		}
		return false;
	}

	public static Node delete(Node root, int data){
		
	}

	public static void main(String[] args){
		int[] arr = {5,1,3,4,2,7};
		Node root = null;
		for(int i=0; i<arr.length; i++){
			root = insert(root, arr[i]);
		}
		inOrder(root);
		System.out.println();

		System.out.println(search(root, 4));
	}
}