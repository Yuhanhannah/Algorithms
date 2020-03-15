class Solution {
    public List<Integer> sortArray(int[] nums) {
        //merge sort 
        List<Integer> result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return result;
        }
        
        mergeSort(nums, 0, nums.length - 1);
        for(int i : nums){
            result.add(i);
        }
        
        return result;
    }
    private void mergeSort(int[] nums, int left, int right){
        if(left >= right){
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }
    
    private void merge(int[] nums, int left, int mid, int right){
        int p1 = left, p2 = mid + 1;
        int k = 0;
        int[] temp = new int[right - left + 1];
        while(p1 <= mid || p2 <= right){
            //p1越界或者p2的值比p1的值小，就移动p2
            if(p1 > mid || p2 <= right && nums[p1] > nums[p2]){
                temp[k++] = nums[p2++];
            }else{
                temp[k++] = nums[p1++];
            } 
        }
        System.arraycopy(temp, 0, nums, left, right - left + 1);
    }
}