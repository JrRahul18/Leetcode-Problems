class Solution {
    public int findMaxLength(int[] nums) {
        //store prefsum and index in hashmap.
        int finalAns = 0;
        HashMap<Integer, Integer> hmap = new HashMap<>();
        hmap.put(0, -1);
        int prefSum = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                prefSum+=-1;
            }
            else{
                prefSum+=nums[i];
            }
            if(hmap.containsKey(prefSum)){
                int len = i - hmap.get(prefSum);
                finalAns = Math.max(finalAns, len);
            }
            else{
                hmap.put(prefSum, i);
            }
        }
        return finalAns;
    }
}