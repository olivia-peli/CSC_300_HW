package pack;

public abstract class HashTable {
	   protected int hash(Object key) {
	      long keyHash = key.hashCode();

	      if (keyHash < 0) {
	         keyHash += 2147483648L;
	      }
	      
	      return (int)keyHash;
	   }

	   public abstract boolean insert(Object key, Object value);

	   public abstract boolean remove(Object key);

	   public abstract Object search(Object key);
}
