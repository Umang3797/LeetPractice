class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord))
            return 0;
        
        Map<String, Boolean> map = new HashMap();
        for(int i=0;i<wordList.size();i++){
            map.put(wordList.get(i), false);
        }
        
        int length=1;
        Queue<String> q = new LinkedList();
        q.add(beginWord);
        map.put(beginWord,true);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                String currentWord=q.poll();
                if(currentWord.equals(endWord)){
                    return length;
                }
                wordmatch(currentWord,map,q);
            }
            length++;
        }
        return 0;
    }
    
    private void wordmatch(String currentWord, Map<String, Boolean> map, Queue<String> q){
        for(int i=0;i<currentWord.length();i++){
            char[] word = currentWord.toCharArray();
            for(int j=0;j<26;j++){
                char c = (char)('a'+j);
                word[i] = c;
                String newWord = String.valueOf(word);
                if(map.containsKey(newWord) && map.get(newWord)==false){
                    q.add(newWord);
                    map.put(newWord,true);
                }
            }
        }
    }
}