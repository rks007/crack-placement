package recursionLite;

import java.util.Scanner;

public class taskOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number");
        int num = sc.nextInt();

        int ans = factorial(num);
        System.out.println(ans);

    }
    private static int factorial(int num){
        if(num == 1){
            return 1;
        }
        return num * factorial(num - 1);
    }
}
