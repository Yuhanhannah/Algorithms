class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        //get p frequency
        Map<Character, Integer> pfreq = new HashMap<>();
        pfreq = getFrequency(p);
        int windowSize = p.length();
        int type = pfreq.size();
        //sliding window
        for (int i = 0; i < s.length(); i++) {
            //add to sliding window
            char newChar = s.charAt(i);
            if (pfreq.containsKey(newChar)) {
                pfreq.put(newChar, pfreq.get(newChar) - 1);
                if (pfreq.get(newChar) == 0) {
                    type--;
                }
            }
            //move out of the sliding window
            if (i >= windowSize) {
                char oldChar = s.charAt(i - windowSize);
                if (pfreq.containsKey(oldChar)) {
                    if (pfreq.get(oldChar) == 0) {
                    type++;
                    } 
                    pfreq.put(oldChar, pfreq.get(oldChar) + 1);   
                }  
            }
            
            if (type == 0) {
                result.add(i - windowSize + 1);
            }
        }
        return result;
    }
    private Map<Character, Integer> getFrequency(String p) {
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char cur = p.charAt(i);
            if (freq.containsKey(cur)) {
                freq.put(cur, freq.get(cur) + 1);
            } else {
                freq.put(cur, 1);
            }
        }
        return freq;
    }
}