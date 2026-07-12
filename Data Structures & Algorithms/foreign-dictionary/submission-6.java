class Solution {
    public String foreignDictionary(String[] words) {
      HashMap<Character, List<Character>> g = new HashMap<>();
      HashMap<Character, Integer> indegree = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                g.putIfAbsent(c, new ArrayList<>());
                indegree.putIfAbsent(c, 0);
            }
        }
        
        for(int i=0;i<words.length - 1;i++){
            String w1 = words[i];
            String w2 = words[i + 1];
            if (w1.length() > w2.length() && w1.startsWith(w2)) {
                return "";
            }
            for(int j=0;j<Math.min(w1.length(), w2.length());j++){
                if(w1.charAt(j)!=w2.charAt(j)){
                    char c1 = w1.charAt(j);
                    char c2 = w2.charAt(j);
                    if(!g.containsKey(c1)){
                        g.put(c1, new ArrayList<>());
                    }
                    if(!g.get(c1).contains(c2)){
                        if(g.containsKey(c2)){
                            if(g.get(c2).contains(c1)){
                                return "";
                            }
                        }
                        g.get(c1).add(c2);
                        indegree.put(c2, indegree.getOrDefault(c2, 0) + 1);
                        if(!indegree.containsKey(c1)){
                            indegree.put(c1, 0);
                        }
                    }
                break;
                }
            }
        }
    //   for(char c: g.keySet()){
    //     System.out.println(c + " " + g.get(c).toString());
    //   }
      StringBuilder sb = new StringBuilder();
      Queue<Character> q = new LinkedList<>();
      for(char c:indegree.keySet()){
        // System.out.println(c + " " + indegree.get(c));
        if(indegree.get(c)==0){
            q.add(c);
        }
      }
      while(!q.isEmpty()){
        char top = q.poll();
        sb.append(top);
        if(g.containsKey(top)){
            for(char c:g.get(top)){
                indegree.put(c, indegree.getOrDefault(c, 0) - 1);
                if(indegree.get(c)==0){
                    q.add(c);
                }
            }
        }
      }
      if (sb.length() < indegree.size()) {
        return "";
    }
      return sb.toString();

    }

    private boolean hasCycle(HashMap<Character, List<Character>> g, char start, char target, Set<Character> visited) {
        if (start == target) return true;
        if (!g.containsKey(start) || visited.contains(start)) return false;
        
        visited.add(start);
        for (char neighbor : g.get(start)) {
            if (hasCycle(g, neighbor, target, visited)) {
                return true;
            }
        }
        return false;
    }
}
