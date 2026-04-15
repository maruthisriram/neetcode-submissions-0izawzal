class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backTrack(s, 0, "", new ArrayList<>());
        return res;
    }

    public void backTrack(String s, int i, String currentSub, List<String> path) {
        if (i == s.length()) {
            if (currentSub.isEmpty()) {
                res.add(new ArrayList<>(path));
            }
            return;
        }

        backTrack(s, i + 1, currentSub + s.charAt(i), path);

        String potentialPal = currentSub + s.charAt(i);
        if (isPalindrome(potentialPal)) {
            path.add(potentialPal);
            backTrack(s, i + 1, "", path); 
            path.remove(path.size() - 1);  
        }
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}
