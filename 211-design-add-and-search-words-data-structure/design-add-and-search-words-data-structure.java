class TrieNode{
    boolean isEnd=false;
    TrieNode children[] = new TrieNode[26];
}

class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root=new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(node.children[c-'a']==null){
                node.children[c-'a'] = new TrieNode();
            }
            node = node.children[c-'a'];
        }
        node.isEnd=true;
    }
    
    public boolean search(String word) {
        TrieNode temp=root;
        return search(temp,0,word);
    }
    private boolean search(TrieNode temp, int index, String word){
        if(temp==null) return false;
        if(index==word.length()) return temp.isEnd;
        
        char c = word.charAt(index);
        if(c=='.'){
            for(int k=0;k<26;k++){
                if(search(temp.children[k],index+1,word))
                    return true;
            }
        }else{
            if(search(temp.children[c-'a'],index+1,word))
                return true;
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */