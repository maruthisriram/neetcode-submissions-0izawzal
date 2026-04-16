class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        backTrack(n, n, new ArrayList<>());
        return res;
    }

    public void backTrack(int len, int n, List<String> currentCombo){
        if(n==0){
            res.add(new ArrayList<>(currentCombo));
            return;
        }
        StringBuilder currentPosition = new StringBuilder();
        for(int i=0;i<len;i++){
            currentPosition.append(".");
        }
        for(int i=0;i<len;i++){
            currentPosition.setCharAt(i, 'Q');
            if(isValid(len, currentCombo, currentPosition.toString(), i)){
                currentCombo.add(currentPosition.toString());
                backTrack(len, n - 1, currentCombo);
                currentCombo.remove(currentCombo.size() - 1);
            }
            currentPosition.setCharAt(i, '.');
        }
    }

    private boolean isValid(int n, List<String> combo, String currentPos, int colIndex){
        int curRow = combo.size();
        for(int i=0;i<combo.size();i++){
            int index = combo.get(i).indexOf("Q");
            if(index==colIndex){
                return false;
            }
            if((curRow - i) == Math.abs((colIndex - index))){
                return false;
            }
        }
        return true;
    }
}
