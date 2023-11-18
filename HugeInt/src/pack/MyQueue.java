package pack;

public class MyQueue extends MyDoublyLinkedList implements Queue {

	@Override
	public <T> void enqueue(T data) {
		this.prepend(data);

	}

	@Override
	public <T> T dequeue() {
		MyDoubleNode result = this.Tail;
        this.removeTail();
        return result;
	}

	@Override
	public <T> T peek() {
		return this.Tail;
	}

	@Override
	public boolean isEmpty() {
		return super.isEmpty();
	}

	@Override
	public int getLength() {
		return super.getLength();
	}

}
