package pack;

public class LinkedList<T> {
	public Node<T> Head;
	public Node<T> Tail;
	public int Size;
	
	public LinkedList() {
		this.Head = null;
		this.Tail = null;
		this.Size = 0;
	}
	
	//insert after
	public void InsertAfter(Node<T> cNode, T tar) {
		Node<T> nNode = cNode.NextNode;
		Node<T> newNode = new Node<T>(tar);
		cNode.NextNode = newNode;
		newNode.NextNode = nNode;

		this.Size++;
	}
	
	
	//remove after
	public void RemoveAfter(Node<T> node) {
		if (node.NextNode == null) {
			return;
		}
		Node<T> cNode = node.NextNode;
		Node<T> nNode = cNode.NextNode;
		//delete cNode
		cNode.NextNode = null;
		
		node.NextNode = nNode;
		this.Size--;
	}
	
	
	//search
	public Node<T> Search(T tar){
		Node<T> current = this.Head;
		while(current != null) {
			if (current.Data.equals(tar)) {
				return current;
			}
			current = current.NextNode;
		}
		return null;
	}
	
	public void Append(T tar) {
		Node<T> node = new Node<T>(tar);
		//when there is no node there
		if (this.Head == null) {
			this.Head = node;
			this.Tail = node;
		}
		this.Tail.NextNode = node;
		this.Tail = node;
		this.Size++;
	}
	
	public void prepend(T tar) {
		Node<T> node = new Node<T>(tar);
		   if (this.Head == null) {
		      this.Head = node;
		      this.Tail = node;
		   }
		   else {
		      node.NextNode = Head;
		      Head = node;
		   }
		}
	
	public void printList(Node<T> node) {   
		while (node != null){  
			System.out.print(node + " ");  
			node = node.NextNode;  
			}  
		System.out.println();  
	}  
	
    void printReverse(Node<T> head)
    {
        if (head == null) {
        	return;
        }
        printReverse(head.NextNode);
        System.out.print(head +" ");
    }
}