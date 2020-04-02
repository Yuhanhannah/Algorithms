class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> permutation = new ArrayList<>();
        dfs(nums, 0, permutation, result);
        return result;
    }
    private void dfs(int[] nums, int index, List<Integer> permutation, List<List<Integer>> result) {
        if(index == nums.length){
            result.add(new ArrayList<>(permutation));
        }
        for(int i = index; i < nums.length; i++) {
            //swap num with index
            swap(nums, index, i);
            permutation.add(nums[index]);
            dfs(nums, index + 1, permutation, result);
            permutation.remove(permutation.size() - 1);
            swap(nums, index, i);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}