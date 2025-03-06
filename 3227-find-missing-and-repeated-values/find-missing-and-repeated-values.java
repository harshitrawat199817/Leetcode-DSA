class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        Set<Integer> set = new HashSet<>();
        int occuredTwice = 0;
        int missing = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(!set.contains(grid[i][j])) set.add(grid[i][j]);
                else occuredTwice = grid[i][j];
            }
        }
        for(int i = 0; i< grid.length*grid.length; i++){
            if(!set.contains(i+1)){
                missing = i+1;
                break;
            }
        }
        return new int[]{occuredTwice,missing };
    }
}