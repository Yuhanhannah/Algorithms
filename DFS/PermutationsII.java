class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> permutation = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, 0, visited, permutation, result);
        return result;
    }
    private void dfs(int[] nums, int index, boolean[] visited, List<Integer> permutation, List<List<Integer>> result) {
        if(index == nums.length) {
            result.add(new ArrayList<>(permutation));
        }
        for(int i = 0; i < nums.length; i++) {
            if(visited[i]){
                continue;
            }
            if(i > 0 && nums[i - 1] == nums[i] && visited[i - 1] == false){
                continue;
            }
            visited[i] = true;
            permutation.add(nums[i]);
            dfs(nums, index + 1, visited, permutation, result);
            permutation.remove(permutation.size() - 1);
            visited[i] = false;
        }
    }
}