class Solution {
    public long coloredCells(int n) {
        
        // long sum = 1;
        // long pattern = 0;
        // for(int i = 0; i<n; i++){
        //     sum+= pattern;
        //     pattern+=4;
        // }
        // return sum;
        // a + d+ 2d+ 3d+ 4d .....== n(n-1)d/2 = 
        return 1+(long)2*(n)*(n-1);
    }
}