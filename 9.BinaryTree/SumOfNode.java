import java.util.*;

public class SumOfNode{
	static class Node{
		int data;
		Node left;
		Node right;

		Node(int data){
			this.data = data;
			this.left = this.right = null;
		}
	}

	//Traversal at kth order
	static class BinaryTree{
		static int idx = -1;

		public static Node buildTree(int[] arr){
			idx++;
			if(idx >= arr.length || arr[idx] == -1){
				return null;
			}

			Node newNode = new Node(arr[idx]);
			newNode.left = buildTree(arr);
			newNode.right = buildTree(arr);
			return newNode;
		}

		//Approach I -> Brute force approach by using (BFS + Map) (T.C - O(N) & S.C. - O(h)) where h is the height of the tree 
		static class Info{
			Node node;
			int count;

			Info(Node node, int count){
				this.count = count;
				this.node = node;
			}
		}

		public static int sumOfNodeAtKthOrder(Node root, int k){
			if(root == null){
				return 0;
			}

			int totalSum = 0;
			Queue<Info> q = new LinkedList<>();
			Map<Integer, Integer> map = new TreeMap<>();
			q.add(new Info(root, 1));
			while(!q.isEmpty()){
				Info currInfo = q.poll();
				Node curr = currInfo.node;
				int count = currInfo.count;

				map.put(count, map.getOrDefault(count, 0) + curr.data);

				if(curr.left != null){
					q.add(new Info(curr.left, count+1));
				}

				if(curr.right != null){
					q.add(new Info(curr.right, count+1));
				}
			}

			int result = 0;
			for(Map.Entry<Integer, Integer> e : map.entrySet()){
				if(e.getKey() == k){
					result = e.getValue();
				}
			}

			return result;
		}

		//Approach II -> using BFS approach (T.C. - O(N) & S.C. - O(1))
		public static int sumOfNodeKth(Node root, int k){
			return rootHelper(root, 1, k);
		}

		public static int rootHelper(Node root, int currentLevel, int targetLevel){
			if(root == null) return 0;
			if(currentLevel == targetLevel) return root.data;

			return rootHelper(root.left, currentLevel + 1, targetLevel) + rootHelper(root.right, currentLevel+1, targetLevel);
		}

	}
	public static void main(String[] args) {
		int[] arr = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree(arr);
		System.out.println(root.data);

		System.out.println(tree.sumOfNodeAtKthOrder(root, 3));
		System.out.println(tree.sumOfNodeKth(root, 2));
	}
}