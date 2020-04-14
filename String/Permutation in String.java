class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //cornor case
        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0 || s1.length() > s2.length()) {
            return false;
        }
        //get s1 frequency
        Map<Character, Integer> freq = getFrequency(s1);
        int type = freq.size();
        int windowSize = s1.length();
        for (int i = 0; i < s2.length(); i++) {
            char newChar = s2.charAt(i);
            if (freq.containsKey(newChar)) {
                freq.put(newChar, freq.get(newChar) - 1);
                if (freq.get(newChar) == 0) {
                    type--;
                }
            }
            if (i >= windowSize) {
                char oldChar = s2.charAt(i - windowSize);
                if (freq.containsKey(oldChar)) {
                    if (freq.get(oldChar) == 0) {
                        type++;
                    }
                    freq.put(oldChar, freq.get(oldChar) + 1);
                }
            }
            if (type == 0) {
                return true;
            }
        }
        
        return false;
    }
    private Map<Character, Integer> getFrequency(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (freq.containsKey(cur)) {
                freq.put(cur, freq.get(cur) + 1);
            } else {
                freq.put(cur, 1);
            }
        }
        return freq;
    }
}