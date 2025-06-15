package slidingWindow;

public class maxSubarraySumofSizeK {
    class Solution {
        public int maximumSumSubarray(int[] arr, int k) {
            // Initialize two pointers for the sliding window
            int i = 0; // Start of the window
            int j = 0; // End of the window

            int sum = 0;     // To store the current sum of the window
            int maxSum = 0;  // To store the maximum sum found so far

            // Traverse the array using the end pointer
            while (j < arr.length) {
                // Add the current element to the window sum
                sum += arr[j];

                // If the current window size is less than k, just move the end pointer
                if (j - i + 1 < k) {
                    j++;
                }
                // If the window size reaches k
                else if (j - i + 1 == k) {
                    // Update maxSum if current window sum is greater
                    maxSum = Math.max(maxSum, sum);

                    // Slide the window forward:
                    // 1. Subtract the element at the start of the window
                    // 2. Move the start pointer forward
                    // 3. Move the end pointer forward
                    sum -= arr[i];
                    i++;
                    j++;
                }
            }

            // Return the maximum sum of any subarray of size k
            return maxSum;
        }
    }

}
