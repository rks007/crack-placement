package strings;

public class longestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower", "flight", "flow"};
        String ans = longestCommonPrefix(strs);
        System.out.println(ans);
    }
    public static String longestCommonPrefix(String[] strs) { //leetcode 14

        // Get the number of strings in the array
        int n = strs.length;

        // Initialize index to 0 to keep track of the current character position
        int index = 0;

        // Initialize an empty string to store the result (longest common prefix)
        String ans = "";

        // Loop through the characters of the first string until the end of the string
        while(index < strs[0].length()){
            // Get the current character from the first string at position 'index'
            char ch = strs[0].charAt(index);

            // Loop through the rest of the strings in the array
            for(int i = 1; i < n; i++){
                // Check if the current index exceeds the length of any string or the character
                // at the current index of any string does not match the character from the first string
                if(index >= strs[i].length() || strs[i].charAt(index) != ch){
                    // If any string does not match, return the current longest common prefix
                    return ans;
                }
            }

            // If all strings have the same character at the current index, increment the index
            index++;
            // Add the current character to the result string
            ans += ch;
        }

        // Return the longest common prefix after exiting the loop
        return ans;
    }
}
