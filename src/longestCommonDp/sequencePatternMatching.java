package longestCommonDp;

public class sequencePatternMatching {
    public static void main(String[] args) {
        String s = "axy";
        String t = "adxcpy";

        System.out.println(isMatch(s, t));
    }
    private static boolean isMatch(String s, String t){ //leetcode 392
        int n = s.length();
        int m = t.length();

        int i = 0;//for t
        int j = 0;//for s

        while(i < m && j < n){
            if(t.charAt(i) == s.charAt(j)){
                j++;
            }
            i++;
        }

        return j == n; //dry run for better understanding
    }
}
