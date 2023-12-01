package pack;

public class ChainingHashTable extends HashTable{
	private ChainingHashTableItem[] table;

	   public ChainingHashTable(int initialCapacity) {
	      table = new ChainingHashTableItem[initialCapacity];
	   }
	   
	   public ChainingHashTable() {
	      this(11);
	   }

	   @Override
	   public boolean insert(Object key, Object value) {
	      int bucketIndex = hash(key) % table.length;
	      ChainingHashTableItem item = table[bucketIndex];
	      ChainingHashTableItem previous = null;
	      while (item != null) {
	         if (key.equals(item.key)) {
	            item.value = value;
	            return true;
	         }
	         
	         previous = item;
	         item = item.next;
	      }
	      if (table[bucketIndex] == null) {
	         table[bucketIndex] = new ChainingHashTableItem(key, value);
	      }
	      else {
	         previous.next = new ChainingHashTableItem(key, value);
	      }
	      return true;
	   }

	   @Override   
	   public boolean remove(Object key) {
	      int bucketIndex = hash(key) % table.length;

	      ChainingHashTableItem item = table[bucketIndex];
	      ChainingHashTableItem previous = null;
	      while (item != null) {
	         if (key.equals(item.key)) {
	            if (previous == null) {
	               table[bucketIndex] = item.next;
	            }
	            else {
	               previous.next = item.next;
	            }
	            return true;
	         }
	         
	         previous = item;
	         item = item.next;
	      }
	      
	      return false; 
	   }

	   @Override
	   public Object search(Object key) {
	      int bucketIndex = hash(key) % table.length;

	      ChainingHashTableItem item = table[bucketIndex];
	      while (item != null) {
	         if (key.equals(item.key)) {
	            return item.value;
	         }
	         item = item.next;
	      }
	      
	      return null; 
	   }
	   
	   @Override
	   public String toString() {
	      String result = "";
	      for (int i = 0; i < table.length; i++) {
	         result += (i + ": ");
	         
	         if (table[i] == null) {
	            result += "(empty)\n";
	         }
	         else {
	            ChainingHashTableItem item = table[i];
	            while (item != null) {
	               result += String.format("%s, %s --> ", item.key.toString(), 
	                  item.value.toString());
	               item = item.next;
	            }
	            result += "\n";
	         }
	      }
	      return result;
	   }
}
