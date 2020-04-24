class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<Integer>> results = new ArrayList<>();
        if (n <= 0) {
            return null;
        }
        
        dfsPlaceQuene(n, 0, new ArrayList<>(), results);
        List<List<String>> graph = new ArrayList<>();
        drawResule(results, graph, n);
        System.out.println(results);
        return graph;
    }
    private void drawResule(List<List<Integer>> results, List<List<String>> graph, int n) {
        for (List<Integer> result : results) {
            List<String> curGraph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int curLevelPos = result.get(i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (j != curLevelPos) {
                        sb.append('.');
                    } else {
                        sb.append('Q');
                    }
                }
                curGraph.add(sb.toString());
            }
            graph.add(new ArrayList<>(curGraph));
        }
    }
    private void dfsPlaceQuene(int n, int index, List<Integer> current, List<List<Integer>> results) {
        if (current.size() == n) {
            results.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (cannPlaceQuene(current, i)) {
                current.add(i);
                dfsPlaceQuene(n, index + 1, current, results);
                current.remove(current.size() - 1);
            }
            
        }
    }
    
    private boolean cannPlaceQuene(List<Integer> quenes, int col) {
        int row = quenes.size();
        for (int i = 0; i < row; i++) {
            if (quenes.get(i) == col || Math.abs(quenes.get(i) - col) == row - i) {
                return false;
            }
        }
        return true;
    }
}