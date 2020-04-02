class Point{
    int x;
    int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    bfs(grid, i, j);
                    count++;
                }
            }
        }
        
        return count;
    }
    private void bfs(char[][] grid, int x, int y){
        int[] deltaX = {-1, 0, 0, 1};
        int[] deltaY = {0, -1, 1, 0};
        
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        grid[x][y] = '0';
        
        while(!q.isEmpty()){
            Point cur = q.poll();
            //iterate its four directions, and add all 1 to queue
            for(int i = 0; i < 4; i++){
                Point adj = new Point(cur.x + deltaX[i], cur.y + deltaY[i]);
                if(!inBound(grid, adj.x, adj.y) || grid[adj.x][adj.y] == '0'){
                    continue;
                }
                q.offer(adj);
                grid[adj.x][adj.y] = '0';
            }
        }
    }
    private boolean inBound(char[][] grid, int x, int y){
        return (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length);
    }
}