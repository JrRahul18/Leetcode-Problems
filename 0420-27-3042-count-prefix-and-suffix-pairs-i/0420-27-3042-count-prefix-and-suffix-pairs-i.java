class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int finalAns=0;

        for(int i=0; i<words.length; i++){
            String str = words[i];
            for(int j=i+1; j<words.length; j++){
                String temp=words[j];
                if(temp.startsWith(str) && temp.endsWith(str)){
                    finalAns++;
                }
            }
        }
        return finalAns;
    }
}