class Solution {
    HashMap<Character, String> digit_map = new HashMap<>();
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0 || digits == null) return res;
        digit_map.put('2', "abc");
        digit_map.put('3', "def");
        digit_map.put('4', "ghi");
        digit_map.put('5', "jkl");
        digit_map.put('6', "mno");
        digit_map.put('7', "pqrs");
        digit_map.put('8', "tuv");
        digit_map.put('9', "wxyz");
        digit_map.put('0', "+");
        backTrack("", digits, 0);
        return res;
    }
    public void backTrack(String currentString, String digits, int currentIndex){
        if(currentIndex==digits.length()){
            res.add(currentString);
        }else if(currentIndex < digits.length()){
            String char_String = digit_map.get(digits.charAt(currentIndex));
            for(char c: char_String.toCharArray()){
                backTrack(currentString + c, digits, currentIndex + 1);
            }
        }else{
            return;
        }
    }


}
