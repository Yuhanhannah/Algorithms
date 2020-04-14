class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        Set<Character> seen = new HashSet<>();
        int left = 0, right = 0;
        while (right < s.length()) {
            char cur = s.charAt(right);
            if (!seen.contains(cur)) {
                seen.add(cur);
                right++;
                max = Math.max(max, right - left);
            } else {
                seen.remove(s.charAt(left));
                left++;
            }
        }
        
        return max;
    }
}