import java.util.*;

public class Traversal{
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

		//Pre Order Traversal
		public static void  preOrder(Node root){
			if(root != null){
				System.out.print(root.data+" ");
				preOrder(root.left);
				preOrder(root.right);
			}
		}

		//In Order Traversal
		public static void  inOrder(Node root){
			if(root != null){
				inOrder(root.left);
				System.out.print(root.data+" ");
				inOrder(root.right);
			}
		}

		//Post Order Traversal
		public static void  postOrder(Node root){
			if(root != null){
				postOrder(root.left);
				postOrder(root.right);
				System.out.print(root.data+" ");
			}
		}

		//Level Order Traversal
		public static void levelOrder(Node root){
			Queue<Node> q = new LinkedList<>();
			q.add(root);

			while(!q.isEmpty()){
				Node currNode = q.poll();
				System.out.print(currNode.data+" ");

				if(currNode.left != null){
					q.add(currNode.left);
				}

				if(currNode.right != null){
					q.add(currNode.right);
				}
			}
		}

		static class Info{
			Node node;
			int d;

			Info(Node node, int d){
				this.node = node;
				this.d = d;
			}
		}

		// Level Order Traversal in list
		public static List<List<Integer>> levelTraversal(Node root){
			List<List<Integer>> result = new ArrayList<>();
			if(root == null) return result;

			Queue<Info> q = new LinkedList<>();
			Map<Integer, Integer>  map = new HashMap<>();
			q.add(new Info(root, 0));

			while(!q.isEmpty()){
				Info currInfo = q.poll();
				Node curr = currInfo.node;
				int d = currInfo.d;

				map.put(hd, curr.data);

				if(root.left != null){
					q.add(new Info(curr.left, d+1));
				}

				if(root.right != null){
					q.add(new Info(curr.right, ))
				}
			}
		}
	}
	public static void main(String[] args) {
		int[] arr = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree(arr);
		System.out.println(root.data);

		System.out.print("The pre order traversal of the tree: ");
		tree.preOrder(root);
		System.out.println();

		System.out.print("The in order traversal of the tree: ");
		tree.inOrder(root);
		System.out.println();

		System.out.print("The post order traversal of the tree: ");
		tree.postOrder(root);
		System.out.println();

		System.out.print("The level order traversal of the tree: ");
		tree.levelOrder(root);
		System.out.println();
	}
}