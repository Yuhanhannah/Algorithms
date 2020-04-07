class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> mapping = new HashMap<>();
        for (String word: words) {
            if (mapping.containsKey(word)) {
                mapping.put(word, mapping.get(word) + 1);
            } else {
                mapping.put(word, 1);
            }
        }
        PriorityQueue<Map.Entry<String, Integer>> maxHeap= new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
           @Override
            public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                if (entry1.getValue() == entry2.getValue()) {
                    return entry1.getKey().compareTo(entry2.getKey());
                } else {
                    return entry1.getValue() > entry2.getValue() ? -1 : 1;
                }
            }
        });

        for (Map.Entry<String, Integer> entry: mapping.entrySet()) {
            maxHeap.offer(entry);
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(maxHeap.poll().getKey());
        }
        return result;
    }
}