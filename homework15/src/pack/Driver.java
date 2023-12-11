package pack;

public class Driver {

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		
		tree.insert(new Node(4));
		tree.insert(new Node(5));
		tree.insert(new Node(8));
		tree.insert(new Node(0));
		tree.insert(new Node(1));
		tree.insert(new Node(9));
		tree.insert(new Node(7));
		tree.insert(new Node(2));
		tree.insert(new Node(6));
		tree.insert(new Node(3));
		
		System.out.println(BSTPrint.treeToString(tree.getRoot()));
	    System.out.println();
	    
	    tree.remove(4);
	    tree.remove(7);
	    tree.remove(0);
	    
	    System.out.println(BSTPrint.treeToString(tree.getRoot()));
	    System.out.println();
	    
	    System.out.println(tree.search(2));
	    System.out.println(tree.search(5));
	    System.out.println(tree.search(4));
	}

}
