class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        Queue<Pair<String, Integer>> q = new LinkedList<>();
        List<String> visited = new ArrayList<>();
        q.add(new Pair<>(beginWord, 1));
        int res = Integer.MAX_VALUE;
        while(!q.isEmpty()) {
            Pair<String, Integer> top  = q.poll();
            String word = top.getKey();
            int num = top.getValue();
            // System.out.println(word + " " + num);
            visited.add(word);
            for(String next: wordList) {
                if(!visited.contains(next) && isValid(next, word)){
                    if(next.contentEquals(endWord)) {
                        res = Math.min(res, num + 1);
                    }else{
                        q.add(new Pair<>(next, num + 1));
                    }
                }
            }
        }
        return res == Integer.MAX_VALUE?0:res;
    }

    public boolean isValid(String a, String b) {
        if(a.length()!=b.length()) return false;
        int count = 0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)) count+=1;
        }
        // System.out.println(count);
        return count == 1;
    }
}
