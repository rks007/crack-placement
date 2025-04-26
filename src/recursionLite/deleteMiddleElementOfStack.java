package recursionLite;

import java.util.Stack;

public class deleteMiddleElementOfStack {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};

        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < arr.length; i++){
            st.push(arr[i]);
        }

        deleteMiddle(st, st.size(), 1);

        System.out.println(st);
    }

    private static void deleteMiddle(Stack<Integer> st, int size, int index) {
        if (index == size / 2) {
            st.pop(); // remove middle element
            return;
        }

        int top = st.pop();
        deleteMiddle(st, size, index + 1);
        st.push(top);
    }
}
