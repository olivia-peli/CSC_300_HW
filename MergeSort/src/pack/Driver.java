package pack;

import java.util.Arrays;

public class Driver {

	public static void main(String[] args) {
		// using temp array
		int[] arr = {1, 4, 16, 8, 42, 33, 5, 12};
		System.out.println("orginial: " + Arrays.toString(arr));
		MergeSort(arr, 0, arr.length - 1);
		System.out.println("sorted: " + Arrays.toString(arr));
		
		//without temp array
		int[] arr2 = {1, 4, 16, 8, 42, 33, 5, 12};
		System.out.println("orginial: " + Arrays.toString(arr2));
		MergeSortNoTemp(arr2, 0, arr2.length - 1);
		System.out.println("sorted: " + Arrays.toString(arr2));
		}

	
	public static void MergeSort(int [] arr, int start, int end) {
		if(start == end) {
			return;
		}
		
		int mid = (start + end)/2;
		MergeSort(arr, start, mid);
		MergeSort(arr, mid + 1, end);
		Merging(arr, start, mid, end);
	}
	
	public static void Merging(int [] arr, int start, int mid, int end) {
		int size = end - start + 1;
		int[] mergeHolder = new int[size];
		
		int leftPos = start;
		int rightPos = mid + 1;
		
		int counter = 0;
		while (leftPos <= mid && rightPos <= end) {
			if (arr[leftPos] < arr[rightPos]) {
				mergeHolder[counter] = arr[leftPos];
				leftPos++;
			} else {
				mergeHolder[counter] = arr[rightPos];
				rightPos++;
			}
			counter++;
		}
		
		while (leftPos > mid && rightPos <= end) {
			mergeHolder[counter] = arr[rightPos];
			rightPos++;
			counter++;
		}
		
		while (leftPos <= mid && rightPos > end) {
			mergeHolder[counter] = arr[leftPos];
			leftPos++;
			counter++;
		}
		
		for(int i = 0; i < size; i++) {
			arr[start + i] = mergeHolder[i];
		}
	}
	
    public static void MergeSortNoTemp(int[] arr, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            MergeSortNoTemp(arr, low, mid);
            MergeSortNoTemp(arr, mid + 1, high);
            MergeNoTemp(arr, low, mid, high);
        }
    }

    public static void MergeNoTemp(int[] arr, int low, int mid, int high) {
        int leftSide = mid - low + 1;
        int rightSide = high - mid;

        int[] left = new int[leftSide];
        int[] right = new int[rightSide];

        for (int i = 0; i < leftSide; i++) {
            left[i] = arr[low + i];
        }
        for (int j = 0; j < rightSide; j++) {
            right[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = low;

        while (i < leftSide && j < rightSide) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < leftSide) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < rightSide) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

}
