package strings;

public class reverseWordInAString {
    public String reverseWords(String s) { //leetcode 151
        StringBuilder str = new StringBuilder(s);

        str.reverse();
        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < s.length(); i++){

            StringBuilder helper = new StringBuilder();

            while(i < s.length() && str.charAt(i) != ' '){
                helper.append(str.charAt(i));
                i++;
            }

            //then reverse the word that you got, so reverese the helper strig
            helper.reverse();

            if(helper.length() > 0){
                ans.append(' ');
                ans.append(helper);
            }
        }

        return ans.substring(1).toString();


    }
}
