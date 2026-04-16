class PrefixTree {
    TrieNode[] nodes = new TrieNode[26];
    public PrefixTree() {
         
    }

    public void insert(String word) {
        TrieNode[] currentRow = nodes;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            TrieNode node = null;
            if(currentRow[c - 'a']==null){
                node = new TrieNode();
                node.c = c;
                node.children = new TrieNode[26];    
                currentRow[c - 'a'] = node;
            }else{
                node = currentRow[c - 'a'];
            }
            if(i == word.length() - 1) {
                node.isWord = true;
            }
            currentRow = node.children;
        }
    }

    public boolean search(String word) {
        TrieNode[] currentRow = nodes;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            TrieNode node = null;
            if(currentRow[c - 'a']==null){
                return false;
            }else{
                node = currentRow[c - 'a'];
            }
            if(i == word.length() - 1) {
                return node.isWord;
            }
            currentRow = node.children;
        }
        return true;
    }

    public boolean startsWith(String word) {
        TrieNode[] currentRow = nodes;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            TrieNode node = null;
            if(currentRow[c - 'a']==null){
                return false;
            }else{
                node = currentRow[c - 'a'];
            }
            currentRow = node.children;
        }
        return true;
    }
}

class TrieNode {
    public char c;
    public TrieNode[] children;
    public boolean isWord;
}