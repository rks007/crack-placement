package arrays;

//before attempting this question you should have the understanding of merge sort very well
public class countInversion { //refer to striver video
    static int count = 0;
    public static int numberOfInversions(int []a, int n) { //main function given in question
        // Write your code here.
        mergeSort(a, 0, n - 1);
        return count;
    }

    private static void mergeSort(int[] arr, int l, int r){
        if(l >= r){
            return;
        }

        int mid = (l + r) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private static void merge(int[] arr, int l, int mid, int r){
        int n1 = mid - l + 1;
        int n2 = r - mid;

        int[] num1 = new int[n1];
        int[] num2 = new int[n2];

        for(int i = 0; i < n1; i++){
            num1[i] = arr[l + i];
        }
        for(int i = 0; i < n2; i++){
            num2[i] = arr[mid + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = l;

        while(i < n1 && j < n2){
            if(num1[i] <= num2[j]){
                arr[k++] = num1[i++];
            } else {
                arr[k++] = num2[j++];
                // Count the inversions (all remaining elements in num1 are greater)
                count += n1 - i; //only change in the whole merge sort code  to come up with an answer for count inversion
            }
        }

        while(i < n1){
            arr[k++] = num1[i++];
        }
        while(j < n2){
            arr[k++] = num2[j++];
        }
    }
}
