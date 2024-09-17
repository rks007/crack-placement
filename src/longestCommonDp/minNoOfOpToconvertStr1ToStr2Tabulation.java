package longestCommonDp;

public class minNoOfOpToconvertStr1ToStr2Tabulation { //gfg

    public int minOperations(String str1, String str2)
    {
        // Your code goes here
        int m = str1.length();
        int n = str2.length();

        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
            }
        }

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int lengthOfLCS = dp[m][n];

        int numberOfDeleteOperations = m - lengthOfLCS;
        int numberOfInsertOperations = n - lengthOfLCS;

        return numberOfDeleteOperations + numberOfInsertOperations;
    }

}
