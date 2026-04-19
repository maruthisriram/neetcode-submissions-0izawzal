class Solution {
    public void solve(char[][] board) {
        List<int[]> island = new ArrayList<>();
        List<List<int[]>> invalidIslands = new ArrayList<>();
        Stack<int[]> stack = new Stack<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='O'){
                    stack.add(new int[]{i, j});
                    while(!stack.isEmpty()){
                        int[] top = stack.pop();
                        island.add(top);
                        int x = top[0], y = top[1];
                        board[x][y] = 'X';
                        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
                        for (int[] dir : dirs) {
                            int nx = x + dir[0];
                            int ny = y + dir[1];       
                            if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length  && board[nx][ny]!='X') {
                                stack.add(new int[]{nx, ny});
                            }
                        }
                    }
                    boolean valid = true;
                   
                    for(int[] cell:island){
                        int x = cell[0], y = cell[1];
                        if (x >= 1 && x < (board.length - 1) && y >= 1 && y < (board[0].length - 1)) {
                                continue;
                        }else{
                            valid = false;
                        }
                    }
                    if(!valid){
                        invalidIslands.add(island);
                    }
                    island = new ArrayList<>();
                }
            }
        }

        for(List<int[]> invalid:invalidIslands){
            for(int[] cell:invalid){
                board[cell[0]][cell[1]] = 'O';
            }
        }
    }
}
