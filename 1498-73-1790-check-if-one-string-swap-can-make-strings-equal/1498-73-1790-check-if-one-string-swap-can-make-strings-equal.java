class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.equals(s2))return true;

        int diff = 0;
        int idx1 = 0, idx2=0;

        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                diff++;

                if(diff > 2) return false;
                else if(diff == 1){
                    idx1 = i;
                }
                else{
                    idx2 = i;
                }
            }
        }
        return s1.charAt(idx1) == s2.charAt(idx2) && s2.charAt(idx1) == s1.charAt(idx2);
    }
}