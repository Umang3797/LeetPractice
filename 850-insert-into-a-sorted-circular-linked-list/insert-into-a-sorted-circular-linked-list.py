"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, next=None):
        self.val = val
        self.next = next
"""

class Solution:
    def insert(self, head: 'Optional[Node]', insertVal: int) -> 'Node':
        newNode = Node(insertVal)
        
        if not head:
            newNode.next = newNode
            return newNode
        
        prev, curr = head, head.next
        inserted = False
        
        while True:
            # Case 1: in between two ordered nodes
            if prev.val <= insertVal <= curr.val:
                inserted = True
            # Case 2: at the pivot point (max to min wrap-around)
            elif prev.val > curr.val:
                if insertVal >= prev.val or insertVal <= curr.val:
                    inserted = True
            
            if inserted:
                prev.next = newNode
                newNode.next = curr
                return head
            
            prev, curr = curr, curr.next
            
            if prev == head:
                # made a full circle, insert anywhere
                break
        
        # if no place found, means identical list
        prev.next = newNode
        newNode.next = curr
        return head
