class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        //int[]{x,y}
        Queue<int[]> q = new LinkedList();
        //q.add(entrance);
        q.add(new int[]{entrance[0], entrance[1]});


        //4 directions
        int[][] dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};

        //visited
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        visited[entrance[0]][entrance[1]]= true;

        int level=0;

        while(!q.isEmpty()){
            level++;
            int size=q.size();
            while(size-->0){
                int[] coordinates = q.poll();
                for(int i=0;i<4;i++){
                    int[] dir = dirs[i];
                    int newR= coordinates[0]+dir[0];
                    int newC= coordinates[1]+dir[1];

                    //within limit
                    if(newR>=0 && newC>=0 && newR<maze.length && newC<maze[0].length && maze[newR][newC]=='.' && !visited[newR][newC]){
                        //boundary condition
                        if(newR==0 || newC==0 || newR==maze.length-1 || newC==maze[0].length-1){
                            return level;
                        }
                        visited[newR][newC]=true;
                        q.add(new int[]{newR, newC});
                    }
                }
            }
        }
    return -1;
    }
}