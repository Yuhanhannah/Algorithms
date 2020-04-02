class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // n layers
        // two states
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(nums, 0, cur, result);
        return result;
    }
    private void dfs(int[] nums, int index, List<Integer> cur, List<List<Integer>> result){
        //base case
        if(index == nums.length){
            result.add(new ArrayList(cur));
            return;
        }
        cur.add(nums[index]);
        dfs(nums, index + 1, cur, result);
        cur.remove(cur.size() - 1);
        dfs(nums, index + 1, cur, result);
    }
}