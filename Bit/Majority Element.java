class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        Map.Entry<Integer, Integer> majority = null;
        
        for (Map.Entry<Integer, Integer> element : counts.entrySet()) {
            if (majority == null || element.getValue() > majority.getValue()) {
                majority = element;
            }
        }
        
        return majority.getKey();
    }
}