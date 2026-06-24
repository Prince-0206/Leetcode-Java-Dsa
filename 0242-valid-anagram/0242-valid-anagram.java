class Solution {

    static HashMap<Character , Integer> mkfr(String str){
        HashMap<Character , Integer> map = new HashMap<>();
        for(char ar : str.toCharArray()){
    map.put(ar , map.getOrDefault(ar, 0) + 1);
   } return map;
    }
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character , Integer> m1 = mkfr(s);
        HashMap<Character , Integer> m2 = mkfr(t);
        return m1.equals(m2);
    }
}