class Solution {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> subset = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return result;
    }

    public void dfs(int index, int[] nums) {

        if(index >= nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[index]);
        dfs(index + 1, nums);
        subset.removeLast();
        dfs(index + 1, nums);
    }
}
