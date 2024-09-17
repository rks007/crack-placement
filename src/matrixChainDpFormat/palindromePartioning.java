package matrixChainDpFormat;

public class palindromePartioning {
    public static int palindromePartitioning(String str) {
        // Write your code here
        int n = str.length();

        int[][] dp = new int[n + 1][n + 1];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                dp[i][j] = -1;
            }
        }

        return solve(str, 0, str.length() - 1, dp);
    }
    private static int solve(String str, int i, int j, int[][] dp){
        if(i >= j){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(isPalindrome(str, i, j) == true){
            return 0;
        }


        int minAns = Integer.MAX_VALUE;
        for(int k = i; k < j; k++){

            int tempAns = solve(str, i, k, dp) + solve(str, k + 1, j, dp) + 1;

            minAns = Math.min(minAns, tempAns);
        }

        return dp[i][j] = minAns;
    }

    private static boolean isPalindrome(String str, int i , int j){
        while( i < j){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }
}
