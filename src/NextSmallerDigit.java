import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NextSmallerDigit {

    public static void main(String[] args) {
        nextSmaller(21);
        nextSmaller(531);
        nextSmaller(2017);
    }

    // Utility function to swap two digit
    static void swap(char ar[], int i, int j) {
        char temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

    // Utility function descending order
    public static long descending(char[] arr , int n, int m) {
        if(arr[0] == '0') {
            return -1;
        }

        char[] arr2 = new char[arr.length];
        for (int i = 0; i < m; i++) {
            arr2[i] = arr[i];
        }
        char temp = '0';
        for (int i = m; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] < arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr2[i] = arr[i];
            //System.out.print(arr[i] + " ");
        }
        return Long.parseLong(String.valueOf(arr2));

    }



    // Given a number as a char array number[],
    // this function finds the next greater number.
    // It modifies the same array to store the result
    static long nextSmaller(long p) {
        System.out.println("num: " + p);
        char ar[] = String.valueOf(p).toCharArray();
        int n = ar.length;
        int i;

        // I) Start from the right most digit
        // and find the first digit that is smaller
        // than the digit next to it.
        for (i = n - 1; i > 0; i--) {
            if (ar[i] < ar[i - 1]) {// első ami kisebb mint a tőle balra lévő
                break;
            }
        }

        // If no such digit is found, then all
        // digits are in descending order means
        // there cannot be a greater number with
        // same set of digits
        if (i == 0) {

            System.out.println("Not possible");

            return -1;
        } else {
            int x = ar[i - 1], max = i;

            // II) Find the biggest digit on right
            // side of (i)'th digit that is greater
            // than number[i]
            for (int j = i + 1; j < n; j++) {
                if (ar[j] < x && ar[j] > ar[max]) {
                    max = j;
                }
            }

            // III) Swap the above found biggest
            // digit with number[i-1]
            swap(ar, i - 1, max);

            // IV) Sort the digits after (i-1)
            // in descending order


            descending(ar, n, i);


        }
        System.out.println("next smaller num: "+descending(ar, n, i));
        return descending(ar, n, i);
    }
}
