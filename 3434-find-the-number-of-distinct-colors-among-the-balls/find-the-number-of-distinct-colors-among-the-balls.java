class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> numberToColour = new HashMap<>();
        Map<Integer, Set<Integer>> colourToNumber = new HashMap<>();
        int[] ans = new int[queries.length];
        for(int i = 0; i<queries.length; i++){
            int ball = queries[i][0];
            int colour = queries[i][1];
            if(numberToColour.containsKey(ball)){
                int prevColour = numberToColour.get(ball);
                colourToNumber.get(prevColour).remove(ball);
                if(colourToNumber.get(prevColour).isEmpty()){
                    colourToNumber.remove(prevColour);
                }
            }
            numberToColour.put(ball, colour);
            if(!colourToNumber.containsKey(colour)){
                colourToNumber.put(colour, new HashSet<>());
            }
            colourToNumber.get(colour).add(ball);
            ans[i] = colourToNumber.size();

        }
        return ans;
    }
}