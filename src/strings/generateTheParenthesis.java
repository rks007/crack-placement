package strings;

import java.util.ArrayList;
import java.util.List;

public class generateTheParenthesis { //leetcode 22
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        helper("", 0, 0, n, ans);

        return ans;

    }
    private static void helper(String str, int open, int close, int n, List<String> ans){
        //base case
        if(open == n && close == n){
            ans.add(str);
            return;
        }

        //open brackets
        if(open < n){
            helper(str + '(', open + 1, close, n, ans);
        }

        //close brackets
        if(close < open){
            helper(str + ')', open, close + 1, n, ans);
        }
    }
}
