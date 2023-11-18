package pack;

public interface iStack {
	//push
	public <T> void push(T data);
	//pop
	public <T> T pop();
	//peek
	public <T> T peek();
	//isempty
	public boolean isEmpty();
	//getlength
	public int getLength();
}
