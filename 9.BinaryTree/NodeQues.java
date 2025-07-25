import java.util.*;

public class NodeQues{
	static class Node{
		int data;
		Node left;
		Node right;

		Node(int data){
			this.data = data;
			this.left = this.right = null;
		}
	}

	static class BinaryTree{
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

		// To count the number of nodes
		public static int countNodes(Node root){
			if(root == null){
				return 0;
			}
			int leftCount = countNodes(root.left);
			int rightCount = countNodes(root.right);
			
			return leftCount + rightCount + 1;
		}

		// To get the total data of the nodes
		public static int sumOfNodes(Node root){
			if(root == null){
				return 0;
			}
			int leftSum = sumOfNodes(root.left);
			int rightSum = sumOfNodes(root.right);
			
			return leftSum + rightSum + root.data;
		}

		// To get the height of the tree
		public static int height(Node root){
			if(root == null){
				return 0;
			}
			int leftSubtree = height(root.left);
			int rightSubtree = height(root.right);
			int heightOfTree = Math.max(leftSubtree, rightSubtree)+1;

			return heightOfTree;
		}

		// To find the diameter of the tree -> Approach I (O(N^2));
		public static int diameter(Node root){
			if(root == null){
				return 0;
			}
			int diam1 = diameter(root.left);
			int diam2 = diameter(root.right);
			int diam3 = height(root.left) + height(root.right) + 1;

			return Math.max(diam3, Math.max(diam2, diam1));
		}

		// To find the diameter of the tree -> Approach II (O(N))
		// for doing this we need to create aa custom class which consists of height and diameter
		static class TreeNode{
			int ht;
			int diam;

			TreeNode(int ht, int diam){
				this.ht = ht;
				this.diam = diam;
			}
		}

		public static TreeNode diameter2(Node root){
			if(root == null){
				return new TreeNode(0, 0);
			}

			TreeNode left = diameter2(root.left);
			TreeNode right = diameter2(root.right);
			int myHeight = Math.max(left.ht, right.ht) + 1;

			int diam1 = diameter2(root.left);
			int diam2 = diameter2(root.right);
			int diam3 = left.ht + right.ht + 1;

			int myDiam = Math.max(diam3, Math.max(diam1, diam2));
			TreeNode newNode = new TreeNode(myHeight, myDiam);
			return newNode;
		}

	}

	public static void main(String[] args) {
		int[] arr = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree(arr);
		System.out.println(root.data);
		System.out.println(tree.countNodes(root));
		System.out.println(tree.sumOfNodes(root));
		System.out.println(tree.height(root));
		System.out.println(tree.diameter(root));
		System.out.println("Height of the tree: "+tree.diameter2(root).ht+", \nDiameter of the tree: "+tree.diameter2(root).diam);
	}
}