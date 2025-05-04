package dp;

public class subsetSumMemoization {
    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n = arr.length;
        int[][] dp = new int[n + 1][sum + 1];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                dp[i][j] = -1;
            }
        }

        return solve(n, arr, sum, dp);
    }
    private static Boolean solve(int n, int arr[], int sum, int[][] dp){
        if (sum == 0) return true;
        if (n == 0) return false;

        if (dp[n][sum] != -1) {
            return dp[n][sum] == 1;
        }

        boolean pick = false;
        if (arr[n - 1] <= sum) {
            pick = solve(n - 1, arr, sum - arr[n - 1], dp);
        }

        boolean notPick = solve(n - 1, arr, sum, dp);

        dp[n][sum] = (pick || notPick) ? 1 : 0;

        return dp[n][sum] == 1;
    }
}
