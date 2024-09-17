package dp;

public class minimumSubsetSumDiffTabulation {
    public int minDifference(int arr[], int n)
    {
        // Your code goes here
        int range = 0;
        for(int i = 0; i < arr.length; i++){
            range += arr[i];
        }

        boolean[][] dp = new boolean[n + 1][range + 1];

        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(i == 0){
                    dp[i][j] = false;
                }
                if(j == 0){
                    dp[i][j] = true;
                }
            }
        }


        for(int i = 1; i < dp.length; i++){
            for(int s = 1; s < dp[0].length; s++){
                if(arr[i - 1] <= s){
                    dp[i][s] =  dp[i - 1][s - arr[i - 1]] || dp[i - 1][s];
                } else {
                    dp[i][s] = dp[i - 1][s];
                }
            }
        }


        int s1 = 0;
        for(int j = 0; j <= range/2; j++){
            if(dp[n][j]){
                s1 = j;
            }
        }


        return range - (2 * s1);

    }
}
