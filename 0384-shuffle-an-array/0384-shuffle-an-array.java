import java.util.Random;

class Solution {
    private int[] original;
    private int[] array;
    private Random rand = new Random();

    public Solution(int[] nums) {
        original = nums;
        array = nums.clone();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        array = original.clone();
        return array;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        // Fisher-Yates shuffle
        for (int i = array.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            // swap array[i] and array[j]
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        return array;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
 