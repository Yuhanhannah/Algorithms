class Solution {
    public int findKthLargest(int[] nums, int k) {
        //Min Heap
        if(nums == null || nums.length == 0){
            return -1;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> (a - b));
        for(int i = 0; i < k; i++){
            minHeap.add(nums[i]);
        }
        for(int i = k; i < nums.length; i++){
            if(nums[i] > minHeap.peek()){
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }
        return minHeap.poll();
    }
}