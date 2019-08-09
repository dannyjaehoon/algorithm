package dataStructureAlgorithmQuestions;

import java.io.*;
import java.util.*;

public class Arrays {

    /*
     * Hacker Rank Algorithm Question - Arrays - DS Solution
     * *
     * Category : Data Structure
     * Solved Date : 2019-08-08
     * Author : TK Lee
     *
     * Source : https://www.hackerrank.com/challenges/arrays-ds/problem
     */

    // Complete the reverseArray function below.
    static int[] reverseArray(int[] a) {

       int[] temp = new int[a.length];
       int j = 0;
        for(int i = a.length-1; i >= 0; i--) {
            temp[j] = a[i];
            j++;
        }
       return temp;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[arrCount];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arrCount; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] res = reverseArray(arr);

        for (int i = 0; i < res.length; i++) {
            bufferedWriter.write(String.valueOf(res[i]));

            if (i != res.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}