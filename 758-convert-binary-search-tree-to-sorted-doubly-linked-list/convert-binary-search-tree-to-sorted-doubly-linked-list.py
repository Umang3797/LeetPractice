"""
# Definition for a Node.
class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
"""

class Solution:
    def __init__(self):
        self.head = None  
        self.prev = None
    def treeToDoublyList(self, root: 'Optional[Node]') -> 'Optional[Node]':
        # Edge case: If the tree is empty, return None
        if not root:
            return None
        
        # Begin the in-order traversal to convert the BST
        self.in_order_traversal(root)
        
        # Make the doubly linked list circular
        self.prev.right = self.head  
        self.head.left = self.prev
        
        return self.head
    
    
    def in_order_traversal(self, node: 'Optional[Node]'):
        if not node:
            return

        # Step 1: Recursively process the left subtree
        self.in_order_traversal(node.left)

        # Step 2: Process the current node
        if self.prev:
            # If prev node exists, set its right pointer to the current node
            self.prev.right = node
            # Link the current node's left pointer back to prev
            node.left = self.prev
        else:
            # If prev is None, we are at the smallest element, so set as the head
            self.head = node

        # Move the last pointer to the current node
        self.prev = node

        # Step 3: Recursively process the right subtree
        self.in_order_traversal(node.right)
 