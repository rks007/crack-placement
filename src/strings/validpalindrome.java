package strings;

public class validpalindrome { //leetcode 125
    public boolean isPalindrome(String s) {
        StringBuilder str = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                str.append(Character.toLowerCase(c));
            }
        }

        return palindrome(str.toString());


    }
    private boolean palindrome(String str){
        if(str.length() == 0 || str.length() == 1){
            return true;
        }
        int i = 0;
        int j = str.length() - 1;
        while(i <= j){
            if(str.charAt(i) == str.charAt(j)){
                i++;
                j--;
            } else{
                return false;
            }
        }
        return true;
    }
}
