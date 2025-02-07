class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> numberToColour = new HashMap<>();
        Map<Integer, Integer> colourToNumber = new HashMap<>();
        int[] ans = new int[queries.length];
        for(int i = 0; i<queries.length; i++){
            int ball = queries[i][0];
            int colour = queries[i][1];
            if(numberToColour.containsKey(ball)){
                int prevColour = numberToColour.get(ball);
                colourToNumber.put(prevColour, colourToNumber.get(prevColour)-1);
                if(colourToNumber.get(prevColour)==0){
                    colourToNumber.remove(prevColour);
                }
            }
            numberToColour.put(ball, colour);
            // if(!colourToNumber.containsKey(colour)){
            //     colourToNumber.put(colour, new HashSet<>());
            // }
            int freq = colourToNumber.getOrDefault(colour, 0);
            colourToNumber.put(colour, freq+1);
            ans[i] = colourToNumber.size();
        }
        return ans;
    }
}