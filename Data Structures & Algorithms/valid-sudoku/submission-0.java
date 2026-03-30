class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(char[] row:board){
            if(hasDuplicate(row)) return false;
        }
        char[][] transpose_sudoku = transpose(board);
        for(char[] row:transpose_sudoku){
            if(hasDuplicate(row)) return false;
        }
        for(int i=0;i<9;i+=3){
            for(int j=0;j<9;j+=3){
                char[] box = new char[9];
                int idx = 0;
                for(int k=i;k< (i + 3); k++){
                    for(int l = j; l < (j + 3);l++){
                        box[idx] = board[k][l];
                        idx++;
                    }
                }
                if(hasDuplicate(box)) return false;
            }
        }
        return true;
    }

    public boolean hasDuplicate(char[] nums) {
        HashMap<Character, Boolean> freq = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]=='.') continue;
            if(freq.getOrDefault(nums[i], false)) return true;
            freq.put(nums[i], true);
        }

        return false;
    }
    
    public static char[][] transpose(char[][] mat) {
        int n = mat.length;

        // Traverse the upper triangle of the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                // Swap elements across the diagonal
                char temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        return mat;
    }

}
