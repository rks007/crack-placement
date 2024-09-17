package matrixChainDpFormat;

public class booleanParenthesization {
    static int countWays(int n, String s){
        // code here

        return solve(s, 0, n - 1, true);
    }
    private static int solve(String s, int i, int j, boolean isTrue){
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


        int ans = 0;

        for(int k = i + 1; k < j; k = k + 2){

            int leftTrue = solve(s, i, k - 1, true);
            int leftFalse = solve(s, i, k - 1, false);

            int rightTrue = solve(s, k + 1, j, true);
            int rightFalse = solve(s, k + 1, j, false);

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

        return ans;
    }
}
