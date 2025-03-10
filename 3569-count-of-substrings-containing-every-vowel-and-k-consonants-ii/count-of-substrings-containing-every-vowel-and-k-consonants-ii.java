class Solution {
    public long countOfSubstrings(String word, int k) {
        return countOfSubstring(word, k)- countOfSubstring(word,k+1);
        
    }
    public long countOfSubstring(String word, int k) {
        int start = 0;
        int consonants = 0;
        long count = 0;
        Map<Character, Integer> vowels = new HashMap<>();
        for(int i = -1; i< word.length(); i++){
            if(i>=0){
                char ch = word.charAt(i);
                if(isVowel(ch)){
                    int freq = vowels.get(ch);
                    if(freq==1) vowels.remove(ch);
                    else vowels.put(ch, freq-1);
                }
                else{
                    consonants--;
                }
            }
            while(start<word.length() && (vowels.size()!=5 || consonants<k)){
                char ch = word.charAt(start++);
                // System.out.println("ch-"+ch);
                if(isVowel(ch)){
                    int freq = vowels.getOrDefault(ch, 0);
                    vowels.put(ch, freq+1);
                }
                else consonants++;
            }
            // System.out.println(vowels+" consonants "+consonants);
            if(vowels.size()!=5 || consonants<k){
                // System.out.println(vowels+" consonants "+consonants);
                return count;
            }
            else{
                count+= word.length()-start+1;
            }
            // System.out.println(vowels+" consonants "+consonants);
        }
        return count;
        
    }
    private boolean isVowel(char ch){
        return ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u';
    }
}
