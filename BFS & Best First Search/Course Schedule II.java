class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        HashMap<Integer, List<Integer>> mapping = new HashMap<>();
        
        //initialize indegree and mapping
        for(int i = 0; i < numCourses; i++) {
            indegree[i] = 0;
            mapping.put(i, new ArrayList<>());
        }
        //get all indegrees
        for(int i = 0; i < prerequisites.length; i++) {
            int prev = prerequisites[i][1];
            int next = prerequisites[i][0];
            indegree[next]++;
            mapping.get(prev).add(next);
        }
        Queue<Integer> queue = new LinkedList<>();
        
        //put all indegree = 0 in to queue
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        
        int count = 0;
        int[] result = new int[numCourses];
        
        while(!queue.isEmpty()){
            int cur = queue.poll();
            result[count++] = cur;
            int size = mapping.get(cur).size();
            for(int i = 0; i < size; i++){
                int nextCourse = mapping.get(cur).get(i);
                indegree[nextCourse]--;
                if(indegree[nextCourse] == 0){
                    queue.offer(nextCourse);
                }
            }
        }

        if(count == numCourses){
            return result;
        }
        return new int[0];
    }
}