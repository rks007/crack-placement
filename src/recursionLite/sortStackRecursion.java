package recursionLite;

import java.util.Stack;

public class sortStackRecursion {

    public class Solution {

        public static void sortStack(Stack<Integer> stack) {
            // Write your code here.
            sortRecur(stack);
        }
        private static void sortRecur(Stack<Integer> stack){
            if(stack.size() == 1){
                return;
            }

            int element = stack.pop();
            sortRecur(stack);
            insert(stack, element);
        }

        private static void insert(Stack<Integer> stack, int element){
            if(stack.size() == 0 || stack.peek() <= element){
                stack.push(element);
                return;
            }
            int val = stack.pop();
            insert(stack, element);
            stack.push(val);
            return;
        }

    }

}
