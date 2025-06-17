package slidingWindow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FirstNegativeInEveryWindowofSizeK {
    static List<Integer> firstNegInt(int arr[], int k) {
        // write code here
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(j < arr.length){
            if(arr[j] < 0){
                q.add(arr[j]);
            }
            if(j - i + 1 < k){
                j++;

            } else if(j - i + 1 == k){
                if(!q.isEmpty()){
                    ans.add(q.peek());
                } else{
                    ans.add(0);
                }

                if(arr[i] < 0 && !q.isEmpty()){
                    q.remove();
                }
                i++;
                j++;

            }
        }
        return ans;
    }
}
