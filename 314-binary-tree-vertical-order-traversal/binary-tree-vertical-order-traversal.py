# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def verticalOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        
        if not root:
            return []
        
        column_items = collections.defaultdict(list)
        queue = collections.deque([(0,root)])
        
        min_val = float(inf)
        max_val = float(-inf)
        
        res = []
        while queue:
            x, node = queue.popleft()
            column_items[x].append(node.val)
            
            min_val = min(min_val, x)
            max_val = max(max_val, x)
            
            if node.left:
                queue.append((x-1,node.left))
                
            if node.right:
                queue.append((x+1,node.right))
                
        
        for levels in range(min_val,max_val+1):
            res.append(column_items[levels])
            
        return res