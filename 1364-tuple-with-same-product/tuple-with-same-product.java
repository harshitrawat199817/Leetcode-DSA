class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int tuplesCount = 0;
        for(int i = 0; i< nums.length; i++){
            for(int j = i+1; j< nums.length; j++){
                int prod = nums[i]*nums[j];
                int freq = map.getOrDefault(prod, 0);
                map.put(prod, freq+1);
            }
        }
        for(int key : map.keySet()){
            int freq = map.get(key);
            tuplesCount += (freq-1)*freq*4;
        }
        // System.out.print(map);
        return tuplesCount;
    }
}