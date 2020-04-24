class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        dfs(matrix, result, 0, matrix.length, matrix[0].length);
        return result;
    }
    private void dfs(int[][] matrix, List<Integer> result, int offSet, int lengthM, int lengthN) {
        // M is row
        // N is col
        if (lengthM == 0 || lengthN == 0) {
            return;
        }
        if (lengthN == 1) {
            for (int i = 0; i < lengthM; i++) {
                result.add(matrix[offSet + i][offSet]);
              
            }
            return;
        }
        
        if (lengthM == 1) {
            for (int i = 0; i < lengthN; i++) {
                result.add(matrix[offSet][offSet + i]);
            }
            return;
        }
        
        //add top
        for (int i = 0; i < lengthN - 1; i++) {
            result.add(matrix[offSet][offSet + i]);
        }
        //add right
        for (int i = 0; i < lengthM - 1; i++) {
            result.add(matrix[offSet + i][offSet + lengthN - 1]);
        }
        //add bottom
        for (int i = lengthN - 1; i > 0; i--) {
            result.add(matrix[offSet + lengthM - 1][offSet + i]);
        }
        //add left
        for (int i = lengthM - 1; i > 0; i--) {
            result.add(matrix[offSet + i][offSet]);
        }
        dfs(matrix, result, offSet + 1, lengthM - 2, lengthN - 2);
    }
}