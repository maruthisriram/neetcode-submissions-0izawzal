class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = m * n - 1;
        while(l <= r){
            int h = (l + r)/2;
            int row = h / n, col = h % n;
            if(matrix[row][col]==target) return true;
            else if(matrix[row][col] < target) l = h + 1;
            else r = h - 1;
        }
        return false;
    }
}
