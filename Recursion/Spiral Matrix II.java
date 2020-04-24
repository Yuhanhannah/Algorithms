class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        dfs(result, 0, n, 1);
        return result;
    }
    private void dfs(int[][] result, int offSet, int size, int counter) {
        //base case
        if (size == 0) {
            return;
        }
        if (size == 1) {
            result[offSet][offSet] = counter;
            return;
        }
        //put top numbers
        for (int i = 0; i < size - 1; i++) {
            result[offSet][offSet + i] = counter++;
        }
        //right
        for (int i = 0; i < size - 1; i++) {
            result[offSet + i][offSet + size - 1] = counter++;
        }
        //bottom
        for (int i = size - 1; i > 0; i--) {
            result[offSet + size - 1][offSet + i] = counter++;
        }
        //left
        for(int i = size - 1; i > 0; i--){
            result[offSet + i][offSet] = counter++;
        }
        
        dfs(result, offSet + 1, size - 2, counter);
    }
    
}