class Solution {
    public List<Integer> sortArray(int[] nums) {
        List<Integer> result = new ArrayList<>();
        //selection sort
        if(nums == null || nums.length == 0){
            return null;
        }

        for(int i = 0; i < nums.length; i++){
            int minIndex = i;
            for(int j = i + 1; j < nums.length; j++){
                if(nums[j] < nums[minIndex]){
                    minIndex = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
            result.add(nums[i]);
        }
        return result;
    }
}