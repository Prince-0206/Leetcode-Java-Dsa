class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int minLen = Integer.MAX_VALUE;
        String ans = "";
        int left = 0, ones = 0;

        for (int right = 0; right < n; right++) {
            if (s.charAt(right) == '1') ones++;

            // If we have too many ones, shrink from the left until valid
            while (ones > k) {
                if (s.charAt(left) == '1') ones--;
                left++;
            }

            // While window has exactly k ones, try shrinking further
            // to explore all valid windows ending at 'right'
            while (ones == k) {
                int len = right - left + 1;
                if (len < minLen) {
                    minLen = len;
                    ans = s.substring(left, right + 1);
                } else if (len == minLen) {
                    String candidate = s.substring(left, right + 1);
                    if (candidate.compareTo(ans) < 0) {
                        ans = candidate;
                    }
                }
                if (s.charAt(left) == '1') ones--;
                left++;
            }
        }

        return ans;
    }
}