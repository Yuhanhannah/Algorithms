class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {

        int slow = 0, fast = 0;
        int max = 0;
        
        //Set<Character> set = new HashSet<>();
        Map<Character, Integer> mapping = new HashMap();
        while (fast < s.length()) {
            char newChar = s.charAt(fast);
            mapping.put(newChar, mapping.getOrDefault(newChar, 0) + 1);
            while (slow <= fast && mapping.size() > 2) {
                char oldChar = s.charAt(slow);
                if(mapping.get(oldChar) == 1) {
                    mapping.remove(oldChar);
                } else {
                    mapping.put(oldChar, mapping.get(oldChar) - 1);
                }
                slow++;
            }   
            fast++;
            max = Math.max(max, fast - slow);
        }
        return max;
    }
}