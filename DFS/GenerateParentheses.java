class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(n, 0, 0, sb, result);
        return result;
    }
    private void dfs(int n, int left, int right, StringBuilder sb, List<String> result){
        //base case
        if(left + right == 2 * n) {
            result.add(sb.toString());
        }
        if(left < n) {
            sb.append('(');
            dfs(n, left + 1, right, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
        
        if(left > right) {
            sb.append(')');
            dfs(n, left, right + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
        
    }
}