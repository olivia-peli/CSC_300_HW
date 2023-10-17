package pack;

import java.util.Random;

public class Driver {

	
	public static void main(String[] args) {
		//first set of arrays
		int[] arr1 = RandomizedArray(10000, 0, 20000); //creating randomized array
		int[] arr2 = new int[arr1.length]; //initiating empty array to be filled with the copied array
		System.arraycopy(arr1, 0, arr2, 0, arr1.length); //copying the array
		
		//second set of arrays
		int[] arr3 = RandomizedArray(10000, 0, 20000); //creating randomized array
		int[] arr4 = new int[arr3.length]; //initiating empty array to be filled with the copied array
		System.arraycopy(arr3, 0, arr4, 0, arr3.length); //copying the array
		
		//third set of arrays
		int[] arr5 = RandomizedArray(10000, 0, 20000); //creating randomized array
		int[] arr6 = new int[arr5.length]; //initiating empty array to be filled with the copied array
		System.arraycopy(arr5, 0, arr6, 0, arr5.length); //copying the array
		
		//first comparison
		long a = System.nanoTime();
		QuickSort(arr1, 0, 9999);
		long b = System.nanoTime();
		long c = System.nanoTime();
		ShellSort(arr2);
		long d = System.nanoTime();
		System.out.println("quick sort time:" + (b - a));
		System.out.println("selection sort time:" + (d - c));
		
		//second comparison
		long e = System.nanoTime();
		QuickSort(arr3, 0, 9999);
		long f = System.nanoTime();
		long g = System.nanoTime();
		ShellSort(arr4);
		long h = System.nanoTime();
		System.out.println("quick sort time:" + (f - e));
		System.out.println("selection sort time:" + (h - g));
		
		//third comparison
		long i = System.nanoTime();
		QuickSort(arr5, 0, 9999);
		long j = System.nanoTime();
		long k = System.nanoTime();
		ShellSort(arr6);
		long l = System.nanoTime();
		System.out.println("quick sort time:" + (j - i));
		System.out.println("selection sort time:" + (l - k));
		

	}
	public static int Partition(int[] arr, int lowIndex, int highIndex){
		int low = lowIndex;
		int high = highIndex;
		
		int pivot = arr[(low + high)/2];
		
		boolean done = false;
		while(!done) {
			while(arr[low] < pivot && low <= highIndex) {
				low = low + 1;
			}
			
			while(arr[high] >= pivot && high >= lowIndex) {
				high = high - 1;
			}
			if(high >= low) {
				int temp = arr[low];
				arr[low] = arr[high];
				arr[high] = temp;
			}
			
			else {
				done = true;
			}
		}
	return high;
	}
	
	public static void QuickSort(int[] arr, int low, int high) {
		if (low >= high) {
			return;
		} 
		else {
			int mid = Partition(arr, low, high);
			QuickSort(arr, low, mid);
			QuickSort(arr, mid + 1, high);
		}
	}
	
	public static void ShellSortPartition(int[] arr, int startIndex, int interval) {
		for(int i = startIndex; i < arr.length; i = i + interval) {
			int pos = i;
			while(pos - interval >= startIndex && arr[pos - interval] > arr[pos]) {
				int temp = arr[pos];
				arr[pos] = arr[pos - interval];
				arr[pos - interval] = temp;
				pos = pos - interval;
			}
		}
	}
	
	public static void ShellSort(int[] arr){
        int length = arr.length;
        int n = (int)Math.floor(Math.log(length + 1));
        for(int i = n; i > 0; i--){
            int interval = (int)Math.pow(2, i) - 1;
            for(int start = 0; start < interval; start++){
                ShellSortPartition(arr, start, interval);
            }
        }
    }
	
	public static int[] RandomizedArray(int size, int start, int end) { //creating a random array
	    int[] array = new int[size];
	    Random rand = new Random();
	    for (int i = 0; i < size; i++) {
	        array[i] = rand.nextInt(end - start + 1) + start;
	    }
	    return array;
	}

}
