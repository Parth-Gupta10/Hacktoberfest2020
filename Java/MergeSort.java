//this program helps sorting an array using merge sort algorithm
//Time complexity: O(n*Log n)
//Space complexity: n

//program starts from here.
import java.util.*;

class MergeSort {
    public static void main (String[] args) {
        //INPUT PART OF PROGRAM.
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.print("Enter the array elements space separated");
        for(int i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
        }
        
        //OPERATIONS ON THE ABOVE ARRAY.
        mergeSort(arr, 0, arr.length-1);
        
        //FINAL OUTPUT
        System.out.print("Array after sorting is: ");
        for(int i : arr) {
            System.out.print(i + " ");
        }
    }
    
    //the main function which divides the array in halves
    //and then sort them separately
    //then merge them using merge function below this function
    public static void mergeSort(int arr[], int l, int r) { 
        if (l < r) {
            // Finding the middle point of the array
            int m = (l + r) / 2;
            // Sort first half then second half of the array.
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            // Merging the both halves of array.
            merge(arr, l, m, r);
        } 
    }
    
    //this function merges the two part of array as given in funcion parameter
    public static void merge(int arr[], int l, int m, int r) { 
        // Finding sizes of two halves which is to be merged.
        int fir = m - l + 1;
        int sec = r - m;

        //creating a temporarory array to store halves.
        int left[] = new int[fir];
        int right[] = new int[sec];
        
        //copying the data from main array
        for (int i = 0; i < fir; ++i)
            left[i] = arr[l + i];
        for (int j = 0; j < sec; ++j)
            right[j] = arr[m + 1 + j];

        //Merging the above temporarory arrays
        //Initial indexes of first and second halvessubarrays
        int i = 0, j = 0;
        // Initial index of merged halves of array
        int k = l;
        while (i < fir && j < sec) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        //copying the remaining elements.
        while (i < fir) {
            arr[k] = left[i];
            i++; k++;
        }
        while (j < sec) {
            arr[k] = right[j];
            j++; k++;
        }
    }
}
