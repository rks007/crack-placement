package strings;

// I	1
// V	5
// X	10
// L	50
// C	100
// D	500
// M	1000

import java.util.HashMap;

public class integerToRoman {
    public static void main(String[] args) { //leetcode 12
        int num = 3749;

        System.out.println(intToRoman(num));
    }
    private static String intToRoman(int num){ //dry run for better understanding
        String ans = "";

        HashMap<Integer, String> mp = new HashMap<>();
        mp.put(1, "I");
        mp.put(4, "IV");
        mp.put(5, "V");
        mp.put(9, "IX");
        mp.put(10, "X");
        mp.put(40, "XL");
        mp.put(50, "L");
        mp.put(90, "XC");
        mp.put(100, "C");
        mp.put(400, "CD");
        mp.put(500, "D");
        mp.put(900, "CM");
        mp.put(1000, "M");

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        for(int value : values){
            while(num >= value){
                ans += mp.get(value);
                num -= value;
            }
        }

        return ans;

    }

}
