import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {

        int[] leaderboard_scores = new int[scores.length];
        // check the scroes for duplicated numbers
        int count_score = 0;
        for (int i = 0; i < scores.length; i++) {
            if (i == scores.length - 1) {
                leaderboard_scores[count_score] = scores[i];
                break;
            }
            if (scores[i] != scores[i + 1]) {
                leaderboard_scores[count_score++] = scores[i];
            }
        }

        int[] alice_rank = new int[alice.length];
        int count = 0;
        // print rank, insert the score into the leaderboard
        for (int i = 0; i < alice.length; i++) {
            for (int j = 0; j < leaderboard_scores.length; j++) {
                if (alice[i] > leaderboard_scores[j]) {
                    int rank = j + 1;
                    // push an index into an return_array as a rank
                    alice_rank[count] = rank;
                    count++;
                    break;
                }
            }
        }
        return alice_rank;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}