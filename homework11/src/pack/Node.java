package pack;

public class Node<T> {
	public T Data;
	public Node<T> NextNode;
	
	public Node() {
		NextNode = null;
	}
	
	public Node(T data){
		this.Data = data;
		this.NextNode = null;
	}

}