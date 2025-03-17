class Solution {
    public boolean divideArray(int[] nums) {
        boolean[] validate = new boolean[501];
        for(int num : nums){
            if(validate[num]){
                validate[num] = false;
            }
            else validate[num] = true;
        }
        boolean hasPair = true;
        for(boolean notPair : validate){
            if(notPair) return false;
        }
        return hasPair;
    }
}