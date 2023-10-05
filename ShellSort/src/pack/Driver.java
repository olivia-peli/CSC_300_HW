package pack;

public class Driver {
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

}
