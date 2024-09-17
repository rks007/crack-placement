package longestCommonDp;

public class minDeletionstoMakeStringPalindromicTabulation { //gfg practice

    /*
       same as the longest palindromic subsequence
       for better understanding just dry run
     */
    int minDeletions(String str, int n)
    {
        // code here
        StringBuilder copy = new StringBuilder(str);

        String str2 = copy.reverse().toString();
        int m = str2.length();

        int[][] dp = new int[n + 1][m + 1];
        for(int  i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
            }
        }

        for(int  i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(str.charAt(i - 1) == str2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int lengthofLCS = dp[n][m];

        return n - lengthofLCS;
    }
}
