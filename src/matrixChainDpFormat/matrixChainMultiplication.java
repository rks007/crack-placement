package matrixChainDpFormat;

public class matrixChainMultiplication {

    public static int matrixMultiplication(int[] arr , int N) {
        // Write your code here
        int[][] dp = new int[N + 1][N + 1];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                dp[i][j] = -1;
            }
        }

        return solve(arr, 1, N - 1, dp);
    }
    private static int solve(int[] arr, int i, int j, int[][] dp){
        if(i >= j){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];

        }

        int minAns = Integer.MAX_VALUE;

        for(int k = i; k < j; k++){
            int tempAns = solve(arr, i, k, dp) + solve(arr, k + 1, j, dp) + (arr[i - 1] * arr[k] * arr[j]);

            if(tempAns < minAns){
                minAns = tempAns;
            }

        }

        return dp[i][j] = minAns;
    }
    
}
