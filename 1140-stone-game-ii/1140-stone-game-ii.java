import java.util.*;

class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] suffixSum = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }

        int[][] memo = new int[n][n + 1]; // memo[i][M]
        for (int[] row : memo) Arrays.fill(row, -1);

        return dp(0, 1, suffixSum, memo, n);
    }

    private int dp(int i, int M, int[] suffixSum, int[][] memo, int n) {
        if (i == n) return 0;

        // If remaining piles can all be taken (2M covers the rest), take everything
        if (i + 2 * M >= n) {
            return suffixSum[i];
        }

        if (memo[i][M] != -1) {
            return memo[i][M];
        }

        int best = 0;
        for (int X = 1; X <= 2 * M; X++) {
            if (i + X > n) break;
            int opponentBest = dp(i + X, Math.max(M, X), suffixSum, memo, n);
            int current = suffixSum[i] - opponentBest;
            best = Math.max(best, current);
        }

        memo[i][M] = best;
        return best;
    }
}