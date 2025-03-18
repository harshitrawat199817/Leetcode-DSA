class Solution {
    public int longestNiceSubarray(int[] nums) {
        int[] ones = new int[32];
        int countGreaterThanOne = 0;
        int maxLength = 0;
        int length = 0;
        int start = 0;
        for(int i = 0; i< nums.length; i++){
            int currDigit = 0;
            int currNum = nums[i];
            while(currNum>0){
                if((currNum&1)==1) ones[currDigit]++;
                if(ones[currDigit]>1) countGreaterThanOne++;
                currDigit++;
                currNum = currNum>>1;
                
            }
            length++;
            while(countGreaterThanOne>0){
                int startNum = nums[start++];
                int startDigit = 0;
                while(startNum>0){
                if((startNum&1)==1) {
                    ones[startDigit]--;
                    if(ones[startDigit]==1) countGreaterThanOne--;
                }
                startDigit++;
                startNum = startNum>>1;
                
                }
                length--;
            }
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
    }
}