class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> anagrams = new HashMap<>();
        for(String s: strs){
            boolean found = false;
            String k = null;
            for(String key: anagrams.keySet()){
                if(isAnagram(s, key)){
                    k = key;
                    found = true;
                }
            }

            if(!found){
                anagrams.put(s, new ArrayList<>());
                anagrams.get(s).add(s);
            }else{
                anagrams.get(k).add(s);
            }

        }
        List<List<String>> res = new ArrayList<>();
        for(List<String> list:anagrams.values()){
            res.add(list);
        }
        return res;
    }

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
