class Solution {

    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> combo = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        Arrays.sort(candidates);

        dfs(0, candidates, combo, target, 0);
        return result;
    }

    private void dfs(int index, int[] candidates, List<Integer> combo, int target, int currSum) {
        if(currSum == target) {
            result.add(new ArrayList<>(combo));
            return;
        }
        
        for(int j = index; j < candidates.length; j++) {
            if(currSum + candidates[j] > target) {return;}
            if(j > index && candidates[j] == candidates[j-1]) {continue;}
            combo.add(candidates[j]);
            dfs(j + 1, candidates, combo, target, currSum + candidates[j]);
            combo.removeLast();
        }
    }
}
