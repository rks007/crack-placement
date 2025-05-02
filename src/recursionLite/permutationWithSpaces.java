package recursionLite;

import java.util.ArrayList;

public class permutationWithSpaces { //aditya verma
    public static void main(String[] args) {
        String input = "abc";

        // Convert the input string into a StringBuilder for easy modification
        StringBuilder str = new StringBuilder(input);

        // Start the output with the first character (we don't put a space before the first character)
        StringBuilder output = new StringBuilder();
        output.append(str.charAt(0));

        // Remove the first character from input, since it's already in the output
        str.deleteCharAt(0);

        // List to store all possible permutations with spaces
        ArrayList<String> ans = new ArrayList<>();

        // Begin the recursive generation of permutations
        solve(str, output, ans);

        // Print the final list of permutations
        System.out.println(ans);
    }

    private static void solve(StringBuilder input, StringBuilder output, ArrayList<String> ans) {
        // If there are no more characters to add, store the current permutation
        if (input.isEmpty()) {
            ans.add(output.toString());
            return;
        }

        // Get the next character from the input
        char ch = input.charAt(0);

        // Create a new input by removing the current character
        StringBuilder newInput = new StringBuilder(input.substring(1));

        // Create two new output variations:
        // 1. One with a space (or underscore) before adding the next character
        StringBuilder op1 = new StringBuilder(output);
        op1.append('_'); // You can replace '_' with ' ' if needed
        op1.append(ch);

        // 2. One where the next character is added directly
        StringBuilder op2 = new StringBuilder(output);
        op2.append(ch);

        // Recursively process the remaining input with both output options
        solve(newInput, op1, ans);
        solve(newInput, op2, ans);
    }
}
