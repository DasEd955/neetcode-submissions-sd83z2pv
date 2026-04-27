class Solution {

    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> combo = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {

        dfs(0, nums, combo, 0, target);
        return result;
    }

    public void dfs(int index, int[] nums, List<Integer> combo, int currSum, int target) {
        if(currSum >= target || index >= nums.length) {
            if(currSum == target) {result.add(new ArrayList<>(combo));}
            return;
        }
        combo.add(nums[index]);
        dfs(index, nums, combo, currSum + nums[index], target);
        combo.removeLast();
        dfs(index + 1, nums, combo, currSum, target);
    }
}
