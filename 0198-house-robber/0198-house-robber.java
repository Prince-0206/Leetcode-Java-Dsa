class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int prev = 0;
        int prev2 = 0;
        for(int i = 0 ; i<n ; i++){
            int max = Math.max(prev , prev2+nums[i]);
            prev2 = prev;
            prev = max;
        }
        return prev;
    }
}