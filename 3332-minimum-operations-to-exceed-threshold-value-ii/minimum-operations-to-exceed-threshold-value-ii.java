class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> numbersSmallerThanK = new PriorityQueue<>();
        int numberOfOperations = 0;
        for(int numsIndex = 0; numsIndex <nums.length; numsIndex++){
            if(nums[numsIndex]<k) numbersSmallerThanK.add((long)(nums[numsIndex]));
        }
        while(!(numbersSmallerThanK.size()<2)){
            long x = numbersSmallerThanK.remove();
            long y = numbersSmallerThanK.remove();
            long z = x*2+y;
            numberOfOperations++;
            if(z<k)
            numbersSmallerThanK.add(z);
            
        }
        return numberOfOperations+ numbersSmallerThanK.size();
    }
}