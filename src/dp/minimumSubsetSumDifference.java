package dp;

public class minimumSubsetSumDifference { //gfg minimum sum partition
    public int minDifference(int arr[], int n) {
        // Calculate the total sum of the array
        int range = 0;
        for (int i = 0; i < arr.length; i++) {
            range += arr[i];
        }

        // Initialize the maximum sum of one subset (s1) to 0
        int s1 = 0;

        // Loop to find the largest sum s1 that can be formed which is <= range/2
        for (int i = 0; i <= range / 2; i++) {
            if (subsetSumExist(arr, n, i)) {
                s1 = i;
            }
        }

        // The minimum difference between the two subsets is calculated
        return range - (2 * s1); // range - s1 - s1 == range - (2 * s1),  here s2 is range - s1
    }

    // Recursive function to check if a subset with a given sum exists
    private static boolean subsetSumExist(int[] arr, int n, int sum) {
        // Base case: If sum is 0, a subset exists (empty subset)
        if (sum == 0) {
            return true;
        }

        // Base case: If no elements left and sum is not 0, no subset exists
        if (n == 0) {
            return false;
        }

        // If the last element is less than or equal to sum, we have two options:
        // 1. Include the last element in the subset and check for the remaining sum
        // 2. Exclude the last element from the subset and check for the sum
        if (arr[n - 1] <= sum) {
            return subsetSumExist(arr, n - 1, sum - arr[n - 1]) || subsetSumExist(arr, n - 1, sum);
        }

        // If the last element is greater than sum, it cannot be included in the subset
        return subsetSumExist(arr, n - 1, sum);
    }
}
