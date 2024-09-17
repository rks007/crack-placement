package longestCommonDp;

public class printlcsTabulation {
    public static String findLCS(int n, int m, String s1, String s2){
        StringBuilder ans = new StringBuilder();

        int[][] dp = new int[n + 1][m + 1];

        // Initialize the dp array to handle the base case where one string is of length 0
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= m; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
            }
        }

        // Fill the dp table with the LCS lengths
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Backtrack to find the LCS string
        int i = n, j = m;

        while (i > 0 && j > 0) {
            if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                ans.append(s1.charAt(i - 1)); // Add the matching character to the LCS string
                i--;
                j--;
            } else {
                if(dp[i - 1][j] > dp[i][j - 1]){
                    i--; // Move up in the dp table
                } else {
                    j--; // Move left in the dp table
                }
            }
        }

        return ans.reverse().toString(); // Reverse the result since we added characters from the end to the start
    }
}
