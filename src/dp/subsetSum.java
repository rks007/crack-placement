package dp;

public class subsetSum {
    static Boolean isSubsetSum(int N, int arr[], int sum) {
        // Base cases
        // If the sum is 0, we've found a subset that adds up to the required sum
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
            return isSubsetSum(N - 1, arr, sum - arr[N - 1]) || isSubsetSum(N - 1, arr, sum);
        }

        // If the last element is greater than the sum,
        // it cannot be included in the subset, so we exclude it
        return isSubsetSum(N - 1, arr, sum);
    }
}
