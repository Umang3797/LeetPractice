from collections import deque

class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        n = len(grid)
        
        # talk: start or end blocked
        if grid[0][0] != 0 or grid[n-1][n-1] != 0:
            return -1
        
        # 8 directions
        directions = [(-1,-1), (-1,0), (-1,1),
                    (0,-1),         (0,1),
                    (1,-1), (1,0),  (1,1)]
        
        # queue for BFS with (row, col, path length)
        queue = deque()
        queue.append( (0,0,1) )
        
        # mark visited
        grid[0][0] = 1
        
        while queue:
            row, col, length = queue.popleft()
            
            # talk: reached target
            if row == n-1 and col == n-1:
                return length
            
            # explore 8 neighbors
            for dr, dc in directions:
                r, c = row + dr, col + dc
                if 0 <= r < n and 0 <= c < n and grid[r][c] == 0:
                    queue.append( (r, c, length+1) )
                    grid[r][c] = 1  # mark visited
                    
        return -1

            