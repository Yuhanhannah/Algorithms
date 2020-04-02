class Solution {
    public int orangesRotting(int[][] grid) {
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    count++;
                }
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i, j});
                }
            }
        }
        
        int[] deltaX = new int[]{-1, 0, 0, 1};
        int[] deltaY = new int[]{0, -1, 1, 0};
        int depth = 0;
        while(count > 0 && !queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for(int j = 0; j < size; j++) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                
                for(int i = 0; i < 4; i++) {
                    int[] adj = new int[]{x + deltaX[i], y + deltaY[i]};
                    int adjx = adj[0];
                    int adjy = adj[1];
                    if(adjx < 0 || adjx >= grid.length || adjy < 0 || adjy >= grid[0].length){
                        continue;
                    }
                    if(grid[adjx][adjy] == 1){
                        count--;
                        grid[adjx][adjy] = 2;
                        queue.offer(adj);
                    }
                }
            }
        }
        if(count > 0){
            return -1;
        }
        return depth;
    }
}