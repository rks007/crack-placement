package longestCommonDp;

public class shortestCommonSuperSequenceTabulation { //gfg practice
    public static int shortestCommonSupersequence(String X,String Y,int m,int n) {

        //this question is same as longest common subsequence in this you just have to calculate the length of the lcs and minus it from the addition of the both strings length

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
                if(X.charAt(i - 1) == Y.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int lengthOfLCS = dp[m][n];
        return (m + n) - lengthOfLCS;
    }
}
