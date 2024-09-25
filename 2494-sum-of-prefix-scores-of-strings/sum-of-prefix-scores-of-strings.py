class TrieNode:
    def __init__(self):
        self.children = {}
        self.count = 0

    # Inserting a word into the Trie
    def insert(self, word):
        node = self  # Start from the root node (current instance)
        
        for char in word:
            if char not in node.children:
                node.children[char] = TrieNode()
            
            node = node.children[char]
            node.count += 1  # Increase the count at each node
    
    # Counting the prefix score for a given word
    def count_prefix(self, word):
        node = self  # Start from the root node (current instance)
        count = 0
        
        for char in word:
            if char in node.children:
                count += node.children[char].count
                node = node.children[char]
            else:
                break  # If a character in the word is not found in the Trie, stop
        
        return count


class Solution:
    def sumPrefixScores(self, words: List[str]) -> List[int]:
        trie = TrieNode()
        # Insert all words into the Trie
        for word in words:
            trie.insert(word)
        
        # Return the prefix scores for each word
        return [trie.count_prefix(word) for word in words]
