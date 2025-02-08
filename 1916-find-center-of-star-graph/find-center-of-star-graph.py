class Solution:
    def findCenter(self, edges: List[List[int]]) -> int:
        n=len(edges)+1
        temp=[0]*(n+1)

        for u,v in edges:
            temp[u]+=1
            temp[v]+=1
        
        for i in range(1,n+1):
            if temp[i]==n-1:
                return i
        
        