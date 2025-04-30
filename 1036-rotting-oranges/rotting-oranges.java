class Solution {
    public int orangesRotting(int[][] grid) {
        int minutes = 0;
        int[][] dirs = new int[][]{{-1,0}, {0,-1}, {1,0},{0,1}};
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i< grid.length; i++){
            for(int j = 0; j< grid[0].length; j++){
                if(grid[i][j]==2) queue.add(new int[]{i,j});
            }
        }
        queue.add(null);
        while(!queue.isEmpty()){
            int[] coords = queue.remove();
            if(coords==null){
                if(!queue.isEmpty()){
                    minutes++;
                    queue.add(null);
                }
            }
            else{
            int x = coords[0];
            int y = coords[1];
            for(int dir = 0; dir<4; dir++){
                int xNew = x+dirs[dir][0];
                int yNew = y+dirs[dir][1];
                if(xNew>=0 && xNew<grid.length && yNew>=0 && yNew <grid[0].length){
                    if(grid[xNew][yNew]==1){
                        grid[xNew][yNew] = 2;
                        queue.add(new int[]{xNew, yNew});
                    }
                }
            }
            }

        }
        for(int i = 0; i< grid.length; i++){
            for(int j = 0; j< grid[0].length; j++){
                if(grid[i][j]==1) return -1;
            }
        }
        return minutes;
    }
    
}