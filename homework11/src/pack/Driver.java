package pack;

//I spent several hours trying to implement all of this correctly and this was the best I could come up with
public class Driver{

	public static void main(String[] args) {
		LinkedList<String> DiscipleList = new LinkedList<String>();
		//use your singly linked list to store the 12 disciple's name
		DiscipleList.Append("Peter");
		DiscipleList.Append("Andrew");
		DiscipleList.Append("James");
		DiscipleList.Append("John");
		DiscipleList.Append("Philip");
		DiscipleList.Append("Bartholomew");
		DiscipleList.Append("Thomas");
		DiscipleList.Append("Matthew");
		DiscipleList.Append("James");
		DiscipleList.Append("Thaddaeus");
		DiscipleList.Append("Simon");
		DiscipleList.Append("Judas");
		
		//and then remove the one who betrayed Jesus
		DiscipleList.Remove(<12>);
		
		//sort them in alphabetic order
		DiscipleList.mergeSort();
		
		//finally print the name reversely
		DiscipleList.printReverse(this.Head);
		
		
		

	}
}