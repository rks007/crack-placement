package longestCommonDp;

public class longestCommonSubstringTabulation { //just a slight change from the longest common subsequebce

    public int longestCommonSubstr(String str1, String str2) {
        // code here
        int n = str1.length();
        int m = str2.length();
        int maxLength = 0;

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    //make changes in your maxlen
                    maxLength = Math.max(maxLength, dp[i][j]);
                } else {
                    //here we just make it zero because if we not get the equal, values consequetively then make it 0 and start searching again because we want substring not the subsequence
                    dp[i][j] = 0;
                }
            }
        }

        return maxLength;
    }
}
