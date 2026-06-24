class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        
        Arrays.sort(nums);
        
        int maxlen = 1;
        int len = 1;
        
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1] + 1){
                len++;
                maxlen = Math.max(maxlen, len);
            } else if(nums[i] != nums[i-1]){  // duplicate skip karo
                len = 1;
            }
        }
        return maxlen;
    }
}