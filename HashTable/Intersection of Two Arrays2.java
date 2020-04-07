class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> interset = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            if (set1.contains(num)) {
               interset.add(num); 
            }
        }
        int[] result = new int[interset.size()];
        int i = 0;
        for (int num : interset) {
            result[i++] = num;
        }
        return result;
    }
}