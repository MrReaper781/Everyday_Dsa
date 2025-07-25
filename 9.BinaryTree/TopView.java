import java.util.*;

public class TopView{
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
		    if (idx >= arr.length || arr[idx] == -1) {
		        return null;
		    }

		    Node newNode = new Node(arr[idx]);
		    newNode.left = buildTree(arr);
		    newNode.right = buildTree(arr);
		    return newNode;
		}

		static class Info{
			Node node;
			int hd;
			Info(Node node, int hd){
				this.node = node;
				this.hd = hd;
			}
		}

	// 	public static List<Integer> topView(Node root){
	// 		if(root == null){
	// 			return new ArrayList<>();
	// 		}

	// 		List<Integer> result = new ArrayList<>();
	// 		Queue<Info> q = new LinkedList<>();
	// 		Map<Integer, Integer> map = new TreeMap<>();
	// 		q.add(new Info(root, 0));

	// 		while(!q.isEmpty()){
	// 			Info currNode = q.poll();
	// 			Node curr = currNode.node;
	// 			int hd = currNode.hd;

	// 			if(!map.containsKey(hd)){
	// 				map.put(hd, curr.data);
	// 			}

	// 			if(curr.left != null){
	// 				q.add(new Info(curr.left, hd-1));
	// 			}

	// 			if(curr.right != null){
	// 				q.add(new Info(curr.right, hd+1));
	// 			}
	// 		}

	// 		for(Integer e : map.values()){
	// 			result.add(e);
	// 		}
	// 		return result;
	// 	}

		public static List<Integer> rightView(Node root){
			if(root == null){
				return new ArrayList<>();
			}

			List<Integer> result = new ArrayList<>();
			Queue<Info> q = new LinkedList<>();
			Map<Integer, Integer> map = new TreeMap<>();
			q.add(new Info(root, 0));

			while(!q.isEmpty()){
				Info currInfo = q.poll();
				Node curr = currInfo.node;
				int hd = currInfo.hd;

				if(!map.containsKey(hd)){
					map.put(hd, curr.data);
				}

				if(curr.right != null){
					q.add(new Info(curr.right, hd+1));
				}

				if(curr.left != null){
					q.add(new Info(curr.left, hd+1));
				}
			}

			for(Integer e : map.values()){
				result.add(e);
			}

			return result;
		}

	}
	public static void main(String[] args) {
		int[] arr = {1,2,-1,4,-1,5,-1,6,-1,-1,3};
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree(arr);
		System.out.println(root.data);

		List<Integer> result = tree.rightView(root);
		
		for(int i : result){
			System.out.print(i+" ");
		}

	}
}