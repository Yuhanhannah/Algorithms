class Solution {
    public int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        for (int num: nums) {
            if (num > max) {
               max = num;
            }
            set.add(num);
        }
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return max + 1;
    }
}