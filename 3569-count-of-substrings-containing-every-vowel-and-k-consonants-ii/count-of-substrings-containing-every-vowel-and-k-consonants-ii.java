// class Solution {
//     public long countOfSubstrings(String word, int k) {
//         return countOfSubstring(word, k)- countOfSubstring(word,k+1);
        
//     }
//     public long countOfSubstring(String word, int k) {
//         int start = 0;
//         int consonants = 0;
//         int count = 0;
//         Map<Character, Integer> vowels = new HashMap<>();
//         for(int i = -1; i< word.length(); i++){
//             if(i>=0){
//                 char ch = word.charAt(i);
//                 if(isVowel(ch)){
//                     int freq = vowels.get(ch);
//                     if(freq==1) vowels.remove(ch);
//                     else vowels.put(ch, freq-1);
//                 }
//                 else{
//                     consonants--;
//                 }
//             }
//             while(start<word.length() && (vowels.size()!=5 || consonants<k)){
//                 char ch = word.charAt(start++);
//                 // System.out.println("ch-"+ch);
//                 if(isVowel(ch)){
//                     int freq = vowels.getOrDefault(ch, 0);
//                     vowels.put(ch, freq+1);
//                 }
//                 else consonants++;
//             }
//             // System.out.println(vowels+" consonants "+consonants);
//             if(vowels.size()!=5 || consonants<k){
//                 // System.out.println(vowels+" consonants "+consonants);
//                 return count;
//             }
//             else{
//                 count+= word.length()-start+1;
//             }
//             // System.out.println(vowels+" consonants "+consonants);
//         }
//         return count;
        
//     }
//     private boolean isVowel(char ch){
//         return ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u';
//     }
// }
class Solution {

    public long countOfSubstrings(String word, int k) {
        return atLeastK(word, k) - atLeastK(word, k + 1);
    }

    private long atLeastK(String word, int k) {
        long numValidSubstrings = 0;
        int start = 0;
        int end = 0;
        // keep track of counts of vowels and consonants
        HashMap<Character, Integer> vowelCount = new HashMap<>();
        int consonantCount = 0;

        // start sliding window
        while (end < word.length()) {
            // insert new letter
            char newLetter = word.charAt(end);

            // update counts
            if (isVowel(newLetter)) {
                vowelCount.put(
                    newLetter,
                    vowelCount.getOrDefault(newLetter, 0) + 1
                );
            } else {
                consonantCount++;
            }

            // shrink window while we have a valid substring
            while (vowelCount.size() == 5 && consonantCount >= k) {
                numValidSubstrings += word.length() - end;
                char startLetter = word.charAt(start);
                if (isVowel(startLetter)) {
                    vowelCount.put(
                        startLetter,
                        vowelCount.get(startLetter) - 1
                    );
                    if (vowelCount.get(startLetter) == 0) {
                        vowelCount.remove(startLetter);
                    }
                } else {
                    consonantCount--;
                }
                start++;
            }

            end++;
        }

        return numValidSubstrings;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}