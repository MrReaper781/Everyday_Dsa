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

	static class Tree{
		static int idx = -1;
		public static Node buildTree(int[] arr){
			idx++;
			if(arr[idx] == -1){
				return null;
			}
			Node newNode = new Node(arr[idx]);
			newNode.left = buildTree(arr);
			newNode.right = buildTree(arr);

			return newNode;
		}

		// Left Most part of the tree -> 1,2,4
		public static void printLeft(Node root){
			if(root != null){
				System.out.print(root.data+" ");
				printLeft(root.left);
			}
		}

		// Right most part of the tree -> 1,3,6
		public static void printRight(Node root){
			if(root != null){
				System.out.print(root.data+" ");
				printRight(root.right);
			}
		}
	}
	public static void main(String[] args) {
		int[] arr = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
		Tree tree = new Tree();
		Node root = tree.buildTree(arr);

		System.out.print("The left most part of the tree: ");
		tree.printLeft(root);
		System.out.println();

		System.out.print("The right most part of the tree: ");
		tree.printRight(root);
		System.out.println();
	}
}