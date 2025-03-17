class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i=0; i<nums1.length; i++){
            int value = map.getOrDefault(nums1[i][0], 0);
            map.put(nums1[i][0], value+nums1[i][1]);
        }
        for(int i=0; i<nums2.length; i++){
            int value = map.getOrDefault(nums2[i][0], 0);
            map.put(nums2[i][0], value+nums2[i][1]);
        }
        int[][] ans = new int[map.size()][2];
        int i = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            ans[i][0] = entry.getKey();
            ans[i][1] = entry.getValue();
            i++;
        }

        return ans;
    }
}