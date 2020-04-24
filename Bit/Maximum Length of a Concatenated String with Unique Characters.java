class Solution {
    public int dfs(List<String> arr,int index, int flag){
        if(index >= arr.size()){
            return 0;
        }
        int max = 0;
        for(int i = index; i < arr.size(); i++){
            int f = 0;
            String str = arr.get(i);
            //检测字符串本身是否有重复字符
            for(char c : str.toCharArray()){
                if((f & 1 <<(c - 'a')) != 0){
                    f = 0;
                    break;
                }
                f |= 1 <<(c - 'a');
            }
            //本身重复或与已经选择的串重复，跳过
            if(f == 0 || (flag & f) != 0) continue;
            //接着dfs
            max = Math.max(max,str.length() + dfs(arr,i + 1,flag | f));
        }
        return max;
    }
    public int maxLength(List<String> arr) {
        return dfs(arr,0,0);
    }
}