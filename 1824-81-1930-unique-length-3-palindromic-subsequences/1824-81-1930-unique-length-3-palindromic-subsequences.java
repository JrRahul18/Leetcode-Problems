class Solution {
    public int countPalindromicSubsequence(String s) {
        int finalAns=0;
        HashSet<Character> hset = new HashSet<>();
        for(char ch: s.toCharArray()){
            hset.add(ch);
        }

        for(char ch: hset){
            int l=0, r=0;

            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == ch){
                    l=i;
                    break;
                }
            }
            for(int j=s.length()-1; j>=0; j--){
                if(s.charAt(j) == ch){
                    r=j;
                    break;
                }
            }

            HashSet<Character> betweenChar = new HashSet<>();
            for(int i=l+1; i<r; i++){
                betweenChar.add(s.charAt(i));
            }
            finalAns+=betweenChar.size();
        }
        return finalAns;
    }
}