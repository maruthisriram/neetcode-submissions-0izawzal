class Solution {
    public int swimInWater(int[][] grid) {
        int currentTime = 0;
        int[][] minHeight = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                minHeight[i][j] = Integer.MAX_VALUE;
            }
        }
        Queue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        q.add(new int[]{grid[0][0], 0, 0});
        minHeight[0][0] = grid[0][0];
        int m = grid.length;
        int n = grid[0].length;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int currHeight = curr[0];
            int x = curr[1];
            int y = curr[2];
            if (x == m - 1 && y == n - 1) {
                return currHeight;
            }
            int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            for(int[] dir:dirs){
                int new_x = dir[0] + x;
                int new_y = dir[1] + y;
                if(new_x>=0 && new_x<m && new_y>=0 && new_y<n){
                    int maxHeight = Math.max(grid[new_x][new_y], currHeight);

                    if(minHeight[new_x][new_y] > maxHeight){
                        minHeight[new_x][new_y] = maxHeight;
                        q.add(new int[]{maxHeight, new_x, new_y});
                    }
                }
            }
        }
        return minHeight[m-1][n-1];
    }
}
