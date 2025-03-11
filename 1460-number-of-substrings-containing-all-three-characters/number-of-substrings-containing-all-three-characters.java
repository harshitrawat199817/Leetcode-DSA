class Solution {
    public int numberOfSubstrings(String s) {
        int a = 0;
        int b = 0;
        int c = 0;
        int end = 0;
        int count = 0;
        for(int i = -1; i< s.length(); i++){
            if(i>=0){
                char ch = s.charAt(i);
                if(ch=='a') a--;
                else if(ch=='b') b--;
                else c--;
            }
            while( end<s.length() && ( a==0 || b==0 || c==0 )){
                char ch = s.charAt(end++);
                if(ch=='a') a++;
                else if(ch=='b') b++;
                else c++;
            }
            if(a>0 && b>0 && c>0) count+= s.length()-end+1;

        }
        return count;
    }
}