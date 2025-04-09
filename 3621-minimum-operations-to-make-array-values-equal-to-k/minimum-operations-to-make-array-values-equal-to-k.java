class Solution {
    public int minOperations(int[] nums, int k) {
        Arrays.sort(nums);
        if(k>nums[0]) return-1;
        int count = 0;
        for(int i = 1; i< nums.length; i++){
            if(nums[i]>nums[i-1]) count++;
        }
        if(k<nums[0]) count++;
        return count;

    }
}