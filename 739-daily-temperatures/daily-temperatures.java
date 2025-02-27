class Solution {
    public int[] dailyTemperatures(int[] tempratures) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[tempratures.length];
        for(int i = tempratures.length-1; i>=0; i--){
            while(!stack.isEmpty() && tempratures[stack.peek()]<=tempratures[i]){
                stack.pop();
            }
            if(stack.isEmpty()) {
                stack.add(i);
            }
            else{
                ans[i] = stack.peek()-i;
                stack.add(i);
            }
        }
        return ans;
    }
}