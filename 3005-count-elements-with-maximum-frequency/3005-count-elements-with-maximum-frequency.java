class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int num: nums){
            hmap.put(num, hmap.getOrDefault(num, 0)+1);
        }
        int maxFrequency = 0;
        int finalAns = 0;
        for(Map.Entry<Integer, Integer> entry: hmap.entrySet()){
            maxFrequency = Math.max(maxFrequency, entry.getValue());
        }
        for(Map.Entry<Integer, Integer> entry: hmap.entrySet()){
            if(maxFrequency == entry.getValue()) finalAns+=maxFrequency;
        }
        return finalAns;
    }
}