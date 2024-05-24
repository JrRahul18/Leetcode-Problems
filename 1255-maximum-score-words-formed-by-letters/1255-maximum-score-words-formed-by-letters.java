class Solution {
    static int finalAns;
    public void solve(int idx,int temp, HashMap<Character, Integer> hmap, String[] words, char[] letters, int []score){
        finalAns = Math.max(finalAns, temp);
        if(idx == words.length) return;
        
        HashMap<Character, Integer> tempMap= new HashMap<>(hmap);
        int count=0;
        boolean check = true;
        for(int i=0; i<words[idx].length(); i++){
            char ch = words[idx].charAt(i);
            if(!tempMap.containsKey(ch)){
                check = false;
                break;
            }
            count+=score[ch-'a'];
            tempMap.put(ch, tempMap.get(ch)-1);
            if(tempMap.get(ch) < 0){
                check = false;
                break;
            }
        }
        if(check == true){
            solve(idx+1,temp+count, tempMap, words, letters, score);
        }
        solve(idx+1, temp, hmap, words, letters, score);
        
    }
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        finalAns = 0;
        HashMap<Character, Integer> hmap = new HashMap<>();
        for(char ch: letters){
            hmap.put(ch, hmap.getOrDefault(ch, 0) + 1);
        }
        solve(0, 0, hmap, words, letters, score);
        return finalAns;
    }
}