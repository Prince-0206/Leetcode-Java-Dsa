class Solution {
    public int findMin(int[] nums) {
        int n= nums.length;
        int st = 0;
        int end = n-1;
        int min = Integer.MAX_VALUE;
        while(st<=end){
            int mid = (st+end)/2;
            if(nums[st]<=nums[mid]){
                min = Math.min(min , nums[st]);
                st = mid+1;
            } else{
                min = Math.min(min , nums[mid]);
                end = mid-1;
            }
        }
        return min;
    }
}