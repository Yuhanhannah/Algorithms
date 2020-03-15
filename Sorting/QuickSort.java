class Solution {
    public List<Integer> sortArray(int[] nums) {
        //quicksort
        List<Integer> result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return result;
        }
        quickSort(nums, 0, nums.length - 1);
        for(int num : nums){
            result.add(num);
        }
        
        return result;
    }
    private void quickSort(int[] nums, int left, int right){
        if(left >= right){
            return;
        }
        int pivotPos = partition(nums, left ,right);
        quickSort(nums, left, pivotPos - 1);
        quickSort(nums, pivotPos, right);
    }
    private int partition(int[] nums, int left ,int right){
        int pivot = nums[right];
        int i = left, j = right - 1;
        while(i <= j){
            if(nums[i] <= pivot){
                i++;
            }else if(nums[i] > pivot){
                swap(nums, i, j);
                j--;
            }
        }
        swap(nums, i, right);
        return i;
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}