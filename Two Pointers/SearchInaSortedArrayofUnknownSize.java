/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        //find right bount 
        int left = 0;
        int right = 1;
        while(reader.get(right) < target){
            left = right;
            right <<= 1;
        }
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(reader.get(mid) == target){
                return mid;
            }else if(reader.get(mid) < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }
}