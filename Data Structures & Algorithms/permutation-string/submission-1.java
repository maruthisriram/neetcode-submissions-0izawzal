class Solution {
    public boolean checkInclusion(String s1, String s2) {
        s1 = IntStream.range(0, s1.length()) // Create an IntStream of indices
            .mapToObj(s1::charAt)                          // Map indices to characters
            .sorted()                                         // Sort characters in natural order
            .map(String::valueOf)                             // Map characters back to strings
            .collect(Collectors.joining());
        
        int k = s1.length();
        for(int i=0;i<(s2.length() - k + 1);i++){
            String s2_sub = s2.substring(i, i + k);
            if(match(s1, s2_sub)) return true;
        }

        return false;
        
    }

    public boolean match(String s1, String s2) {
        s2 = IntStream.range(0, s2.length()) // Create an IntStream of indices
            .mapToObj(s2::charAt)                          // Map indices to characters
            .sorted()                                         // Sort characters in natural order
            .map(String::valueOf)                             // Map characters back to strings
            .collect(Collectors.joining());
        
            return s1.contentEquals(s2);
    }
}
