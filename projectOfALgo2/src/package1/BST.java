package package1;

import java.util.Vector;

public class BST {
	private class Node {
		private int value;
		private Node leftChild;
		private Node rightChild;

		Node(int value) {
			this.value = value;
		}
	}

	private Node root;

	public void insert(int value) { // recursion
		root = insert(value, root);
	}

	private Node insert(int value, Node root) { // recursion

		if (root == null) {
			return new Node(value);
		}

		if (value < root.value) {
			root.leftChild = insert(value, root.leftChild);
		} else {
			if (value > root.value)
				root.rightChild = insert(value, root.rightChild);
		}
		return root;
	}

	public void Insert(int value) { // repetitive
		Node node = new Node(value);
		if (root == null) {
			root = node;
		}
		Node current = root;
		while (true) {
			if (value < current.value) {
				if (current.leftChild == null) {
					current.leftChild = node;
					return;
				}
				current = current.leftChild;
			} else {
				if (value > current.value) {
					if (current.rightChild == null) {
						current.rightChild = node;
						return;
					}
					current = current.rightChild;
				}
			}
			if (current.value == value)
				return;
		}
	}

	public void delete(int data) {
		root = delete(root, data);
	}

	private Node delete(Node root, int data) {
		if (root == null)
			return root;
		if (root.value > data)
			root.leftChild = delete(root.leftChild, data);
		else if (root.value < data)
			root.rightChild = delete(root.rightChild, data);
		else {
			if (root.leftChild == null)
				return root.rightChild;
			else if (root.rightChild == null)
				return root.leftChild;
			else {
				root.value = maxv(root.leftChild);
				root.leftChild = delete(root.leftChild, root.value);
			}

		}
		return root;
	}

	int maxv(Node node) {
		Node temp = node;
		while (temp != null) {
			if (temp.rightChild == null) {
				return temp.value;
			}
			temp = temp.rightChild;
		}
		return -1;
	}

	public boolean isbst() {
		Vector<Integer> nodes = new Vector<Integer>();
		storeNodesInVectoR(root, nodes);
		for (int i = 0; i < nodes.size() - 1; i++) {
			if (nodes.get(i) > nodes.get(i + 1))
				return false;
		}
		return true;
	}

	public void insertRandom(int value) {
		Node node = new Node(value);
		if (root == null) {
			root = node;
		}
		Node current = root;
		while (true) {
			if (value > current.value) {
				if (current.leftChild == null) {
					current.leftChild = node;
					return;
				}
				current = current.leftChild;
			} else {
				if (value < current.value) {
					if (current.rightChild == null) {
						current.rightChild = node;
						return;
					}
					current = current.rightChild;
				}
			}
			if (current.value == value)
				return;
		}

	}

	public void remove(int value) {
		root = remove(value, root);
	}

	private Node remove(int value, Node node) {
		if (node == null)
			return node;
		if (isLeaf(node)) {
			return null;
		}

		Node current = accessNode(value);
		if (hasRightChild(current)) {
			replaceWithRightChild(current);
		} else if (hasLeftChild(current)) {
			replaceWithLeftChild(current);
		}
		return current;
	}

	private void replaceWithLeftChild(Node node) {
		node = node.leftChild;
	}

	private void replaceWithRightChild(Node node) {
		node = node.rightChild;
	}

	private Node accessNode(int value) {
		return accessNode(value, root);
	}

	private Node accessNode(int value, Node root) {
		if (root == null || root.value == value)
			return root;
		if (value > root.value)
			return accessNode(value, root.rightChild);
		else if (value < root.value)
			return accessNode(value, root.leftChild);
		return null;
	}

	public boolean search(int value) { // recursion
		return search(value, root);
	}

	private boolean search(int value, Node root) { // recursion
		if (root == null)
			return false;
		if (root.value == value)
			return true;
		if (value > root.value)
			return search(value, root.rightChild);
		else if (value < root.value)
			return search(value, root.leftChild);
		return false;
	}

	public boolean Search(int value) { // repetitive
		if (root.value == value)
			return true;
		Node current = root;
		while (current != null) {
			if (current.value == value)
				return true;
			if (value < current.value)
				current = current.leftChild;
			else if (value > current.value)
				current = current.rightChild;
		}
		return false;
	}

	public int findSmallestNode() {
		Node current = root;
		while (current != null) {
			if (isLeaf(current) || hasRightChild(current))
				return current.value;
			current = current.leftChild;
		}
		return -1;
	}

	private boolean isLeaf(Node node) {
		return node.leftChild == null && node.rightChild == null;
	}

	private boolean hasRightChild(Node node) {
		return node.leftChild == null && node.rightChild != null;
	}

	private boolean hasLeftChild(Node node) {
		return node.leftChild != null && node.rightChild == null;
	}

//	public int findLargestNode() {
//		if (LargestNode() != null)
//			return LargestNode().value;
//		return -1;
//	}

	public int LargestNode() {
		Node current = root;
		while (current != null) {
			if (current.rightChild == null)
				return current.value;
			current = current.rightChild;
		}
		return -1;
	}

	public void convertBSTtoAVL() {
		root = convertBSTtoAVL(root);
	}

	private Node convertBSTtoAVL(Node root) {
		// store tree nodes in an In-order vector
		Vector<Node> inOrderVector = new Vector<Node>();
		storeNodesInVector(root, inOrderVector);
		return buildTreeFromArray(inOrderVector);
	}

	private void storeNodesInVector(Node root, Vector<Node> nodes) {
		if (root != null) {
			storeNodesInVector(root.leftChild, nodes);
			nodes.add(root);
			storeNodesInVector(root.rightChild, nodes);
		}
		return;
	}

	private void storeNodesInVectoR(Node root, Vector<Integer> nodes) {
		if (root != null) {
			storeNodesInVectoR(root.leftChild, nodes);
			nodes.add(root.value);
			storeNodesInVectoR(root.rightChild, nodes);
		}
		return;
	}

	// function for building tree from in order array
	private Node buildTreeFromArray(Vector<Node> nodes) {
		if (nodes.size() == 0) {
			return null;
		}
		int mid = (nodes.size() / 2);
		// find mid and make it the root
		Node root = nodes.get(mid);

		// find the left sub array and store it in a vector
		Vector<Node> leftSubArray = new Vector<Node>();
		for (int i = 0; i < mid; i++) {
			leftSubArray.add(nodes.get(i));
		}
		root.leftChild = buildTreeFromArray(leftSubArray);

		// find the right sub array and store it in a vector
		Vector<Node> rightSubArray = new Vector<Node>();
		for (int i = mid + 1; i < nodes.size(); i++) {
			rightSubArray.add(nodes.get(i));
		}
		root.rightChild = buildTreeFromArray(rightSubArray);

		return root;
	}

	public void printPyramidTree() {
		printPyramidTree(root, 0, 2);
	}

	private void printPyramidTree(Node root, int space, int ratio) {
		// base case
		if (root == null)
			return;
		space += ratio;

		printPyramidTree(root.rightChild, space, ratio);

		System.out.print("\n");
		for (int i = ratio; i < space; i++)
			System.out.print("\t");
		System.out.print(root.value + "\n");

		printPyramidTree(root.leftChild, space, ratio);
	}
}
