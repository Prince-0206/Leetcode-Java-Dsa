class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        for (int end = 0; end < n; end++) {
            for (int start = 0; start <= end; start++) {
                if (s.charAt(start) == s.charAt(end) && 
                    (end - start <= 2 || isPalindrome[start + 1][end - 1])) {
                    isPalindrome[start][end] = true;
                }
            }
        }
        List<List<String>> result = new ArrayList<>();
        List<String> current = new ArrayList<>();
        backtrack(s, 0, isPalindrome, current, result);
        return result;
    }
    
    private void backtrack(String s, int start, boolean[][] isPalindrome, 
    List<String> current, List<List<String>> result) {
        int n = s.length();
        if (start == n) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int end = start; end < n; end++) {
            if (isPalindrome[start][end]) {
                current.add(s.substring(start, end + 1));
                backtrack(s, end + 1, isPalindrome, current, result);
                current.remove(current.size() - 1);
            }
        }
    }
}