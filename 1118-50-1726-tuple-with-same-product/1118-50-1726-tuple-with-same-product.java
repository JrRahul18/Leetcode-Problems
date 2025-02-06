class Solution {
    public int tupleSameProduct(int[] nums) {
        int finalAns = 0;
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                int prod = nums[i] * nums[j];
                hmap.put(prod, hmap.getOrDefault(prod, 0) + 1);
            }
        }

        for(Map.Entry<Integer, Integer> e: hmap.entrySet()){
            int prod = e.getKey();
            int num = e.getValue();

            finalAns +=  (num * (num-1))/2;
        }
        return finalAns*8;
    }
}