package dp;

public class partitionEqualSubsetSumMemoization {
    static boolean equalPartition(int arr[]) {
        int n = arr.length;
        int sum = 0;

        // Step 1: Calculate total sum of all elements
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        // Step 2: If total sum is odd, we cannot split it into two equal subsets
        if (sum % 2 != 0) {
            return false;
        }

        // Step 3: The target sum for each subset should be half of total sum
        int targetSum = sum / 2;

        // Step 4: Create a DP table for memoization
        // dp[i][j] means: can we form sum 'j' using first 'i' elements
        int[][] dp = new int[n + 1][targetSum + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1; // -1 indicates that the subproblem is not solved yet
            }
        }

        // Step 5: Solve the problem using recursion + memoization
        return solve(n, arr, targetSum, dp);
    }

    // Recursive helper function to check if we can get the 'sum' using 'n' elements
    private static boolean solve(int n, int[] arr, int sum, int[][] dp) {
        // Base Case 1: If required sum becomes 0, return true (empty subset is possible)
        if (sum == 0) {
            return true;
        }

        // Base Case 2: If no elements left but sum > 0, return false
        if (n == 0) {
            return false;
        }

        // Step 6: If subproblem already solved, return stored result
        if (dp[n][sum] != -1) {
            return dp[n][sum] == 1;
        }

        // Step 7: Decision to include current element if it's not greater than remaining sum
        boolean pick = false;
        if (arr[n - 1] <= sum) {
            pick = solve(n - 1, arr, sum - arr[n - 1], dp); // pick current element
        }

        // Step 8: Decision to exclude current element
        boolean notpick = solve(n - 1, arr, sum, dp); // don't pick current element

        // Step 9: Store the result in dp table and return it
        dp[n][sum] = (pick || notpick) ? 1 : 0;

        return dp[n][sum] == 1;
    }
}
