class Solution {
    public long repairCars(int[] ranks, int cars) {
        long min = 1;
        long max = Long.MAX_VALUE;
        while(min<max){
            long mid = min+(max-min)/2;
            if(repairPossible(ranks, cars, mid)){
                max = mid;
            }
            else{
                min = mid+1;
            }
        }
        return min;
    }
    public boolean repairPossible(int[] ranks, int cars, long time){
        long repaired = 0;
        for(int rank : ranks){
            repaired += (long)(Math.sqrt(time/rank));
            if(cars<=repaired) return true;
        }
        return false;
    }
}