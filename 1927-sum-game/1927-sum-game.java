class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int half = n / 2;
        
        long sum1 = 0, sum2 = 0;
        int cnt1 = 0, cnt2 = 0;
        
        for (int i = 0; i < half; i++) {
            char c = num.charAt(i);
            if (c == '?') cnt1++;
            else sum1 += (c - '0');
        }
        
        for (int i = half; i < n; i++) {
            char c = num.charAt(i);
            if (c == '?') cnt2++;
            else sum2 += (c - '0');
        }
        
        long diff = sum1 - sum2;
        
        if (cnt1 == cnt2) {
            return diff != 0;
        }
        
        // Make cnt1 < cnt2
        if (cnt1 > cnt2) {
            int tmp = cnt1;
            cnt1 = cnt2;
            cnt2 = tmp;
            diff = -diff;
        }
        
        int d = cnt2 - cnt1;
        
        if (d % 2 == 1) {
            return true; // Alice always wins when the extra count is odd
        }
        
        return diff != (9L * d / 2);
    }
}