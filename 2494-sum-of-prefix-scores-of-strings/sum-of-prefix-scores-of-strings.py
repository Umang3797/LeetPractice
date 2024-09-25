class TrieNode:
    def __init__(self):
        self.children={}
        self.count=0
        
class Trie:
    def __init__(self):
        self.trie = TrieNode()
        
    def insert(self,word):
        node=self.trie
        
        for char in word:
            if char not in node.children:
                node.children[char]=TrieNode()
            
            node=node.children[char]
            node.count+=1
    
    def count(self,word):
        node=self.trie
        count=0
        
        for char in word:
            count+=node.children[char].count
            node=node.children[char]
        
        return count

class Solution:
    def sumPrefixScores(self, words: List[str]) -> List[int]:
        trie = Trie()
        for word in words:
            trie.insert(word)
            
        return [trie.count(word) for word in words]
        