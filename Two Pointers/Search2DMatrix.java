class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0, right = row * col - 1;
        //left = 0, right = 11;
        //mid = 5
        //midRow = 5 / 4 = 1, midCol = 5 % 4 = 1
        while(left <= right){
            int mid = left + (right - left) / 2;
            int midRow = mid / col;
            int midCol = mid % col;
            if(matrix[midRow][midCol] == target){
                return true;
            }else if(matrix[midRow][midCol] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return false;
    }
}