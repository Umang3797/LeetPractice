from collections import defaultdict
class Solution:
    def validPath(self, n: int, edges: List[List[int]], source: int, destination: int) -> bool:

        if n==1 and source==destination:
            return True

        stack=[source]
        seen=set()
        seen.add(source)
        stack.append(source)
        
        D=defaultdict(list)
        for u,v in edges:
            D[u].append(v)
            D[v].append(u)
        
        while stack:
            node=stack.pop()
            if node==destination:
                return True
            
            for nei_node in D[node]:
                if nei_node not in seen:
                    seen.add(nei_node)
                    stack.append(nei_node)
        
        return False

        