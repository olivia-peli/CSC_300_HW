package pack;

public interface Queue {
	public <T> void enqueue(T data);
	//pop
	public <T> T dequeue();
	//peek
	public <T> T peek();
	//isempty
	public boolean isEmpty();
	//getlength
	public int getLength();

}
