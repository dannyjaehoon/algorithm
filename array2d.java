import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int[][] rtn = new int[arr.length - 2][arr[0].length - 2];

        for(int i = 0; arr.length - i >= 3; i++) {

            for(int j = 0; arr[i].length - j >= 3; j++) {

                // in each element, need to be interated 3 * 3 again

                rtn[i][j] = calculate(arr, i, j);

            }

        }

 

        int max = -2000000000;

        for(int i = 0; i < rtn.length; i++) {

            for(int j = 0; j < rtn[i].length; j++) {

                System.out.print(rtn[i][j] + " ");

                if (max < rtn[i][j]) {

                    max = rtn[i][j];

                }

            }

            System.out.println();

        }

        System.out.println(max);
        return max;
    }
 

    private static int calculate(int[][] data, int i, int j) {

        int total = 0;

        for (int k = i; k < 3 + i; k++) {

            for (int l = j; l < 3 + j; l++) {

                if(k == i + 1 && (l == j || l == j + 2)) {

                    continue;

                }

                total += data[k][l];

            }

        }

        return total;

    }

    

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
