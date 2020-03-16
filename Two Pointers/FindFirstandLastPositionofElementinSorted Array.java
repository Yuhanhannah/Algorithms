class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[]{-1, -1};
        }
        
        return new int[]{findFirst(nums, target), findLast(nums, target)};
    }
    
    private int findFirst(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while(left + 1 < right){
            int mid = left + (right - left ) / 2;
            if(nums[mid] == target){
                right = mid;
            }else if(nums[mid] < target){
                left = mid;
            }else{
                right = mid;
            }
        }
        if(nums[left] == target){
            return left;
        }else if(nums[right] == target){
            return right;
        }
        
        return -1;
    }
     private int findLast(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while(left + 1 < right){
            int mid = left + (right - left ) / 2;
            if(nums[mid] == target){
                left = mid;
            }else if(nums[mid] < target){
                left = mid;
            }else{
                right = mid;
            }
        }
        if(nums[right] == target){
            return right;
        }else if(nums[left] == target){
            return left;
        }
        
        return -1;
    }
}