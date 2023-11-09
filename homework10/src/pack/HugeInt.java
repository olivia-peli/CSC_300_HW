package pack;

import java.util.LinkedList;

import java.lang.Math; 

public class HugeInt {
    private LinkedList<Integer> digits;
    public int sign;

    public HugeInt() {
        digits = new LinkedList<>();
        sign = 1; // Default is a positive number
    }

   

    public static HugeInt Addition(HugeInt a, HugeInt b) {
        // Check for the sign of both numbers
        if (a.sign == 0 && b.sign == 1) {
            // If the first number is negative and the second is positive, subtract the absolute values
            HugeInt negResult = b.abs().minus(a.abs());
            negResult.sign = 0; // Set the sign to negative
            return negResult;
        } 
        else if (b.sign == 1 && a.sign == 0) {
            // If the first number is positive and the second is negative, subtract the absolute values
        	// not sure why my abs function is not working
            return a.abs().minus(b.abs());
        }

        LinkedList<Integer> result = new LinkedList<>();
        int carry = 0;

        // Get the linked lists for the two numbers
        LinkedList<Integer> num1List = a.digits;
        LinkedList<Integer> num2List = b.digits;

        // Perform addition digit by digit
        while (!num1List.isEmpty() || !num2List.isEmpty() || carry > 0) {
            int digit1 = num1List.isEmpty() ? 0 : num1List.removeFirst();
            int digit2 = num2List.isEmpty() ? 0 : num2List.removeFirst();

            int sum = digit1 + digit2 + carry;
            carry = sum / 10;
            result.add(sum % 10);
        }

        // Create a new HugeInt for the result
        HugeInt sumResult = new HugeInt();
        sumResult.digits = result;
        sumResult.sign = a.sign; // The sign of the result is the same as the input numbers

        return sumResult;
    }
   
    public static HugeInt Multiply(HugeInt a, HugeInt b) {    
    	// Check for the sign of both numbers
        int resultSign = (a.sign == b.sign) ? 1 : 0;

        LinkedList<Integer> result = new LinkedList<>();
        LinkedList<Integer> num1List = a.digits;
        LinkedList<Integer> num2List = b.digits;

        int len1 = num1List.size();
        int len2 = num2List.size();

        int[] product = new int[len1 + len2];

        // Perform long multiplication
        for (int i = 0; i < len1; i++) {
            int carry = 0;
            int digit1 = num1List.get(i);

            for (int j = 0; j < len2; j++) {
                int digit2 = num2List.get(j);
                int temp = digit1 * digit2 + product[i + j] + carry;

                carry = temp / 10;
                product[i + j] = temp % 10;
            }

            if (carry > 0) {
                product[i + len2] += carry;
            }
        }

        // Convert the product array to a linked list
        for (int i = 0; i < product.length; i++) {
            result.add(product[i]);
        }

        // Remove leading zeros in the result
        while (!result.isEmpty() && result.getLast() == 0) {
            result.removeLast();
        }

        // Create a new HugeInt for the result
        HugeInt multiplyResult = new HugeInt();
        multiplyResult.digits = result;
        multiplyResult.sign = resultSign;

        return multiplyResult;
    	    }
    
    public int compareTo(HugeInt a, HugeInt b) {
        // Compare the signs of both numbers
        if (a.sign < b.sign) {
            return -1; // This number is negative, other is positive
        } 
        else if (a.sign > b.sign) {
            return 1; // This number is positive, other is negative
        }

        LinkedList<Integer> num1List = a.digits;
        LinkedList<Integer> num2List = b.digits;

        // Compare the magnitudes
        if (num1List.size() < num2List.size()) {
            return -1; // This number has fewer digits
        } 
        else if (num1List.size() > num2List.size()) {
            return 1; // This number has more digits
        }

        // The numbers have the same sign and the same number of digits; compare digit by digit
        for (int i = 0; i < num1List.size(); i++) {
            int digit1 = num1List.get(i);
            int digit2 = num2List.get(i);
            if (digit1 < digit2) {
                return -1; // This number is smaller
            } 
            else if (digit1 > digit2) {
                return 1; // This number is greater
            }
        }

        return 0; // The numbers are equal
   }
    	        

    public static HugeInt mergeSort(HugeInt list) {
        if (list == null || list.digits.size() <= 1) {
            return list; // Already sorted
        }

        LinkedList<Integer> leftHalf = new LinkedList<>();
        LinkedList<Integer> rightHalf = new LinkedList<>();

        // Split the linked list into two halves
        int middle = list.digits.size() / 2;
        for (int i = 0; i < middle; i++) {
            leftHalf.add(list.digits.get(i));
        }
        for (int i = middle; i < list.digits.size(); i++) {
            rightHalf.add(list.digits.get(i));
        }

        HugeInt left = new HugeInt();
        left.digits = leftHalf;
        HugeInt right = new HugeInt();
        right.digits = rightHalf;

        // Recursively sort both halves
        left = mergeSort(left);
        right = mergeSort(right);

        // Merge the sorted halves
        return merge(left, right);
    }

    private static HugeInt merge(HugeInt left, HugeInt right) {
        LinkedList<Integer> result = new LinkedList<>();
        LinkedList<Integer> leftList = left.digits;
        LinkedList<Integer> rightList = right.digits;

        while (!leftList.isEmpty() && !rightList.isEmpty()) {
            if (leftList.getFirst() < rightList.getFirst()) {
                result.add(leftList.removeFirst());
            } 
            else {
                result.add(rightList.removeFirst());
            }
        }

        result.addAll(leftList);
        result.addAll(rightList);

        HugeInt merged = new HugeInt();
        merged.digits = result;
        return merged;
    }

}
