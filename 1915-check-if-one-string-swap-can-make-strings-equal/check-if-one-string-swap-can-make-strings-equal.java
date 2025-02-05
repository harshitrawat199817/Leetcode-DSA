class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.equals(s2)) return true;
        char swappedChar1 = '.';
        char swappedChar2 = '.';
        int count = 0;
        for(int i = 0; i<s1.length() ; i++){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if(c1!=c2){
                count++;
                if(count>2) return false;
                if(swappedChar1=='.'){
                    swappedChar1 = c1;
                    swappedChar2 = c2;
                }
                else if(swappedChar1!=c2 || swappedChar2!= c1){
                    return false;
                }
                
            }

        }
        if(count == 1) return false;
        return true;
    }
}