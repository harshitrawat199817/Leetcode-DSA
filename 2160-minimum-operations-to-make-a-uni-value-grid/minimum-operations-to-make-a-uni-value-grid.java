class Solution {
    public int minOperations(int[][] grid, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i< grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                pq.add(grid[i][j]);
            }
        }
        int medianPos = (1+pq.size())/2;
        int median = -1;
        while(medianPos>0){
            median = pq.remove();
            medianPos--;
        }
        int count = 0;
        for(int i = 0; i< grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                int ops = grid[i][j]> median? (grid[i][j]-median): (median-grid[i][j]);
                if(ops%x==0)
                count+= ops/x;
                else return -1;
            }
        }
        return count;
    }
}