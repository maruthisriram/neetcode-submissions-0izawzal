class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> freq = new HashMap<>();
        int l = 0;
        int maxFreq = 0, res = 0, len = 0;
        for(int r = 0;r<s.length();r++){
            char c = s.charAt(r);
            len = r - l + 1;
            freq.put(c, freq.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, freq.get(c));
            if((len - maxFreq)<=k) {
                res = Math.max(res, len);
            }else{
                while((r - l + 1) - maxFreq > k){
                    c = s.charAt(l);
                    freq.put(c, freq.getOrDefault(c, 0) - 1);
                    l++;
                }
                res = Math.max(res, r - l + 1);
            }
        }
        return res;
    }
}
