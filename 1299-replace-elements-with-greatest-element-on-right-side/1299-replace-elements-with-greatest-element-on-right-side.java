class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        int maxSoFar = -1;
        
        for (int i = n - 1; i >= 0; i--) {
            result[i] = maxSoFar;
            maxSoFar = Math.max(maxSoFar, arr[i]);
        }
        
        return result;
    }
}