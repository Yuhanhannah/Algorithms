class Solution {
    public int getSum(int a, int b) {
        if (a == 0) {
            return b;
        } 
        if (b == 0) {
            return a;
        }
        
        int lower = 0;
        int carry = 0;
        
        while (true) {
            lower = a ^ b;
            carry = a & b;
            if (carry == 0) {
                break;
            }
            a = lower;
            b = carry << 1;
        }
        return lower;
        
    }
}