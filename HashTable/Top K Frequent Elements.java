class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mapping = new HashMap<>();
        for (int num : nums) {
            if (mapping.containsKey(num)) {
                mapping.put(num, mapping.get(num) + 1);
            } else {
                mapping.put(num, 1);
            }
        }
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> entry1, Map.Entry<Integer, Integer> entry2) {
                if (entry1.getValue() == entry2.getValue()) {
                    return 0;
                } else {
                    return entry1.getValue() > entry2.getValue() ? -1 : 1;
                }
            }
        });
        for (Map.Entry<Integer, Integer> entry : mapping.entrySet()) {
            maxHeap.offer(entry);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(maxHeap.poll().getKey());
        }
        return result;
    }
}