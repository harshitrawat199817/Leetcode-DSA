class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int count = 0;
        // int start = 0;
        int length = 0;
        for(int i = 0; i<= colors.length+ k-2; i++){
            if(i==0 || colors[i%colors.length]!=colors[(i-1)%colors.length]) length++;
            else{
                length = 1;
            }
            if(length>=k)  count++;
        }
        return count;
    }
}