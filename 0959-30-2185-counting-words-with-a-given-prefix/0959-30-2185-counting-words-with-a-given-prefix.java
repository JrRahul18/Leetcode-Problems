class Solution {
    public int prefixCount(String[] words, String pref) {
        int finalAns = 0;
        for(String w: words){
            if(w.startsWith(pref)){
                finalAns++;
            }
        }
        return finalAns;
    }
}