class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> finalAns = new ArrayList<>();
        int[] storeFreq = new int[26];
        for(String w: words2){
            int[] temp = new int[26];

            for(char ch: w.toCharArray()){
                temp[ch-'a']++;
            }

            for(int i=0; i<26; i++){
                storeFreq[i] = Math.max(storeFreq[i], temp[i]);
            }
        }

        for(String w: words1){
            int[] temp = new int[26];

            for(char ch: w.toCharArray()){
                temp[ch-'a']++;
            }

            boolean check = true;
            for(int i=0; i<26; i++){
                if(storeFreq[i] > temp[i]){
                    check = false;
                    break;
                }
            }
            if(check == true){
                finalAns.add(w);
            }

        }
        return finalAns;
    }
}