class Solution {
    public String toHex(int num) {
        if (num == 0) return "0";
        
        char[] hexDigits = "0123456789abcdef".toCharArray();
        StringBuilder sb = new StringBuilder();
        
        // Treat num as unsigned 32-bit integer
        while (num != 0) {
            int digit = num & 0xF;          // take last 4 bits
            sb.append(hexDigits[digit]);
            num >>>= 4;                     // unsigned right shift
        }
        
        return sb.reverse().toString();
    }
}