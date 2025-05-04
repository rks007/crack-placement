package recursionLite;

import java.util.ArrayList;

public class letterCasePermutation { //leetcode 784
    public static void main(String[] args) {
        String str = "a1B2";
        StringBuilder input = new StringBuilder(str);
        StringBuilder output = new StringBuilder();
        ArrayList<String> ans = new ArrayList<>();
        solve(input, output, ans);
        System.out.println(ans);
    }

    private static void solve(StringBuilder input, StringBuilder output, ArrayList<String> ans) {
        if(input.isEmpty()){
            ans.add(output.toString());
            return;
        }

        if(!Character.isDigit(input.charAt(0))){
            StringBuilder op1 = new StringBuilder(output);
            StringBuilder op2 = new StringBuilder(output);
            op1.append(Character.toLowerCase(input.charAt(0)));
            op2.append(Character.toUpperCase(input.charAt(0)));
            StringBuilder newInput = new StringBuilder(input.substring(1));
            solve(newInput, op1, ans);
            solve(newInput, op2, ans);

        } else {
            output.append(input.charAt(0));
            StringBuilder newInput = new StringBuilder(input.substring(1));
            solve(newInput, output, ans);


        }

    }
}
