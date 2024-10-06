class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] str1 = sentence1.split(" ");
        String[] str2 = sentence2.split(" ");
        
        int l1 = 0, l2 = 0, r1 = str1.length-1, r2 = str2.length-1;
        
        while(l1 <=r1 && l2<=r2 && str1[l1].equals(str2[l2])){
            l1++;
            l2++;
        }
        while(l1<=r1 && l2<=r2 && str1[r1].equals(str2[r2])){
            r1--;
            r2--;
        }
        
        if(l1>r1 || l2>r2) return true;
        
        return false;
        
    }
}