class Solution {
    public int[] closestPrimes(int left, int right) {
        if(left==right) return new int[]{-1,-1};
        int[] isPrime = sieve(right+1);
        int min = Integer.MAX_VALUE;
        int num1 = -1;
        int num2 = -1;
        for(int i = left; i<=right; i++){
            if(isPrime[i]==1){
                int first = i;
                int second = i;
                for(int j = i+1; j<=right; j++){
                    if(isPrime[j]==1){
                        second = j;
                        break;
                    }
                }
                if(second!=first && second-first<min){
                    num1 = first;
                    num2 = second;
                    min = second-first;
                    if(min==2 || min==1) return new int[]{num1,num2};
                }
                

            }
        }

        // return isPrime;
        return new int[]{num1,num2};
    }

    public int[] sieve(int range){
        int[] isPrime = new int[range];
        // 0 = untouched;
        // 1 = prime;
        // 2 = not prime;
        isPrime[0] = 2;
        isPrime[1] = 2;
        for(int i = 2; i< range; i++){
            if(isPrime[i]==0){
                isPrime[i] = 1;
                for(int j = i+i; j<range; j+=i){
                    isPrime[j] = 2;
                }
            }
        }
        return isPrime;
        
    }
}