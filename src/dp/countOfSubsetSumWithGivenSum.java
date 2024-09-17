package dp;

public class countOfSubsetSumWithGivenSum { //gfg pe perfect sum problem

    public int perfectSum(int arr[],int n, int sum) //with memoization
    {
        // Your code goes here
        int[][] dp = new int[n + 1][sum + 1];

        for(int i = 0; i < dp.length;i++){
            for(int j = 0; j < dp[0].length; j++){
                dp[i][j] = -1;
            }
        }

        int count = helper(arr, n, sum, dp);

        return count;
    }

    private static int helper(int arr[],int n, int sum, int[][] dp){
        if(sum == 0){
            return 1;
        }

        if(n == 0){
            return 0;
        }

        if(dp[n][sum] != -1){
            return dp[n][sum];
        }


        int pick = 0;
        int notPick = 0;

        if(arr[n - 1] <= sum){
            pick = helper(arr, n - 1, sum - arr[n - 1], dp);
        }

        notPick = helper(arr, n - 1, sum, dp);

        return dp[n][sum] = pick + notPick;
    }

}
