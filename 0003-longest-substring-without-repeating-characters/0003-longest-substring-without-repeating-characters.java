class Solution {
    public int lengthOfLongestSubstring(String s) {
        int finalAns=0;
        HashMap<Character, Integer> hmap = new HashMap<>();
        int i=0, j=0;
        
        while(j<s.length()){

            
            if(hmap.containsKey(s.charAt(j))){
                int idx = hmap.get(s.charAt(j));
                // i=idx+1;
                for(int k=i; k<idx+1; k++){
                    hmap.remove(s.charAt(k));
                }
                i=idx+1;
            }
            
            hmap.put(s.charAt(j), j);
            
            finalAns = Math.max(finalAns, j-i+1);
            j++;
        }
        return finalAns;
    }
}