class Solution {
    public void nextPermutation(int[] nums) {
        //从后往前找， 找到第一个nums[i] < nums[i+1]的数
        //从后往前找，找到第一个比nums[i] 大的数
        //swap
        //reverse后半部分
        //注意一定要把相等的情况给跳过
         if(nums == null || nums.length == 0 || nums.length == 1) {
            return;
        }
        //iterate from the tail of nums, find the first num which nums[i] < nums[i - 1]
        int i = nums.length - 2;
        while(i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if(i >= 0) {
            int j = nums.length - 1;
            while(j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i , j);
        }
        reverse(nums, i + 1);
    }
    
    private void reverse(int[] nums, int i) {
        int j = nums.length - 1;
        while(i < j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}