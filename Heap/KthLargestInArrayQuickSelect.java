class Solution {
    private int result;
    public int findKthLargest(int[] nums, int k) {
        result = -1;
        //quick select
        quickSelect(nums, 0, nums.length - 1, nums.length - k);
        return result;
    }
    private void quickSelect(int[] nums, int left, int right, int k){
        if(left > right){
            return;
        }
        int pivot = partition(nums, left, right);
        //System.out.println(pivot);
        if( pivot == k){
            result = nums[pivot];
            return;
        }else if(pivot < k){
            quickSelect(nums, pivot + 1, right, k);
        }else{
            quickSelect(nums, left, pivot - 1, k);
        }
    }
    private int partition(int[] nums, int left, int right){
        int pivot = nums[right];
        int p1 = left;
        int p2 = right - 1;
        while(p1 <= p2){
            if(nums[p1] < pivot){
                p1++;
            }else if(nums[p1] >= pivot){
                swap(nums, p1, p2);
                p2--;
            }
        }
        swap(nums, p1, right);
        return p1;
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}