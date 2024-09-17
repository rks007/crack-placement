package unboundedKnapsackDPTypes;

public class uKnapsackTabulation {

    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        // Write your code here.
        int[][] dp = new int[n + 1][w + 1];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
            }
        }

        for(int i = 1; i < dp.length; i++){
            for(int wt = 1; wt < dp[0].length; wt++){
                if(weight[i - 1] <= wt){
                    dp[i][wt] = Math.max(profit[i - 1] + dp[i][wt - weight[i - 1]], dp[i - 1][wt]);
                } else {
                    dp[i][wt] = dp[i - 1][wt];
                }

            }
        }

        return dp[n][w];
    }

}
