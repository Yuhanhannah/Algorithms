class Solution {
    public String getPermutation(int n, int k) {
        if(n == 1) {
            return "1";
        }
        //方法一：求余法
        //1,第一个位置放置 x = k / (n - 1)!
        //2,第二个位置放置 x = (k % (n - 1)!) / (n - 2)!
        //由此规律可以直接定位每个位置放置的数字
        List<String> nums = new LinkedList<>();
        for(int i = 1; i <= 9; i++) {
            nums.add(Integer.toString(i));
        }
        String ans = "";
        k--;
        while(n > 0) {
            int factorial = getFactorial(n--);
            int at = k / factorial;
            k = k % factorial;
            ans += nums.get(at);
            nums.remove(at);
        }
        
        return ans;
    }
    private int getFactorial(int n) {
        int num = 1;
        for(int i = 1; i < n; i++) {
            num *= i;
        }
        return num;
    }
}