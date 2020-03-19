class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);
        
        int p1 = 0, p2 = 0;
        int index = 0;
        while(p1 < m || p2 < n){
            if(p1 > m - 1 || (p2 <= n - 1 && nums2[p2] < nums1_copy[p1])){
                nums1[index++] = nums2[p2++];
            }else{
                nums1[index++] = nums1_copy[p1++];
            }
        }
    }
}