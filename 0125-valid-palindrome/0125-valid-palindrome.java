class Solution {
    public boolean isPalindrome(String s) {
        int left = 0 ;
        int right = s.length()-1;
        while(left<right){
            char leftch = Character.toLowerCase(s.charAt(left));
            char rightch = Character.toLowerCase(s.charAt(right));
            if(!Character.isLetterOrDigit(leftch)){
                left++;
                continue;
            }
            if(!Character.isLetterOrDigit(rightch)){
                right--;
                continue;
            }
            if(leftch != rightch){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}