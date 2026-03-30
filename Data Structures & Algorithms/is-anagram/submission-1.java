class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freq = new int[26];
        for(char c: s.toCharArray()){
            freq[c - 'a'] += 1;
        }
        for(char c: t.toCharArray()){
            freq[c - 'a'] -= 1;
        }

        for(int f:freq){
            if(f != 0) return false;
        }
        return true;
        
    }
}
