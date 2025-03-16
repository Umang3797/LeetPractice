class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        adjList=defaultdict(list)

        ans=[]
        courses=prerequisites
        
        for course in courses:
            adjList[course[0]].append(course[1])
            
        UNVISITED=0
        VISITING=1
        VISITED=2
            
        states=[0]*numCourses
        
        def dfs(node):
            state=states[node]
            
            if state==VISITED:
                return True
            
            elif state==VISITING:
                return False
            
            states[node]=VISITING
            
            for nei in adjList[node]:
                if not dfs(nei):
                    return False
            
            states[node]=VISITED
            ans.append(node)
            return True
        
        for i in range(numCourses):
            if not dfs(i):
                return []
        
        return ans