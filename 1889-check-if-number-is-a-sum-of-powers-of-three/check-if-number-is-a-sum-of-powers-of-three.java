class Solution {
    public boolean checkPowersOfThree(int n) {
        int maxPow = (int)Math.pow(n, 0.333)+1;
        for(int i = maxPow; i>=0; i--){
            System.out.println(Math.pow(3, i));
            int num = (int)Math.pow(3, i);
            if(num<= n) n-=num;
            System.out.println(num);
        }
        return n==0;
    }
}