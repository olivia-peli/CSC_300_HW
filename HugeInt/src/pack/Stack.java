package pack;

public class Stack extends MyDoublyLinkedList<Integer> implements iStack {
	private MyDoublyLinkedList doubleLinkedList;
	
	//I did my best and worked several hours on trying to get the right idea
	
	Stack(){
		doubleLinkedList = new MyDoublyLinkedList();
	}

	@Override
	public <T> void push(T data) {
		MyDoubleNode newNode = new MyDoubleNode(Data);
		doubleLinkedList.Prepend(newNode);
		}

	@Override
	public <T> T pop() {
		int poppedItem = doubleLinkedList.getHeadData;
		doubleLinkedList.RemoveAfter(null);
		return poppedItem;
		
	}

	@Override
	public <T> T peek() {
		return this.Head;
	}

	@Override
	public boolean isEmpty() {
		if(this.Head = null) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public int getLength() {
		return this.getlength();
	}

}
