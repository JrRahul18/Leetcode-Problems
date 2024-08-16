class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int finalAns = 0;
        int low = arrays.get(0).get(0);
        int high = arrays.get(0).get(arrays.get(0).size()-1);
        
        for(int i=1; i<arrays.size(); i++){
            finalAns = Math.max(finalAns, Math.abs( arrays.get(i).get(arrays.get(i).size()-1)- low));
            finalAns = Math.max(finalAns, Math.abs( high - arrays.get(i).get(0)));
            low = Math.min(low, arrays.get(i).get(0));
            high = Math.max(high, arrays.get(i).get(arrays.get(i).size()-1));
        }
        return finalAns;
    }
}