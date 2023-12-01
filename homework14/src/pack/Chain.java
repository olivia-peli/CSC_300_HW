package pack;

public class Chain {
	public Node Header;
	public int Size;
	
	public Chain() {
		this.Header = null;
		this.Size = 0;
	}
	
	//compare every node with its key and input. When there is an item has the key, return true, otherwise return false;
	public boolean SearchByKey(int key) {
		Node temp = this.Header;
		while (temp != null) {
			if (temp.Key == key) {
				return true;
			}
			temp = temp.nextNode;
		}
		return false;
	}
	
	public Node SearchNodeByKey(int key) {
		Node temp = this.Header;
		while (temp != null) {
			if (temp.Key == key) {
				return temp;
			}
			temp = temp.nextNode;
		}
		return null;
	}
	
	public void InsertNode(int key, int value) {
		Node temp = this.Header;
		if (temp == null) {
			this.Header = new Node(key, value);
			this.Size++;
		} else {
			while(temp.nextNode != null) {
				temp = temp.nextNode;
			}
			temp.nextNode = new Node(key, value);
			this.Size++;
		}
	}
	
	@Override
	public String toString() {
		Node temp = this.Header;
		String output = "";
		while(temp != null) {
			if (output.length() > 0) {
				output += "; ";
			}
			output += temp.toString();
			temp = temp.nextNode;
		}
		return output;
	}

}
