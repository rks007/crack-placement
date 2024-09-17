package dp;

public class perfectSumTabulation {
    public int perfectSum(int arr[],int n, int sum)
    {
        // Your code goes here
        int mod = 1000000007;
        int[][] dp = new int[n + 1][sum + 1];
        //initialize with the base conditionthat only return 1 when dp[o][o] is there
        //we are not setting the first row values i = 0 and j > 0 to 0 beacause they are by default 0
        dp[0][0] = 1;


        //fill the dp
        for(int i = 1; i < dp.length; i++){//it is by deafult set at the time of initialization of dp array
            for(int s = 0; s < dp[0].length; s++){
                if(arr[i - 1] <= s){
                    dp[i][s] = (dp[i - 1][s - arr[i - 1]] + dp[i - 1][s]) % mod;
                } else{
                    dp[i][s] = dp[i - 1][s] % mod;
                }

            }
        }


        return dp[n][sum];
    }
}
