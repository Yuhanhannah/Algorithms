class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0 ){
            return -1;
        }
        //Max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));
        for(int n : nums){
            maxHeap.add(n);
        }
        while(k > 1){
            maxHeap.poll();
            k--;
        }
        return maxHeap.poll();        
    }
}