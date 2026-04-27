class Solution {
    
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> permutation = new ArrayList<>();
    private boolean[] chosen;

    public List<List<Integer>> permute(int[] nums) {
        
        chosen = new boolean[nums.length];

        dfs(permutation, nums);
        return result;
    }

    private void dfs(List<Integer> permutation, int[] nums) {
        if(permutation.size() == nums.length) {
            result.add(new ArrayList<>(permutation));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(chosen[i] == false) {
                permutation.add(nums[i]);
                chosen[i] = true;
                dfs(permutation, nums);
                permutation.removeLast();
                chosen[i] = false;
            }
        }
    }
}
