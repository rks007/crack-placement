package dp;

public class knapSackTabulation {

    static int knapSack(int W, int wt[], int val[], int n)
    {
        // your code here
        int[][] dp = new int[n + 1][W + 1];

        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
            }
        }


        for(int i = 1; i < dp.length; i++){  //i denotes n
            for(int w = 1; w < dp[0].length; w++){ // w denotes W i.e weight of knapsack
                int pick = 0;
                if(wt[i - 1] <= w){
                    pick = val[i -1] + dp[i - 1][w - wt[i - 1]];
                }

                int notPick = dp[i - 1][w];

                dp[i][w] = Math.max(pick, notPick);
            }
        }

        return dp[n][W];

    }

}
