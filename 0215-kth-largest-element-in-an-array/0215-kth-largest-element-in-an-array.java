import java.util.Random;

class Solution {
    private final Random rand = new Random();

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int target = n - k; // index of kth largest in ascending sorted order
        int lo = 0, hi = n - 1;

        while (true) {
            int pivotIndex = partition(nums, lo, hi);
            if (pivotIndex == target) {
                return nums[pivotIndex];
            } else if (pivotIndex < target) {
                lo = pivotIndex + 1;
            } else {
                hi = pivotIndex - 1;
            }
        }
    }

    // Lomuto partition with random pivot
    private int partition(int[] nums, int lo, int hi) {
        int pivotIdx = lo + rand.nextInt(hi - lo + 1);
        swap(nums, pivotIdx, hi);
        int pivot = nums[hi];

        int store = lo;
        for (int i = lo; i < hi; i++) {
            if (nums[i] < pivot) {
                swap(nums, i, store);
                store++;
            }
        }
        swap(nums, store, hi);
        return store;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}