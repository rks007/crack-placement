package unboundedKnapsackDPTypes;

public class UknapsackMemo {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        // Write your code here.
        int[][] dp = new int[n + 1][w + 1];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                dp[i][j] = -1;
            }
        }

        return helper(n, w, profit, weight, dp);
    }
    private static int helper(int n, int w, int[] profit, int[] weight, int[][] dp){
        if(n == 0 || w == 0){
            return 0;
        }

        if(dp[n][w] != -1){
            return dp[n][w];
        }

        if(weight[n - 1] <= w){
            return dp[n][w] = Math.max(profit[n - 1] + helper(n, w - weight[n - 1], profit, weight, dp), helper(n - 1, w, profit, weight, dp));
        }

        return dp[n][w] = helper(n - 1, w, profit, weight, dp);
    }
}
