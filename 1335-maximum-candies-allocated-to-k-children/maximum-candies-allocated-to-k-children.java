class Solution {
    public int maximumCandies(int[] candies, long k) {
        int min = 0;
        int max = 0;
        int ans = 0;
        for(int i = 0; i< candies.length; i++){
            max = Math.max(max, candies[i]);
        }
        while(min<=max){
            int mid = min+(max-min)/2;
            if(candiesPossible(candies, k, mid)){
                min = mid+1;
                ans = mid;
            }
            else{
                max = mid-1;
            }

        }
        return ans;
    }
    public boolean candiesPossible(int[] candies, long k, int mid){
        if(mid==0) return true;
        for(int i = 0; i<candies.length; i++){
            int count = candies[i]/mid;
            k-=count;
            if(k<=0) return true;
        }
        return false;
    }
}