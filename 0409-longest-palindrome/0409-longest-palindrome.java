class Solution {
    public int longestPalindrome(String s) {
        int finalAns=s.length(), count=0;
        HashMap<Character, Integer> hmap = new HashMap<>();
        for(char ch: s.toCharArray()){
            hmap.put(ch, hmap.getOrDefault(ch,0)+1);
            if(hmap.get(ch)%2 != 0) count++;
            else count--;
        }
        if(count>1) finalAns= s.length()-count+1;
        return finalAns;
        
    }
}