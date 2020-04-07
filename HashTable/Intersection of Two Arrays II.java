class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> mapping = new HashMap<>();
        
        for (int num : nums1) {
            if (!mapping.containsKey(num)) {
                mapping.put(num, 1);
            } else {
                mapping.put(num, mapping.get(num) + 1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if(mapping.containsKey(num) && mapping.get(num) > 0) {
                list.add(num);
                mapping.put(num, mapping.get(num) - 1);
            }
        }
        int i = 0;
        int[] result = new int[list.size()];
        for (int num : list) {
            result[i++] = num;
        }
        return result;
    }
}