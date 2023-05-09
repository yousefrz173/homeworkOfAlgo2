package package1;

//import java.util.*;
//import java.io.*;
//import java.nio.file.*;
//import java.nio.file.attribute.BasicFileAttributes;
//
public class mainClass {
	public static void main(String argvs[]) {
		BST tree = new BST();
		tree.insert(10);
		tree.insert(20);
		tree.insert(15);
		tree.insert(5);
		tree.insert(7);
		tree.insert(4);
		tree.insert(3);
		tree.isbst();
		
//		// creating an object of the class BTreeLevelOrder
//		BTreeLevelOrder tree = new BTreeLevelOrder();
//
//		// root node
//		tree.r = new TreeNode(18);
//
//		// remaining nodes of the tree
//		tree.r.left = new TreeNode(20);
//		tree.r.right = new TreeNode(30);
//		tree.r.left.left = new TreeNode(60);
//		tree.r.left.right = new TreeNode(34);
//		tree.r.right.left = new TreeNode(45);
//		tree.r.right.right = new TreeNode(65);
//		tree.r.left.left.left = new TreeNode(12);
//		tree.r.left.left.right = new TreeNode(50);
//		tree.r.left.right.left = new TreeNode(98);
//		tree.r.left.right.right = new TreeNode(82);
//		tree.r.right.left.left = new TreeNode(31);
//		tree.r.right.left.right = new TreeNode(59);
//		tree.r.right.right.left = new TreeNode(71);
//		tree.r.right.right.right = new TreeNode(41);
//
//		System.out.println("Level order traversal of binary tree is ");
//		tree.displayLevelOrder();
	}
}
//	public static void main(String[] arguments) {
//		Scanner in = new Scanner(System.in);
////		int a = in.nextInt();
////		int b = in.nextInt();
////		int d = in.nextInt();
////		int e = in.nextInt();
////		int c = in.nextInt();
//		BST bisetr = new BST();
//		bisetr.insert(15);
//		bisetr.insert(20);
//		bisetr.insert(30);
//		bisetr.insert(10);
//		bisetr.insert(12);
//	//	System.out.println(bisetr.search(d).data);
//	}
//}
//
//class BST {
//	static class Node {
//		private int data;
//		private Node left;
//		private Node right;
//
//		public Node(int data) {
//			this.data = data;
//		}
//	}
//
//	Node root;
//
////	public BST() {
////		root = null;
////	}
//
//	public void insert(int data) {
//		Node node = new Node(data);
//		if (root == null) {
//			root = node;
//			return;
//		}
//		Node currentent = root;
//		Node parent = null;
//		while (currentent != null) {
//			parent = currentent;
//			if (node.data < currentent.data) {
//				currentent = currentent.left;
//			} else {
//				currentent = currentent.right;
//			}
//		}
//		if (node.data < parent.data) {
//			parent.left = node;
//		} else {
//			parent.right = node;
//		}
//	}
//
//	Node search(int data) {
//		Node current = root;
//		if (current.data == data) {
//			return current;
//		}
//		while (true) {
//			if (current == null)
//				return current;
//
//			if (current.data > data) {
//
//				if (current.data == data)
//					return current;
//				current = current.left;
//			} else {
//				if (current.data == data)
//					return current;
//				current = current.right;
//			}
//		}
//	}
//
//	Node maxv(Node node) {
//		if (node == null)
//			return node;
//		Node n1 = maxv(node.right);
//		Node n2 = maxv(node.left);
//		if (n1.data > n2.data)
//			return n1;
//		else
//			return n2;
//	}
//
//	boolean isBST(Node root) {
//		if (root == null)
//			return true;
//
//		if (root.left != null && root.data < maxv(root.left).data)
//			return false;
//
//		if (root.right != null && root.data > minv(root.right))
//			return false;
//		return false;
//
//	}
//
//	int minv(Node node) {
//		if (node == null)
//			return Integer.MIN_VALUE;
//		Node n1 = maxv(node.right);
//		Node n2 = maxv(node.left);
//		if (n1.data < n2.data)
//			return n1.data;
//		else
//			return n2.data;
//	}
//}
