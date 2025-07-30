import java.util.*;

public class PathSum{
	static class Node{
		int data;
		Node left;
		Node right;

		Node(int data){
			this.data = data;
			this.left = this.right = null;
		}
	}

	static class BT{
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

		public static int sum(Node root){
			if(root == null) return 0;
			int left = sum(root.left);
			int right = sum(root.right);

			int sum = left + right + root.data;
			return sum;
		}
		public static boolean exists(Node root, int target){
			if(root == null) return false;
			if(sum(root) == target) return true;
			return exists(root.left, target-root.data) || exists(root.right, target-root.data);
		}
	}

	public static void main(String[] args) {
		int[] arr = {5, 4, 11, 7, -1, -1, 2, -1, -1, -1, 8, 13, -1, -1, 4, -1, 1, -1, -1};
		BT tree = new BT();
		Node root = tree.buildTree(arr);

		System.out.println(tree.exists(root, 22));
	}
}