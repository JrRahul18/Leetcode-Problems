class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> hmap1 = new HashMap<>();
        HashMap<Character, Character> hmap2 = new HashMap<>();
        
        for(int i=0; i<s.length(); i++){
            if(hmap1.containsKey(s.charAt(i)) && hmap1.get(s.charAt(i)) != t.charAt(i)) return false;
            if(hmap2.containsKey(t.charAt(i)) && hmap2.get(t.charAt(i)) != s.charAt(i)) return false;
            hmap1.put(s.charAt(i), t.charAt(i));
            hmap2.put(t.charAt(i), s.charAt(i));
        }
        return true;
        
    }
}