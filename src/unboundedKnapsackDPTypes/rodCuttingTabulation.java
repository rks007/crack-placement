package unboundedKnapsackDPTypes;

public class rodCuttingTabulation {

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
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
            }
        }

        for(int i = 1; i < dp.length; i++){
            for(int l = 1; l < dp[0].length; l++){
                if(length[i - 1] <= l){
                    dp[i][l] = Math.max(price[i - 1] + dp[i][l - length[i - 1]], dp[i - 1][l]);
                } else {
                    dp[i][l] = dp[i - 1][l];
                }
            }
        }

        return dp[n][len];
    }
}
