class Solution {
    public boolean res = false;
    public boolean exist(char[][] board, String word) {
        for(int i = 0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                backTrack(board, word, new StringBuilder(), i, j, 0);
            }
        }
        return res;
    }

    public void backTrack(char[][] board, String word, StringBuilder currentWord, int row, int col, int currentIndex) {
        if(currentIndex == word.length()){
                res = true;
                return;
        }
    if(row >=0 && row < board.length && col >= 0 && col < board[0].length ){
            if(board[row][col]!='0' && board[row][col] == word.charAt(currentIndex)){
                char c = board[row][col];
                currentWord.append(c);
                board[row][col] = '0';
                backTrack(board, word, currentWord, row + 1, col, currentIndex+1);
                backTrack(board, word, currentWord, row, col + 1, currentIndex+1);
                backTrack(board, word, currentWord, row - 1, col, currentIndex+1);
                backTrack(board, word, currentWord, row, col - 1, currentIndex+1);
                currentWord.deleteCharAt(currentWord.length() - 1);
                board[row][col] = c;
            }
            
        }
    }
}
