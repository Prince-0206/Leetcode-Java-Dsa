
class Solution {
    public String largestNumber(int[] nums) {
        // Step 1: saare numbers ko String me convert karo
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        // Step 2: custom sorting — ek normal Comparator class banake
        Arrays.sort(strs, new Comparator<String>() {
            public int compare(String a, String b) {
                String option1 = a + b; // a pehle, phir b
                String option2 = b + a; // b pehle, phir a

                // agar option2 bada hai, matlab b ko pehle rakhna chahiye
                // isliye negative number return karo taaki 'a' peeche chala jaye
                return option2.compareTo(option1);
            }
        });

        // Step 3: agar sबसे bada number "0" nikla, matlab saare zeros hain
        if (strs[0].equals("0")) {
            return "0";
        }

        // Step 4: saari strings ko jod do
        String result = "";
        for (String s : strs) {
            result = result + s;
        }

        return result;
    }
}