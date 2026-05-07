class Solution {
    
    private List<String> result = new ArrayList<>();
    private String[] digitToChar = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"
    };
    
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) {return result;}
        dfs(0, "", digits);
        return result;
    }

    private void dfs(int index, String combo, String digits) {
        if(index == digits.length()) {
            result.add(combo);
            return;
        }
        String chars = digitToChar[digits.charAt(index) - '0'];
        for(char c : chars.toCharArray()) {
            dfs(index + 1, combo + c, digits);
        }
    }
}
