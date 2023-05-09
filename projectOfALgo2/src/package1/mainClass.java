package package1;

//import java.util.*;
//import java.io.*;
//import java.nio.file.*;
//import java.nio.file.attribute.BasicFileAttributes;
//
public class mainClass {
	public static void main(String argvs[]) {
		BST tree = new BST();
		tree.insert(4);
		tree.insert(3);
		tree.insert(5);
		tree.insert(2);
		tree.insert(6);
		tree.insert(7);
		tree.insert(1);
		tree.convertBSTtoAVL();
	}
}
