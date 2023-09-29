package pack;
import java.util.Random;

public class Driver {
	
	public static void main(String[] args) {
	int[] arr1 = RandomizedArray(100, 2, 800); //creating randomized array
	int[] arr2 = new int[arr1.length]; //initiating empty array to be filled with the copied array
	System.arraycopy(arr1, 0, arr2, 0, arr1.length); //copying the array
	
	long a = System.nanoTime();
	BubbleSort(arr1);
	long b = System.nanoTime();
	long c = System.nanoTime();
	SelectionSort(arr2);
	long d = System.nanoTime();
	System.out.println(b - a);
	System.out.println(d - c);
	
	}
	

	public static int[] RandomizedArray(int size, int start, int end) { //creating a random array
	    int[] array = new int[size];
	    Random rand = new Random();
	    for (int i = 0; i < size; i++) {
	        array[i] = rand.nextInt(end - start + 1) + start;
	    }
	    return array;
	}
	
	public static void SelectionSort(int[] arr) {
		for(int i = 0; i <arr.length - 1; i++) {
			int smallestIndex = i;
			for(int j = 1; j < arr.length; j++) {
				if (arr[j] < arr[i]) {
					smallestIndex = j;
				}
			}
			if(smallestIndex != i) {
				int temp = arr[i];
				arr[i] = arr[smallestIndex];
				arr[smallestIndex]= temp;
			}
		}
	}
	
	public static void InsertionSort(int[] arr) {
		for(int i = 1; i < arr.length; i++) {
			int curr = i;
			for(int j = i - 1; j >= 0; j--) {
				if(arr[curr] >= arr[j]) {
					break;
				}
				else {
					int temp = arr[j];
					arr[j] = arr[curr];
					arr[curr]= temp;
					curr = j;
				}
			}
		}
	}
	public static void BubbleSort(int[] arr) {
		for(int i = 0; i < arr.length - 1; i++) {
			for(int j = 0; j < arr.length - 2 - i; j++) {
				if(arr[j +1] < arr[j]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	
}

