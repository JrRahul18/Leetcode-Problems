class Solution {
    public long continuousSubarrays(int[] nums) {
        TreeMap<Integer, Integer> tmap = new TreeMap<>();
        long finalAns=0;
        int i=0, j=0;
        
        while(j<nums.length){
            tmap.put(nums[j], tmap.getOrDefault(nums[j],0)+1);
            
            while(tmap.lastKey() - tmap.firstKey() > 2){
                tmap.put(nums[i], tmap.get(nums[i])-1);
                if(tmap.get(nums[i]) == 0){
                    tmap.remove(nums[i]);
                }
                i++;
            }
            finalAns+=j-i+1;
            j++;
        }
        return finalAns;
    }
}