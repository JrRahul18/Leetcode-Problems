class Solution {
    static int finalAns;
    static void solve(int idx, int current, String s, HashSet<String> hset){
        if(idx >= s.length()){
            finalAns = Math.max(finalAns, current);
            return;
        }
        
        for(int j = idx; j<s.length(); j++){
            String temp = s.substring(idx, j+1);
            if(!hset.contains(temp)){
                hset.add(temp);
                solve(j+1, current+1, s, hset);
                hset.remove(temp);
            }
        }
    }
    public int maxUniqueSplit(String s) {
        HashSet<String> hset= new HashSet<String>();
        finalAns = 0;
        solve(0, 0, s, hset);
        return finalAns;
        
    }
}