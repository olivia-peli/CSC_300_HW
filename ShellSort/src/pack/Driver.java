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

	public static void ShellSort(int[] arr){
        //interval 2^n -1 , 2^(n-1) - 1, 2^(n-2) -1, ..., 2, 1
        int length = arr.length;
        int n = (int)Math.floor(Math.log(length + 1));
        for(int i = n; i > 0; i--){
            int interval = (int)Math.pow(2, i) - 1;
            for(int start = 0; start < interval; start++){
                ShellSortPartition(arr, start, interval);
            }
        }
    }
}
