class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length!= (n - 1)) return false;
        boolean[] visited = new boolean[n];
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge:edges){
            if(!graph.containsKey(edge[0])) {
                graph.put(edge[0], new ArrayList<>());
            }
            graph.get(edge[0]).add(edge[1]);
            
            if(!graph.containsKey(edge[1])) {
                graph.put(edge[1], new ArrayList<>());
            }
            graph.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()) {
            int top = q.poll();
            visited[top] = true;
            if(graph.containsKey(top)) {
                for(int next:graph.get(top)) {
                    if(!visited[next]) {
                        q.add(next);
                    }
                }
            }
        }

        for(boolean v:visited) {
            if(!v) return false;
        }
        return true;
    }
}
