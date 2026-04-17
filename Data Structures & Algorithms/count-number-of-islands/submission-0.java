class Solution {
    int res = 0;
    public int numIslands(char[][] grid) {
        Stack<int[]> stack = new Stack<>();
        for(int i=0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j]!='0'){
                    stack.push(new int[]{i, j});
                    while(!stack.isEmpty()){
                        int[] top = stack.pop();
                        int x = top[0];
                        int y = top[1];
                        grid[x][y] = '0';
                        if((x - 1) >= 0 && grid[x - 1][y]!='0') {
                            stack.push(new int[]{x-1, y});
                        }
                        
                        if((y - 1) >= 0 && grid[x][y - 1]!='0') {
                            stack.push(new int[]{x, y - 1});
                        }
                        
                        if((x + 1) < grid.length && grid[x + 1][y]!='0') {
                            stack.push(new int[]{x+1, y});
                        }
                        
                        if((y + 1) < grid[0].length && grid[x][y + 1]!='0') {
                            stack.push(new int[]{x, y + 1});
                        }
                    }
                    res++;
                }
            }
        }
        return res;
    }



}
