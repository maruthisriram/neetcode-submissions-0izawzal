class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> t_freq = new HashMap<>();
        for(char c:t.toCharArray()){
            t_freq.put(c, t_freq.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> sub_freq = new HashMap<>();
        int l = 0, len = Integer.MAX_VALUE, r = 0;
        int res_l = -1, res_r = -1;
        for(r = 0;r<s.length();r++){
            char c = s.charAt(r);
            sub_freq.put(c, sub_freq.getOrDefault(c, 0) + 1);
            if(match(t_freq, sub_freq)){
                while(match(t_freq, sub_freq)){
                    c = s.charAt(l);
                    sub_freq.put(c, sub_freq.getOrDefault(c, 0) - 1);
                    l++;
                }
                if(len > (r - l + 2)){
                    len = (r - l + 2);
                    res_l = l - 1;
                    res_r = r;
                }
            }
        }
        if(match(t_freq, sub_freq)){
                while(match(t_freq, sub_freq)){
                    char c = s.charAt(l);
                    sub_freq.put(c, sub_freq.getOrDefault(c, 0) - 1);
                    l++;
                }
                if(len > (r - l + 2)){
                    len = (r - l + 2);
                    res_l = l - 1;
                    res_r = r;
                }
            }

        if(res_l >=0 && res_r >= 0) return s.substring(res_l, res_r + 1);

        return "";
    }

    public boolean match(HashMap<Character,Integer> l, HashMap<Character, Integer> r){
        for(char c: l.keySet()){
            if(l.get(c)>r.getOrDefault(c, 0)) return false;
        }
        return true;
    }

    
}
