class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i = nums2.length-1 ; i>=0 ; i--){
            while(!st.isEmpty() && nums2[st.peek()] <= nums2[i]){
                st.pop();
            }
            map.put(nums2[i] , st.isEmpty() ? -1 : nums2[st.peek()]);
            st.push(i);
        }
        int[] arr = new int[nums1.length];
        for(int i = 0 ; i<arr.length ; i++){
                arr[i] = map.get(nums1[i]);
            }
        return arr;
    }
}