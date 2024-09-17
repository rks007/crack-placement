package dp;

public class partitionEqualSubsetSum {

    static int equalPartition(int N, int arr[]) {
        // Calculate the total sum of the array elements
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
        }

        // If the total sum is odd, it cannot be partitioned into two equal subsets
        if (sum % 2 != 0) {
            return 0;
        }

        // Use the helper function to check if a subset with sum equal to half of the total sum exists
        if (helper(N, arr, sum / 2)) {
            return 1;  // Return 1 if such a subset exists
        }
        return 0;  // Return 0 if such a subset does not exist
    }

    // Helper function to check if there is a subset with a given sum
    private static boolean helper(int N, int arr[], int sum) {
        // Base cases
        // If sum is 0, we've found a subset that adds up to the required sum
        if (sum == 0) {
            return true;
        }
        // If no elements are left and sum is not 0, then no subset can be found
        if (N == 0) {
            return false;
        }

        // If the last element is less than or equal to the sum,
        // we have two choices:
        // 1. Include the last element in the subset and recursively check for the remaining sum
        // 2. Exclude the last element and recursively check for the same sum
        if (arr[N - 1] <= sum) {
            // Check if sum can be obtained by including or excluding the last element
            return helper(N - 1, arr, sum - arr[N - 1]) || helper(N - 1, arr, sum);
        }

        // If the last element is greater than the sum,
        // it cannot be included in the subset, so we exclude it
        return helper(N - 1, arr, sum);
    }

}
