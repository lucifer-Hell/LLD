package Leetcode.dailyChallenges;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Problem1072 {
    public static int maxEqualRowsAfterFlips(int[][] mat) {
        Map<String, Integer> patFreq = new HashMap<>();

        for (int[] row : mat) {
            StringBuilder pattern = new StringBuilder();
            if (row[0] == 0) {
                for (int bit : row) pattern.append(bit);
            } else {
                for (int bit : row) pattern.append(bit ^ 1);
            }
            patFreq.merge(pattern.toString(), 1, Integer::sum);
        }

        return Collections.max(patFreq.values());
    }
    public static void main(String[] args) {
        System.out.println(maxEqualRowsAfterFlips(new int[][]{
                {0,0,0},{0,0,1},{1,1,0}
        }));
    }
}
