class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map = new HashMap<>();
        for(int i = 0 ; i<s.length() ; i++){
            char sch = s.charAt(i);
            char tch = t.charAt(i);
            if(map.containsKey(sch)){
                if(!map.get(sch).equals(tch)) return false;
            } else if(map.containsValue(tch)){
                return false;
            } else{
                map.put(sch , tch);
            }
            
        }return true;
    }
}