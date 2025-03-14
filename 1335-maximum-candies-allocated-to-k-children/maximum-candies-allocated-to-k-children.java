class Solution {
    public int maximumCandies(int[] candies, long k) {
        int min = 0;
        int max = 0;
        for(int i = 0; i< candies.length; i++){
            max = Math.max(max, candies[i]);
        }
        while(min<max){
            int mid = min+(max+1-min)/2;
            if(candiesPossible(candies, k, mid)){
                min = mid;
            }
            else{
                max = mid-1;
            }

        }
        return min;
    }
    public boolean candiesPossible(int[] candies, long k, int mid){
        for(int i = 0; i<candies.length; i++){
            int count = candies[i]/mid;
            k-=count;
            if(k<=0) return true;
        }
        return false;
    }
}