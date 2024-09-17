package arrays;

import java.util.HashMap;

public class subArraySumEqualsK { //count the number of subArray which sum is = k //leetcode 560
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, -3, 1, 1, 1, 4, 2, -3};
        int k = 3;

        int ans = countSubArray(nums, k);
        System.out.println(ans);
    }

    private static int countSubArray(int[] nums, int k) {
        // HashMap to store prefix sum and its frequency
        HashMap<Integer, Integer> mp = new HashMap<>();
        int prefixSum = 0; // To track the cumulative sum up to the current index
        int count = 0; // To count the number of subarrays with sum k
        mp.put(0, 1); // Base case to handle subarrays starting from the beginning

        // Iterate through the array to calculate prefix sums
        for (int i = 0; i < nums.length; i++) {
            // Update the prefix sum with the current element
            prefixSum += nums[i];
            // Calculate the required sum to find in the map
            int required = prefixSum - k;

            // If the required sum exists in the map, add its frequency to the count
            if (mp.containsKey(required)) {
                count += mp.get(required);
            }

            // Update the map with the current prefix sum
            // If prefixSum already exists in the map, increment its frequency by 1
            // Otherwise, add prefixSum to the map with a frequency of 1
            if(!mp.containsKey(prefixSum)){
                mp.put(prefixSum, 1);
            } else {
                mp.put(prefixSum, mp.get(prefixSum) + 1);
            }
        }

        return count;
    }
}
