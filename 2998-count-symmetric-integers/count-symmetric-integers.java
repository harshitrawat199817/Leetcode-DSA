class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for(int i = low; i<=high; i++){
            if(isSymmetric(i)) count++;
        }
        return count;
    }
    public boolean isSymmetric(int num){
        int digits = (int)Math.log10(num)+1;
        if(digits%2==1) return false;
        // System.out.println((int)(num/Math.pow(10,digits/2))+" "+(int)(num%Math.pow(10,digits/2)));
        int firstHalf = (int)(num/Math.pow(10,digits/2));
        int secondHalf =  (int)(num%Math.pow(10,digits/2));
        return digitSum(firstHalf)==digitSum(secondHalf);
    }
    public int digitSum(int num){
        int sum = 0;
        while(num>0){
            sum+= num%10;
            num = num/10;
        }
        return sum;
    }
}