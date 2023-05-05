package package1;

//A class for creation of nodes of the binary Tree  
//nodes of the binary tree contain   
//a left and a right reference  
//and a value of the node  
public class TreeNode {
//for holding value of the node  
	int val;

//for referring to the other nodes  
	TreeNode left, right;

//constructor of the class TreeNode  
//the construct initializes the class fields  
	public TreeNode(int i) {
		val = i;
		right = left = null;
	}
}

class BTreeLevelOrder {
//top node i.e. root of the Binary Tree  
	TreeNode r;

//constructor of the class BTree  
	public BTreeLevelOrder() {
		r = null;
	}

//method for displaying the level order traversal of the binary tree  
	void displayLevelOrder() {
		int ht = treeHeight(r);
		int j;

		for (j = 1; j <= ht; j++) {
			displayCurrentLevel(r, j);
		}
	}

//finding the "height" of the binary tree  
//Note that the total number of nodes  
//present in the longest path from the topmost node (root node_  
//to the leaf node, which is farthest from the root node, gives the  
//height of the  tree  
	int treeHeight(TreeNode r) {
		if (r == null) {
			return 0;
		} else {
//finding the height of the left and right subtrees  
			int lh = treeHeight(r.left);
			int rh = treeHeight(r.right);

//picking up the larger one  
			if (lh > rh) {
				return (lh + 1);
			} else {
				return (rh + 1);
			}
		}
	}

//Printing nodes present in the current level  
	void displayCurrentLevel(TreeNode r, int l) {
//null means nothing is there to print  
		if (r == null) {
			return;
		}

//l == 1 means only one node   
//is present in the binary tree  
		if (l == 1) {
			System.out.print(r.val + " ");
		}

//l > 1 means either there are nodes present in  
//the left side of the current node or in the   
//right side of the current node or in both sides  
//therefore, we have to look in the left as well as in   
//the right side of the current node  
		else if (l > 1) {
			displayCurrentLevel(r.left, l - 1);
			displayCurrentLevel(r.right, l - 1);
		}
	}

//main method  
	public static void main(String argvs[]) {
//creating an object of the class BTreeLevelOrder   
		BTreeLevelOrder tree = new BTreeLevelOrder();

//root node  
		tree.r = new TreeNode(18);

//remaining nodes of the tree  
		tree.r.left = new TreeNode(20);
		tree.r.right = new TreeNode(30);
		tree.r.left.left = new TreeNode(60);
		tree.r.left.right = new TreeNode(34);
		tree.r.right.left = new TreeNode(45);
		tree.r.right.right = new TreeNode(65);
		tree.r.left.left.left = new TreeNode(12);
		tree.r.left.left.right = new TreeNode(50);
		tree.r.left.right.left = new TreeNode(98);
		tree.r.left.right.right = new TreeNode(82);
		tree.r.right.left.left = new TreeNode(31);
		tree.r.right.left.right = new TreeNode(59);
		tree.r.right.right.left = new TreeNode(71);
		tree.r.right.right.right = new TreeNode(41);

		System.out.println("Level order traversal of binary tree is ");
		tree.displayLevelOrder();
	}
}
