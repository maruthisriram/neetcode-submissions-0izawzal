class WordDictionary {
    TrieNode[] nodes = new TrieNode[26];

    public WordDictionary() {

    }

    public void addWord(String word) {
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

    public boolean search(String word, int index, TrieNode[] currentRow) {
        char c = word.charAt(index);
        boolean result = false;
        if(c=='.'){
            for(TrieNode node:currentRow) {
                if(node!=null){
                    if(index==word.length() - 1){
                        return node.isWord;
                    }
                    result = search(word, index + 1, node.children);
                    if(result){
                        break;
                    }
                }
            }
        }
        if(c!='.'){
            if(currentRow[c - 'a']==null){
                return false;
            }else{
                if(index==word.length() - 1){
                    return currentRow[c - 'a'].isWord;
                }
                result = search(word, index + 1, currentRow[c - 'a'].children);
            
            }
        }
        return result;
    }

    public boolean search(String word) {
        return search(word, 0, nodes);
    }
}


class TrieNode {
    public char c;
    public TrieNode[] children;
    public boolean isWord;
}