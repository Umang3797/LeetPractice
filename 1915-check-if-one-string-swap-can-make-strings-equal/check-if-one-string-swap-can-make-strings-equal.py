class Solution:
    def areAlmostEqual(self, s1: str, s2: str) -> bool:
        n=len(s1)

        if s1==s2:
            return True
            
        pos=[]

        unequal=0

        for i in range(n):
            if s1[i]!=s2[i]:
                unequal+=1
                pos.append(i)
                
            if unequal>2:
                return False
            
        return unequal==2 and s1[pos[0]]==s2[pos[1]] and s2[pos[0]]==s1[pos[1]]
            
        