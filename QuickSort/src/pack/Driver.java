package pack;

public class Driver {

	public static void main(String[] args) {
		

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
}