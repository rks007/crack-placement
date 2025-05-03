package recursionLite;

import java.util.ArrayList;

public class permuteStringbyChangingCase {
    public static void main(String[] args) {
        String str = "ab";
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

        StringBuilder op1 = new StringBuilder(output);
        StringBuilder op2 = new StringBuilder(output);
        op1.append(input.charAt(0));
        op2.append(Character.toUpperCase(input.charAt(0)));

        StringBuilder newInput = new StringBuilder(input.substring(1));

        solve(newInput, op1, ans);
        solve(newInput, op2, ans);
    }
}
