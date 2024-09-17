package longestCommonDp;

public class printShortestCommonSuperSequenceTabulation { //leetcode 1092

    /*
       for this question, you have the knowledge of print longest common subsequence and also length of shortest common subsequence
       the difference between this questions code and print lcs code is that in this we have to print the charaters which are not similar also
       you can check this logic in the first big while loop, you can spot the differnce btw the print lcs and this code
     */

    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n + 1][m + 1];
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

        StringBuilder ans = new StringBuilder();

        int i = n;
        int j = m;
        while(i > 0 && j > 0){
            if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                ans.append(str1.charAt(i - 1));
                i--;
                j--;
            } else {
                if(dp[i - 1][j] > dp[i][j - 1]){
                    ans.append(str1.charAt(i - 1));
                    i--;
                } else{
                    ans.append(str2.charAt(j - 1));
                    j--;
                }
            }
        }

        //at last this two while loop because we exit the while big while loop if any string becomes empty, then add all elements of the other strings because we need them also
        while(i > 0){
            ans.append(str1.charAt(i - 1));
            i--;
        }
        while(j > 0){
            ans.append(str2.charAt(j - 1));
            j--;
        }

        return ans.reverse().toString();
    }

}
