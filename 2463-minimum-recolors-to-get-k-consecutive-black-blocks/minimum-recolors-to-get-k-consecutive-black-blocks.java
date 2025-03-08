class Solution {
    public int minimumRecolors(String blocks, int k) {
        int countW = 0;
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        while (end < k) {
            if (blocks.charAt(end) == 'W')
                countW++;
            end++;
        }
        min = Math.min(min, countW);
        while (end < blocks.length()) {
            
            if (start > -1 && blocks.charAt(start) == 'W')
                countW--;
            if (blocks.charAt(end) == 'W')
                countW++;
            min = Math.min(min, countW);
            start++;
            end++;

        }
        return min;
    }
}