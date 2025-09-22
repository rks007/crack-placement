package binarySearch;

public class bookAllocation {
    public int findPages(int[] arr, int k) { //gfg
        // code here

        if(arr.length < k){
            return -1;
        }

        // Calculate total pages and find maximum pages in a single book
        int sum = 0;
        int maxPages = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            maxPages = Math.max(maxPages, arr[i]); // Find maximum element
        }

        int start = maxPages;
        int end = sum;

        int res = -1;

        while(start <= end){

            int mid = start + (end - start) / 2;

            int student = countStudents(arr, mid);

            if (student <= k) {
                res = mid;
                end = mid - 1; // try smaller pages
            } else if (student > k){
                start = mid + 1; //need more pages
            }
        }

        return res;
    }

    private static int countStudents(int[] arr, int pages){
        int student = 1;

        int countPages = 0;

        for(int i = 0; i < arr.length; i++){
            if(countPages + arr[i] <= pages){
                countPages += arr[i];
            } else {
                student++;
                countPages = arr[i];
            }
        }

        return student;
    }
}
