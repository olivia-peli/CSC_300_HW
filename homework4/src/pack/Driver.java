package pack;

public class Driver {
	public static void main(String[] args) {
		int[][] matrix = new int [4][3];
		int c = 0;
		for(int y = 0; y < matrix[0].length; y++) {
				for(int x = 0; x < matrix.length; x++) {
					c = y *4 +x;
					matrix[y][x] = c;
				}
		}
		int[] result1 = BinaryMatrixSearch(matrix, 5);
		
		
	}

	static int width = 4;
	static int height = 3;
	public static int [] BinaryMatrixSearch(int[][] arr, int value) {
		int low =  0;
		int high = width * height - 1;
		int mid;
		int x = 0;
		int y;
		while(low <= high) {
			mid = (low + high) / 2;
			y = mid / width;
			if(arr[x][y] == value) {
				return new int [] {x, y};
				}
			else if(arr[x][y] < value) {
				low = mid + 1;
				}
			else {
				high = mid - 1;
				}
		}
		return null;
	}
}
