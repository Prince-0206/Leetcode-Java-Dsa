class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        Deque<Integer> stack = new ArrayDeque<>(); // stores indices

        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n];
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                result[stack.pop()] = num;
            }
            if (i < n) {
                stack.push(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {1, 2, 1};
        System.out.println(Arrays.toString(sol.nextGreaterElements(nums1)));
        // [2, -1, 2]

        int[] nums2 = {1, 2, 3, 4, 3};
        System.out.println(Arrays.toString(sol.nextGreaterElements(nums2)));
        // [2, 3, 4, -1, 4]
    }
}