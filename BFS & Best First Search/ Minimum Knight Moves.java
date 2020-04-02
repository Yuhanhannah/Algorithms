class Point{
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int minKnightMoves(int x, int y) {
        int[] deltaX = new int[]{1, 2, 2, 1, -1, -2, -2, -1};
        int[] deltaY = new int[]{2, 1, -1, -2, -2, -1, 1, 2};
        
        //move the target to the first coordinate
        if(x < 0) {
            x = -x;
        }
        if(y < 0) {
            y = -y;
        }
        
        //then do the traditional bfs
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0));
        Set<String> visited = new HashSet<>();
        visited.add("x" + 0 + "y" + 0);
        
        int count = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Point cur = queue.poll();
                if(cur.x == x && cur.y == y){
                    return count;
                }
                for(int j = 0; j < 8; j++){
                    Point adj = new Point(cur.x + deltaX[j], cur.y + deltaY[j]);
                    if(adj.x < -2 || adj.y < -2){
                        continue;
                    }
                    if(visited.contains("x" + adj.x + "y" + adj.y)){
                        continue;
                    }
                    queue.offer(adj);
                    visited.add("x" + adj.x + "y" + adj.y);
                }
            }
            count++;
        }
        return count;
    }
}