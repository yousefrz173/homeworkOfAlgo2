package package1;

import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 *
 * @author Y
 */
public class miladCode {

	/**
	 * @param args the command line arguments
	 */

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		BST1 bisetr = new BST1();
		bisetr.insert(40);
		bisetr.insert(30);
		bisetr.insert(50);
		bisetr.insert(20);
		bisetr.insert(35);
		bisetr.insert(45);
		bisetr.insert(60);
		bisetr.insert(80);
		bisetr.insert(100);
		bisetr.insert(800);
		bisetr.insert(8000);
		bisetr.insert(700);
		bisetr.insert(29);

		bisetr.printtree(bisetr.getRoot());
		System.out.println(bisetr.isbst());
		/*
		 * System.out.println();
		 * 
		 * bisetr.toAVL(bisetr.getRoot()); System.out.println();
		 * bisetr.print(bisetr.getRoot());
		 * 
		 * ////////second BS tree
		 * 
		 * BST bisetr1 = new BST(); bisetr1.insert(6); bisetr1.insert(5);
		 * bisetr1.insert(7); bisetr1.insert(4); bisetr1.insert(8); bisetr1.insert(9);
		 * bisetr1.insert(3);
		 * 
		 * bisetr1.print(bisetr1.getRoot()); /* bisetr1.toAVL(bisetr1.getRoot());
		 * System.out.println(); bisetr1.print(bisetr1.getRoot());
		 * if(bisetr.isBST(bisetr.getRoot())) System.out.println("YES");
		 */
	}

}

class BST1 {
	class Node {
		int data;
		Node left;
		Node right;
		int hi;

		public Node(int data) {
			this.data = data;
			right = null;
			left = null;
		}
	}

	Node root;
	Vector<Integer> v = new Vector<Integer>();

	Node getRoot() {
		return root;
	}

	public BST1() {
		root = null;
	}

	void insert(int data) {
		Node node = new Node(data);
		if (root == null) {
			root = node;
			return;
		}
		Node curr = root;
		while (true) {
			if (node.data == curr.data)
				return;
			if (node.data < curr.data) {
				if (curr.left == null) {
					curr.left = node;
					curr.left = node;
					return;
				}
				curr = curr.left;
			} else {
				if (curr.right == null) {
					curr.right = node;
					return;
				}
				curr = curr.right;
			}
		}
	}

	Node search(int data) {
		Node curr = root;
		if (curr.data == data) {
			return curr;
		}
		while (true) {
			if (curr == null)
				return curr;

			if (curr.data > data) {

				if (curr.data == data)
					return curr;
				curr = curr.left;
			} else {
				if (curr.data == data)
					return curr;
				curr = curr.right;
			}
		}
	}

	boolean isBST(Node root) {
		if (root == null)
			return true;

		if (root.left != null && root.data < maxv(root.left))
			return false;

		if (root.right != null && root.data > minv(root.right))
			return false;

		if (!isBST(root.left) || !isBST(root.right))
			return false;

		return true;
	}

	int maxv(Node node) {
		if (node == null)
			return Integer.MIN_VALUE;
		int n1 = maxv(node.left);
		int n2 = maxv(node.right);
		return Math.max(Math.max(n2, n2), node.data);
	}

	int minv(Node node) {
		if (node == null)
			return Integer.MAX_VALUE;
		int n1 = minv(node.right);
		int n2 = minv(node.left);
		return Math.min(node.data, Math.min(n2, n1));
	}

	Node delete(Node root, int data) {

		if (root == null)
			return root;
		if (root.data > data)
			root.left = delete(root.left, data);
		else if (root.data < data)
			root.right = delete(root.right, data);
		else {
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;
			else {
				root.data = maxv(root.left);
				root.left = delete(root.left, root.data);
			}

		}
		return root;
	}

	int nodeHi(Node root) {
		if (root == null)
			return 0;
		else {
			int hleft = nodeHi(root.left);
			int hright = nodeHi(root.right);
			if (hleft > hright)
				return hleft + 1;
			else
				return hright + 1;

		}
	}

	void print(Node root) {
		int h = nodeHi(root);
		int i;
		for (i = 1; i <= h; i++) {
			printCurrentLevelNodes(root, i);
			System.out.println();
		}
	}

	void printCurrentLevelNodes(Node root, int i) {
		int h = this.nodeHi(this.getRoot());
		if (root == null) {
			return;
		}
		if (i == 1) {
			/*
			 * if(root.data>this.getRoot().data) { for(int j=i;j<=h;j++)
			 * System.out.print(""); }
			 */
			for (int j = 0; j < this.nodeHi(root); j++)
				System.out.print("       ");
			System.out.print(root.data);

		} else if (i > 1) {

			printCurrentLevelNodes(root.left, i - 1);
			for (int j = 1; j < i; j++)
				System.out.print("   ");
			printCurrentLevelNodes(root.right, i - 1);

		}

	}

	Node toAVL(Node root) {
		/*
		 * if(root==null) return root;
		 */
		int b = getBalance(root);

		if (b > 1 && root.data > root.left.data)

			return rightRotation(root);

		if (b > 1 && root.data > root.left.data) {
			root.left = leftRotation(root.left);

			return rightRotation(root);
		}
		if (b < -1 && root.data < root.right.data)

			return leftRotation(root);

		if (b < -1 && root.data > root.right.data)

		{
			root.right = rightRotation(root.right);

			return leftRotation(root);
		}
		if (root == null)
			return root;
		root.left = toAVL(root.left);
		root.right = toAVL(root.right);

		return root;
	}

	int getBalance(Node root) {
		if (root == null)
			return 0;
		return this.nodeHi(root.left) - this.nodeHi(root.right);
	}

	Node leftRotation(Node root) {

		Node n = root.right;
		Node m = n.left;
		n.left = root;
		root.right = m;
		System.out.println("Done");
		return n;
	}

	Node rightRotation(Node root) {
		Node n = root.left;
		Node m = n.right;
		n.right = root;
		root.left = m;
		System.out.println("Done");
		return n;
	}

	void printtree(Node root) {
		if (root == null) {
			return;
		}
		printtree(root.right);
		for (int i = 0; i < this.getLevel(this.getRoot(), root.data); i++)
			System.out.print("       ");
		System.out.print(root.data);
		System.out.println();
		System.out.println();
		printtree(root.left);

	}

	int getLevel(Node root, int data) {
		int l = 0;
		while (true) {
			if (root == null)
				return 0;
			if (root.data == data)
				return l;
			if (root.data < data) {
				root = root.right;
				l++;
			} else if (root.data > data) {
				root = root.left;
				l++;
			}
		}
	}

	void inorderVector(Node root) {

		if (root == null) {
			return;
		}
		inorderVector(root.left);
		v.add(root.data);
		inorderVector(root.right);

	}

	boolean isbst() {
		this.inorderVector(this.getRoot());
		for (int i = 0; i < this.v.size() - 1; i++) {
			if (v.get(i) >= v.get(i + 1))
				return false;
		}
		return true;
	}

}
