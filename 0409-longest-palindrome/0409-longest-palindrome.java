class Solution {
    public int longestPalindrome(String s) {
        int[] freq = new int[128];
        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        int length = 0;
        boolean hasOdd = false;

        for (int f : freq) {
            if (f % 2 == 0) {
                length += f;
            } else {
                length += f - 1;
                hasOdd = true;
            }
        }

        return hasOdd ? length + 1 : length;
    }
}