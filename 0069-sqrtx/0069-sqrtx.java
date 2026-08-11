class Solution {
    public int mySqrt(int x) {
        if (x < 2)
            return x; // 0 or 1

        long left = 1, right = x / 2;
        long ans = 1;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long sq = mid * mid;

            if (sq == x) {
                return (int) mid;
            } else if (sq < x) {
                ans = mid; // mid is a valid candidate, try bigger
                left = mid + 1;
            } else {
                right = mid - 1; // too big, try smaller
            }
        }

        return (int) ans;
    }
}