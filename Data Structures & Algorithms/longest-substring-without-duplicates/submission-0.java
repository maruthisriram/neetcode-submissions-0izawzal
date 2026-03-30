class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int l = 0, r = 0;
        HashSet<Character> seen = new HashSet<>();
        while(r < s.length()){
            char c = s.charAt(r);
            if(seen.contains(c)){
                while(seen.contains(c)){
                    seen.remove(s.charAt(l));
                    l++;
                }
            }
            seen.add(c);
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }
}
