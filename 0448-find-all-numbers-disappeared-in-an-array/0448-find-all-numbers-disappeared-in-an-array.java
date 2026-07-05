class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
       for(int i = 0 ; i<n ; i++){
        int index = Math.abs(nums[i])-1;
        if(nums[index]>0){
            nums[index] = -nums[index];
        }
       }
       List<Integer> list = new ArrayList<>();
       for(int i = 0 ; i<n ; i++){
        if(nums[i]>0){
            list.add(i+1);
        } else{
            nums[i] = -nums[i];
        }
       }
       return list;
    }
}