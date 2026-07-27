class Solution {
    public String[] findWords(String[] words) {
        int[] rowOf = new int[26];
        String[] rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        
        for (int r = 0; r < rows.length; r++) {
            for (char c : rows[r].toCharArray()) {
                rowOf[c - 'a'] = r;
            }
        }
        
        List<String> result = new ArrayList<>();
        
        for (String word : words) {
            String lower = word.toLowerCase();
            int row = rowOf[lower.charAt(0) - 'a'];
            boolean valid = true;
            
            for (char c : lower.toCharArray()) {
                if (rowOf[c - 'a'] != row) {
                    valid = false;
                    break;
                }
            }
            
            if (valid) {
                result.add(word);
            }
        }
        
        return result.toArray(new String[0]);
    }
}