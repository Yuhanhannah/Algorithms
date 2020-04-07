class Solution {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p1, p2) -> ( (p2[0] * p2[0] + p2[1] * p2[1]) - p1[0] * p1[0] + p1[1] * p1[1]));
        for(int[] point: points) {
            pq.offer(point);
        }
        int[][] result = new int[K][2];
        for(int i = 0; i < K; i++) {
            result[i] = pq.poll();
        }
        return result;
    }
                                                          
}