package recursionLite;

import java.util.ArrayList;
import java.util.TreeSet;

public class printUniqueSubsets {
    public static void main(String[] args) {
        String str = "aab";
        StringBuilder input = new StringBuilder(str);
        StringBuilder output = new StringBuilder("");
        ArrayList<String> ans = new ArrayList<>();
        solve(input, output, ans);
        TreeSet<String> unique = new TreeSet<>();
        for(int i = 0; i < ans.size(); i++ ){
            unique.add(ans.get(i));
        }
        System.out.println(unique);
    }
    public static void solve(StringBuilder input, StringBuilder output, ArrayList<String> ans){
        if(input.isEmpty()){
            ans.add(output.toString());
            return;
        }
        // create two outputs: one including the char, one excluding it
        StringBuilder output1 = new StringBuilder(output); // exclude
        StringBuilder output2 = new StringBuilder(output);
        output2.append(input.charAt(0)); // include

        // create the new input (after removing first character)
        StringBuilder newInput = new StringBuilder(input.substring(1));

        solve(newInput, output1, ans); // not including the character
        solve(newInput, output2, ans); // including the character
    }
}
