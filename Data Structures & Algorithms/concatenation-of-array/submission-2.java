class Solution {
    public int[] getConcatenation(int[] nums) {
        
        ArrayList<Integer> ans = new ArrayList<>();

        for(int num : nums) {ans.add(num);}
        for(int num : nums) {ans.add(num);}

        return ans.stream().mapToInt(i -> i).toArray();

    }
}