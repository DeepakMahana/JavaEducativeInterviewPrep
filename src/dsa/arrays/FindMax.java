package dsa.arrays;



// Find the Sum of Maximum Sum Subarray (Kadane Algo)

/**
 * 
 The basic idea of Kadane’s algorithm is to scan the entire array and at each position find the maximum sum of the subarray ending there. 
 This is achieved by keeping a currMax for the current array index and a globalMax. The algorithm is as follows:

currMax = A[0]
globalMax = A[0]
for i = 1 -> size of A
    if currMax is less than 0
        then currMax = A[i]
    otherwise 
        currMax = currMax + A[i]
    if globalMax is less than currMax 
        then globalMax = currMax


The runtime complexity of this solution is linear O(n)
The space complexity of this solution is constant O(1)

*/

import java.util.Arrays;

class FindMax {
    public static int findMaxSumSubArray(int[] arr) {
        if (arr.length < 1) {
            return 0;
        }

        int currMax = arr[0];
        int globalMax = arr[0];
        int lengtharray = arr.length;
        for (int i = 1; i < lengtharray; i++) {
            if (currMax < 0) {
            currMax = arr[i];
            } else {
            currMax += arr[i];
            }

            if (globalMax < currMax) {
            globalMax = currMax;
            }
        }
        return globalMax;
    }
    public static void main( String args[] ) {
        int[] arr1 = {1, 7, -2, -5, 10, -1};
        System.out.println("Array: "+ Arrays.toString(arr1));
        System.out.println("Sum: " + findMaxSumSubArray(arr1));
    }
}