class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        UnionFind uf = new UnionFind(n);
        List<int[]> edges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int dist = Math.abs(points[i][0] - points[j][0]) +
                           Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[] {dist, i, j});
            }
        }

        edges.sort((a, b) -> Integer.compare(a[0], b[0]));
        int res = 0;
        for(int[] e: edges){
            if(uf.union(e[1], e[2])){
                res+=e[0];
            }
        }
        return res;
    }
}

class UnionFind{
    int n;
    int[] parent;

    public UnionFind(int n){
        this.n = n;
        this.parent = new int[n + 1];
        for(int i=0;i<=n;i++){
            parent[i] = i;
        }
    }

    public int find(int i){
        if(parent[i]==i){
            return i;
        }
        return find(parent[i]);
    }

    public boolean union(int a, int b){
        if(find(a)==find(b)){
            return false;
        }
        int p_a = find(a);
        int p_b = find(b);
        parent[p_b] = p_a;
        return true;
    }
}
