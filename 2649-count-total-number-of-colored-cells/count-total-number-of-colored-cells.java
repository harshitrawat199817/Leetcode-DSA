class Solution {
    public long coloredCells(int n) {
        long sum = 1;
        long pattern = 0;
        for(int i = 0; i<n; i++){
            sum+= pattern;
            pattern+=4;
        }
        return sum;
    }
}