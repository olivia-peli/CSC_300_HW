package homework3;

public class Driver {

	public static void main(String[] args) {
		IsUnique("baseball");
	}
	
	static boolean IsUnique(String str) {
		for(int i = 0; i < str.length() - 1; i++) {
			for(int j = i + 1; j < str.length(); j++) {
				if(str.charAt(i) == str.charAt(i)) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

}
