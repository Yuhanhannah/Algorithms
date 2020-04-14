class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int fast = 0;
        int slow = 0;
        int max = 0;
        Map<Character, Integer> countMap = new HashMap<>();
        
        while (fast < s.length()) {
            char cur = s.charAt(fast);
            countMap.put(cur, countMap.getOrDefault(cur, 0) + 1);
            fast++;
            while (slow <= fast && countMap.size() > k) {
                char oldChar = s.charAt(slow);
                if (countMap.get(oldChar) == 1) {
                    countMap.remove(oldChar);
                } else {
                    countMap.put(oldChar, countMap.get(oldChar) - 1);
                }
                slow++;
            }
            max = Math.max(fast - slow, max);
        }
        return max;
    }
}