class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int prevIndex = 0, index = 0;
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for(int i = 0; i < nums.length; i++) {
            index = (i >= 1 && nums[i] == nums[i - 1]) ? prevIndex : 0;
            prevIndex = result.size();
            for(int j = index; j < prevIndex; j++) {
                List<Integer> temp = new ArrayList<>(result.get(j));
                temp.add(nums[i]);
                result.add(temp);
            }
        }  

        return result;      
    }
}
