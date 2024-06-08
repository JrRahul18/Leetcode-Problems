class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        hmap.put(0, -1);
        int pref =0;
        for(int i=0; i<nums.length; i++){
            pref+=nums[i];
            int rem = pref%k;
            if(hmap.containsKey(rem)){
                if(i-hmap.get(rem) >=2){
                    return true;
                }
            }
            else{
                            hmap.put(rem, i);

            }
            
        }
        return false;
    }
}