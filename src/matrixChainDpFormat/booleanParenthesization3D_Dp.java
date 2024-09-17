package matrixChainDpFormat;

public class booleanParenthesization3D_Dp {

    static int countWays(int n, String s){
        // code here
        int[][][] dp = new int[n + 1][n + 1][2];
        //marking all boxes as -1
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                dp[i][j][1] = -1;
                dp[i][j][0] = -1;
            }
        }

        return solve(s, 0, n - 1, true, dp);
    }
    private static int solve(String s, int i, int j, boolean isTrue, int[][][] dp){
        if(i > j){
            return 0;
        }

        if(i == j){
            if(isTrue == true){
                if(s.charAt(i) == 'T') return 1;
                return 0;
                // return s.charAt(i) == 'T';
            } else {
                if(s.charAt(i) == 'F') return 1;
                return 0;
                // return s.charAt(i) == 'F';
            }
        }

        // 1 means true and 0 means false
        int isTrueIntValue = isTrue ? 1 : 0;

        if(dp[i][j][isTrueIntValue] != -1){
            return dp[i][j][isTrueIntValue];
        }


        int ans = 0;

        for(int k = i + 1; k < j; k = k + 2){

            int leftTrue = solve(s, i, k - 1, true, dp);
            int leftFalse = solve(s, i, k - 1, false, dp);

            int rightTrue = solve(s, k + 1, j, true, dp);
            int rightFalse = solve(s, k + 1, j, false, dp);

            if(s.charAt(k) == '&'){
                if(isTrue == true){
                    ans = ans + (leftTrue * rightTrue);
                } else {
                    ans = ans + (leftTrue * rightFalse) + (leftFalse * rightTrue) + (leftFalse * rightFalse);
                }

            } else if(s.charAt(k) == '|'){
                if(isTrue == true){
                    ans = ans + (leftTrue * rightTrue) + (leftTrue * rightFalse) + (leftFalse * rightTrue);
                } else {
                    ans = ans + (leftFalse * rightFalse);
                }

            } else if(s.charAt(k) == '^'){
                if(isTrue == true){
                    ans = ans + (leftTrue * rightFalse) + (leftFalse * rightTrue);
                } else {
                    ans = ans + (leftTrue * rightTrue) + (leftFalse * rightFalse);
                }
            }

        }

        return dp[i][j][isTrueIntValue] = ans % 1003;
    }

}
