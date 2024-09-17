package longestCommonDp;

public class longestCommonSubsequence {


        public static int getLengthOfLCS(String str1, String str2) {
            // Get the lengths of the input strings
            int n = str1.length();
            int m = str2.length();

            // Create a 2D array (dp) to store the length of LCS for different lengths of substrings
            int[][] dp = new int[n + 1][m + 1];

            // Initialize the dp array with -1, indicating that the subproblems haven't been solved yet
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[0].length; j++) {
                    dp[i][j] = -1;
                }
            }

            // Start solving the problem using the helper function and return the final result
            return helper(str1, str2, n, m, dp);
        }

        private static int helper(String str1, String str2, int n, int m, int[][] dp) {
            // Base case: If either string is empty, the LCS length is 0
            if (n == 0 || m == 0) {
                return 0;
            }

            // If the LCS for this subproblem has already been computed, return the cached result
            if (dp[n][m] != -1) {
                return dp[n][m];
            }

            // If the last characters of both strings are the same
            if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
                // Include this character in the LCS and recursively calculate the LCS for the remaining parts
                return dp[n][m] = 1 + helper(str1, str2, n - 1, m - 1, dp);
            } else {
                // If the last characters are different, find the maximum LCS by either:
                // 1. Excluding the last character of str1
                // 2. Excluding the last character of str2
                // Store and return the maximum of these two cases
                return dp[n][m] = Math.max(helper(str1, str2, n - 1, m, dp), helper(str1, str2, n, m - 1, dp));
            }
        }


}
