class Solution {
    public int minimumPushes(String word) {
        int finalAns = 0;
        int[] storeCount = new int[26];
        Integer[] frequency = new Integer[26];
        
        for(char ch: word.toCharArray()){
            storeCount[ch-'a']++;
        }
        for(int i=0; i<26; i++){
            frequency[i] = storeCount[i];
        }
        Arrays.sort(frequency, (a,b)->b-a );
        
        for(int i=0; i<26; i++){
            if(frequency[i]==0) return finalAns;
            finalAns += ((i/8)+1)*frequency[i];
        }
        return finalAns;
        
    }
}