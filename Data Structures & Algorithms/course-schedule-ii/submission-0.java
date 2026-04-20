class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        int[] res = new int[numCourses];
        int index = 0;
        int[] indegree = new int[numCourses];
        for(int[] p:prerequisites) {
            if(!graph.containsKey(p[1])) {
                graph.put(p[1], new ArrayList<>());
            }
            graph.get(p[1]).add(p[0]);
            indegree[p[0]] += 1;
        }

        Queue<Integer> q = new LinkedList<>();
        int total_courses = 0;
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0) q.add(i);
        }

        while(!q.isEmpty()) {
            int top = q.poll();
            total_courses++;
            res[index] = top;
            index++;
            if(graph.containsKey(top)){
                for(int next:graph.get(top)) {
                    indegree[next]--;
                    if(indegree[next]==0){
                        q.add(next);
                    }
                }
            }
        }

        if(total_courses!=numCourses) return new int[0];
        return res;
    }
}
