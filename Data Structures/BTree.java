import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Nisarg Program : Binary Tree Implementation and Traversal
 */
public class BTree {

	public static class Node {
		Node left;
		Node right;
		int data;

		public Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		int[] nodes = { 4, 1, 5, 3, 6, 2, 8, 1 };
		int[] nodes1 = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] nodes2 = { 4, 2, 6, 1, 5, 3, 7, 8 };
		Node root = createTree(nodes);

		System.out.println("\nInOrder Traversal: ");
		inOrderTraversal(root);
		System.out.println("\nPreOrder Traversal: ");
		preOrderTraversal(root);
		System.out.println("\nPostOrder Traversal: ");
		postOrderTraversal(root);
		System.out.println("\nLevelOrder Traversal: ");
		levelOrderTraversal(root);
		System.out.println("\nHeight of the tree:" + height(root));

		System.out.println("\nBFS Traversal: ");
		levelOrderTraversalUsingQueue(root);

		System.out.println("Lowest Common Ancestor:"
				+ lowestCommonAncestor(root, 8, 6));

		System.out.println("Tree Paths:");
		ArrayList<Integer> path = new ArrayList<Integer>();
		rootToLeafPath(root, path, 0);

		// Node nodeList = treeToList(root);
		// System.out.println(nodeList);

		Node root3 = createTree(nodes2);
		System.out.println(isBalancedTree(root) ? "Trees is balanced"
				: "Trees is not balanced");
		System.out.println(isBalancedTree(root3) ? "Trees is balanced"
				: "Trees is not balanced");

		Node root2 = createTree(nodes1);
		System.out
				.println(areIdenticalTrees(root, root2) ? "Trees are identical"
						: "Trees are different");
		System.out
				.println(areIdenticalTrees(root, root) ? "Trees are identical"
						: "Trees are different");

		System.out.println("\nNormal Tree InOrder Traversal: ");
		inOrderTraversal(root2);
		createMirrorTree(root2);
		System.out.println("\nMirror Tree InOrder Traversal: ");
		inOrderTraversal(root2);

		Node root1 = createTree(nodes1);
		deleteTree(root1);
		root1 = null;
		System.out.println("\nInOrder Traversal after tree deletion: ");
		inOrderTraversal(root1);

	}

	public static Node createTree(int[] nodes) {
		Node root = new Node(nodes[0]);
		for (int j = 1; j < nodes.length; j++) {
			insertNode(root, nodes[j]);
		}
		return root;
	}

	public static void insertNode(Node root, int data) {
		if (root == null)
			return;
		if (data <= root.data) {
			if (root.left != null) {
				insertNode(root.left, data);
			} else {
				root.left = new Node(data);
			}
		} else if (data > root.data) {
			if (root.right != null) {
				insertNode(root.right, data);
			} else
				root.right = new Node(data);
		}
	}

	public static void inOrderTraversal(Node root) {
		if (root == null) {
			return;
		} else {
			inOrderTraversal(root.left);
			System.out.print(root.data + " ");
			inOrderTraversal(root.right);
		}
	}

	public static void preOrderTraversal(Node root) {
		if (root == null) {
			return;
		} else {
			System.out.print(root.data + " ");
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);
		}
	}

	public static void postOrderTraversal(Node root) {
		if (root == null) {
			return;
		} else {
			postOrderTraversal(root.left);
			postOrderTraversal(root.right);
			System.out.print(root.data + " ");
		}
	}

	public static int height(Node root) {
		if (root == null)
			return 0;
		else {
			int l_height = height(root.left);
			int r_height = height(root.right);

			if (l_height > r_height)
				return l_height + 1;
			else
				return r_height + 1;
		}
	}

	/**
	 * Level Order Traversal with O(n^2) time complexity
	 * 
	 * @param root
	 */
	public static void levelOrderTraversal(Node root) {
		if (root == null)
			return;
		else {
			int h = height(root);
			for (int i = 1; i <= h; i++) {
				printLevelOrder(root, i);
			}
		}
	}

	public static void printLevelOrder(Node root, int level) {
		if (root == null)
			return;
		if (level == 1)
			System.out.print(root.data + " ");
		else if (level > 1) {
			printLevelOrder(root.left, level - 1);
			printLevelOrder(root.right, level - 1);
		}
	}

	/**
	 * Level Order Traversal using queue with O(n) time complexity
	 */
	public static void levelOrderTraversalUsingQueue(Node root) {
		if (root == null)
			return;
		Queue q = new Queue();
		q.enqueue(root);

		Node temp = root;
		while (!q.isEmpty()) {
			temp = (Node) q.dequeue();
			if (temp.left != null)
				q.enqueue(temp.left);
			if (temp.right != null)
				q.enqueue(temp.right);

			if (temp != null)
				System.out.print(temp.data + " ");

		}
		System.out.println("\n");
	}

	public static boolean covers(Node root, int a) {
		if (root == null)
			return false;
		if (root.data == a)
			return true;
		return covers(root.left, a) || covers(root.right, a);
	}

	public static int lowestCommonAncestor(Node root, int a, int b) {
		if (!covers(root, a) || !covers(root, b)) {
			return 0;
		}
		return commonAncestorHelper(root, a, b);
	}

	public static int commonAncestorHelper(Node root, int a, int b) {
		// TODO Auto-generated method stub
		if (root == null)
			return 0;
		if (root.data == a || root.data == b)
			return root.data;

		boolean is_a_on_left = covers(root.left, a);
		boolean is_b_on_left = covers(root.left, b);

		if (is_a_on_left != is_b_on_left)
			return root.data;

		Node childRoot = is_a_on_left ? root.left : root.right;
		return commonAncestorHelper(childRoot, a, b);
	}

	public static void deleteTree(Node root) {
		if (root == null)
			return;

		deleteTree(root.left);
		deleteTree(root.right);

		if (root.left == null && root.right == null)
			deleteTree(root = null);
	}

	public static void createMirrorTree(Node root) {
		if (root == null)
			return;
		Node temp;
		createMirrorTree(root.left);
		createMirrorTree(root.right);

		temp = root.left;
		root.left = root.right;
		root.right = temp;
	}

	public static boolean areIdenticalTrees(Node root1, Node root2) {
		if (root1 == null && root2 == null)
			return true;
		else if (root1 != null && root2 != null) {
			return areIdenticalTrees(root1.left, root2.left)
					&& areIdenticalTrees(root1.right, root2.right);
		} else
			return false;
	}

	public static Node treeToList(Node root) {
		if (root == null)
			return null;
		Node aList = treeToList(root.left);
		Node bList = treeToList(root.right);

		root.left = root;
		root.right = root;

		aList = append(aList, root);
		aList = append(aList, bList);

		return aList;
	}

	public static Node append(Node aList, Node bList) {
		// TODO Auto-generated method stub
		if (aList == null)
			return bList;
		if (bList == null)
			return aList;

		Node aLast = aList.left;
		Node bLast = bList.left;

		join(aLast, bList);
		join(bLast, aList);

		return aList;
	}

	public static void join(Node a, Node b) {
		// TODO Auto-generated method stub
		a.right = b;
		b.left = a;
	}

	public static void printPath(ArrayList<Integer> path, int pathlen) {
		for (int k = 0; k < pathlen; k++) {
			System.out.print(path.get(k) + " ");
		}
		System.out.print("\n");
	}

	public static void rootToLeafPath(Node root, ArrayList<Integer> path,
			int pathlen) {
		if (root == null)
			return;

		path.add(pathlen, root.data);
		pathlen++;

		if (root.left == null && root.right == null) {
			printPath(path, pathlen);
		} else {
			rootToLeafPath(root.left, path, pathlen);
			rootToLeafPath(root.right, path, pathlen);
		}
	}

	public static boolean isBalancedTree(Node root) {
		if (root == null)
			return true;
		else {
			int l_height = height(root.left);
			int r_height = height(root.right);

			if (Math.abs(l_height - r_height) <= 1 && isBalancedTree(root.left)
					&& isBalancedTree(root.right))
				return true;
			else
				return false;
		}
	}
}
