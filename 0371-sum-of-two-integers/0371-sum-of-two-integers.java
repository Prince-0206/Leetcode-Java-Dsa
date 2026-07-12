class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;  // common 1s dhundo, unko left shift karo
            a = a ^ b;                  // sum without carry
            b = carry;                  // ab carry ko hi 'b' bana do, aur loop continue
        }
        return a;
    }
}