public class BinaryTree{
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
		public static Node insert(int[] arr){
			idx++;
			if(arr[idx] == -1){
				return null;
			}
			Node newNode = new Node(arr[idx]);
			newNode.left = insert(arr);
			newNode.right = insert(arr);

			return newNode;
		}
	}
	public static void main(String[] args) {
		int[] arr = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
		Tree tree = new Tree();
		Node root = tree.insert(arr);
		System.out.println(root.data);
	}
}