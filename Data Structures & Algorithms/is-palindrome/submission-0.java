class Solution {
    public boolean isPalindrome(String s) {
        String s_without_spaces = s.replaceAll("[^a-zA-Z0-9]", "");
        System.out.println(s_without_spaces);
         StringBuilder stringBuilder = new StringBuilder(s_without_spaces);
        stringBuilder.reverse();
        String s_reverse = stringBuilder.toString();
        return s_reverse.equalsIgnoreCase(s_without_spaces);
    }
}

