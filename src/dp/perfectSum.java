package dp;

//it is the same problem like count the number of subset which sums are equal to the given sum
//the only differnce is that in this we are also handling 0 in the array, so the base case has some slight changes
public class perfectSum {

    public int perfectSum(int arr[],int n, int sum)
    {
        // Your code goes here
        int[][] dp = new int[n + 1][sum + 1];

        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                dp[i][j] = -1;
            }
        }

        return count(arr, n, sum, dp);
    }

    private static int count(int[] arr, int n, int sum, int[][] dp){
        int mod = 1000000007;

        if(n == 0 && sum == 0){
            return 1;
        }
        if(n == 0 && sum > 0){
            return 0;
        }

        //dp checking
        if(dp[n][sum] != -1){
            return dp[n][sum];
        }


        int pick = 0;
        if(arr[n - 1] <= sum){
            pick = count(arr, n - 1, sum - arr[n - 1], dp) % mod;
        }

        int notPick = count(arr, n - 1, sum, dp) % mod;


        return dp[n][sum] = (pick + notPick) % mod;
    }

}
