class Solution {
    public String longestCommonPrefix(String[] strs) {

        for(int i = 0; i < strs[0].length(); i++) {
            for(String str : strs) {
                if(i == str.length() || str.charAt(i) != strs[0].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}