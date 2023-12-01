package pack;

public class Driver {
	public static void main(String[] args) {
		final int initialCapacity = 10;
		
		OpenAddressingHashTable table = new OpenAddressingHashTable(initialCapacity);
		table.insert(1, 15);
		table.insert(2, 23);
		table.insert(3, 1);
		table.insert(4, 14);
		table.insert(5, 68);
		table.insert(6, 57);
		table.insert(7, 12);
		table.insert(8, 29);
		table.insert(9, 6);
		table.insert(10, 89);
		table.insert(11, 90);
		table.insert(12, 36);
		table.insert(13, 32);
		table.insert(14, 40);
		table.insert(15, 78);
		table.insert(16, 99);
		table.insert(17, 82);
		table.insert(18, 22);
		table.insert(19, 19);
		table.insert(20, 71);
		
		table.toString();
		System.out.println(table);
		
		
		ChainingHashTable table2 = new ChainingHashTable(initialCapacity);
		table2.insert(1, 15);
		table2.insert(2, 23);
		table2.insert(3, 1);
		table2.insert(4, 14);
		table2.insert(5, 68);
		table2.insert(6, 57);
		table2.insert(7, 12);
		table2.insert(8, 29);
		table2.insert(9, 6);
		table2.insert(10, 89);
		table2.insert(11, 90);
		table2.insert(12, 36);
		table2.insert(13, 32);
		table2.insert(14, 40);
		table2.insert(15, 78);
		table2.insert(16, 99);
		table2.insert(17, 82);
		table2.insert(18, 22);
		table2.insert(19, 19);
		table2.insert(20, 71);
		
		table2.toString();
		System.out.println(table2);
	}
}
