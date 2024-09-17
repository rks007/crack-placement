package strings;

import java.util.Stack;

public class simplifyThePath {
    public static void main(String[] args) {
        String path = "/.../a/../b/c/../d/./";
//        String[] arr = path.split("/");
//        for (int i = 0; i < arr.length;i++){
//            System.out.println(arr[i]);
//        }

        System.out.println(simplifyPath(path));
    }
    private static String simplifyPath(String path){
        Stack<String> st = new Stack<>();
        String ans = "";
        int n = path.length();
        if(n == 1 && path.charAt(0) == '/'){
            return ans + path.charAt(0);
        }

        String[] arr = path.split("/");
        int len = arr.length;
        st.push(arr[0]);
        int i = 1;
        while(!st.isEmpty()){
            
        }




        return "sdfad";
    }
}
