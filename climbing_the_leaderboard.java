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

    //  scores are in descending order
    // alica are in ascending order

    int[] leaderboard_scores = new int[];
    //check the scroes for duplicated numbers
    for(int i = 0; i< scores.length; i++) {
        if(i == scores.length-1) {
            leaderboard_scores[i] = scores[i];
            break;
        }
        if(scores[i] != scores[i+1]) {
            leaderboard_scores[i] = scores[i];
        } else {
            i++;
        }
    }

    int[] alice_rank = new int[];
    //print rank, insert the score into the leaderboard
    for(int i = 0; i<alice.length; i++) {
        for(int j=0; j<leaderboard_scores.length; i++) {
            if(alica[i] > leaderboard_scores[j]) {
                int pos = j;
                //insert the number into the scores
            }
        }
        alice_rank.push(findIndex(leaderboard_scores, i));
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