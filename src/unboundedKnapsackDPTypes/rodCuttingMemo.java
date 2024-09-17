package unboundedKnapsackDPTypes;

public class rodCuttingMemo {
    public int cutRod(int price[], int n) {
        //code here
        //consider 1 based indexing
        int[] length = new int[n];
        for(int i = 1; i <= n; i++){
            length[i - 1] = i;
        }

        int len = length.length;

        int[][] dp = new int[n + 1][len + 1];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                dp[i][j] = -1;
            }
        }

        return helper(price, n, length, len, dp);
    }
    private static int helper(int price[], int n, int[] length, int len, int[][] dp){
        if(n == 0 || len == 0){
            return 0;
        }

        if(dp[n][len] != -1){
            return dp[n][len];
        }

        if(length[n - 1] <= len){
            return dp[n][len] = Math.max(price[n - 1] +  helper(price, n, length, len - length[n - 1], dp), helper(price, n - 1, length, len, dp));
        }

        return dp[n][len] = helper(price, n - 1, length, len, dp);
    }
}
