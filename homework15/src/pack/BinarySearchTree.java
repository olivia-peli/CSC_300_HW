package pack;

public class BinarySearchTree {
	   private Node root;
	   
	   public BinarySearchTree() {
	      root = null;
	   }
	   
	   public Node getRoot() {
	      return root;
	   }
	   
	   public Node search(int desiredKey) {
	      Node currentNode = root;
	      while (currentNode != null) {
	         if (currentNode.key == desiredKey) {
	            return currentNode;
	         }
	         else if (desiredKey < currentNode.key) {
	            currentNode = currentNode.left;
	         }
	         else {
	            currentNode = currentNode.right;
	         }
	      }
	      return null;
	   }
	   
	   public void insert(Node node) {
	      if (root == null) {
	         root = node;
	      }
	      else {
	         Node currentNode = root;
	         while (currentNode != null) {
	            if (node.key < currentNode.key) {
	               if (currentNode.left == null) {
	                  currentNode.left = node;
	                  currentNode = null;
	               }
	               else {
	                  currentNode = currentNode.left;
	               }
	            }
	            else {
	               if (currentNode.right == null) {
	                  currentNode.right = node;
	                  currentNode = null;
	               }
	               else {
	                  currentNode = currentNode.right;
	               }
	            }
	         }
	      }
	   }
	   
	   public boolean remove(int key) {
	      Node parent = null;
	      Node currentNode = root;

	      while (currentNode != null) {
	         if (currentNode.key == key) {
	            if (currentNode.left == null && currentNode.right == null) {
	               if (parent == null) { 
	                  root = null;
	               }
	               else if (parent.left == currentNode) { 
	                  parent.left = null;
	               }
	               else {
	                  parent.right = null;
	               }
	               return true; 
	            }
	            else if (currentNode.left != null && currentNode.right == null) {
	               if (parent == null) { 
	                  root = currentNode.left;
	               }
	               else if (parent.left == currentNode) {
	                  parent.left = currentNode.left;
	               }
	               else {
	                  parent.right = currentNode.left;
	               }
	               return true; 
	            }
	            else if (currentNode.left == null && currentNode.right != null) {
	               if (parent == null) { 
	                  root = currentNode.right;
	               }
	               else if (parent.left == currentNode) {
	                  parent.left = currentNode.right;
	               }
	               else {
	                  parent.right = currentNode.right;
	               }
	               return true; 
	            }
	            else {
	               Node successor = currentNode.right;
	               while (successor.left != null) {
	                  successor = successor.left;
	               }
	               currentNode.key = successor.key; 
	               parent = currentNode;
	               currentNode = currentNode.right; 
	               key = successor.key;             
	            }
	         }
	         else if (currentNode.key < key) {
	            parent = currentNode;
	            currentNode = currentNode.right;
	         }
	         else { 
	            parent = currentNode;
	            currentNode = currentNode.left;
	         }
	      }
	      return false;
	   }
}
