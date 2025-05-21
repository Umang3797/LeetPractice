class Solution {
    public class TrieNode{
        public boolean isWord=false;
        public TrieNode[] child = new TrieNode[26];
        //public TrieNode(){}
    }
    TrieNode root=new TrieNode();
    boolean[][] visitFlag;
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList();
        visitFlag=new boolean[board.length][board[0].length];
        
        addToTrie(words);
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(root.child[board[i][j]-'a']!=null){
                    search(board,i,j,root,"",ans);
                }
            }
        }
        
        return ans;
    }
    public void addToTrie(String[] words){
        for(String word:words){
            TrieNode node=root;
            for(int i=0;i<word.length();i++){
                char ch=word.charAt(i);
                if(node.child[ch-'a']==null){
                    node.child[ch-'a']= new TrieNode();
                }
                node=node.child[ch-'a'];
            }
            node.isWord=true;
        }
    }
    public void search(char[][]board, int i, int j, TrieNode node, String word, List<String> ans){
        if(i<0 || i>=board.length ||
          j<0 || j>=board[0].length ||
          visitFlag[i][j] || 
          node.child[board[i][j]-'a']==null) return;
        
        visitFlag[i][j]=true;
        node=node.child[board[i][j]-'a'];
        if(node.isWord){
            ans.add(word+board[i][j]);
            node.isWord = false;    // Mark word as found to avoid duplicates
        }
        
        //dfs search in 4 directions
        search(board,i+1,j,node,word+board[i][j],ans);
        search(board,i-1,j,node,word+board[i][j],ans);
        search(board,i,j+1,node,word+board[i][j],ans);
        search(board,i,j-1,node,word+board[i][j],ans);
        
        visitFlag[i][j]=false;

    }
}