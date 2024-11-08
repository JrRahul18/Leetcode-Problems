class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int[] finalAns = new int[nums.length];
        int xor = 0;
        
        for(int i=0; i<nums.length; i++){
            xor = xor ^ nums[i];
        }
        
        int mask = ((1 << maximumBit)-1);
        
        for(int i=0; i<nums.length; i++){
            finalAns[i] = xor^mask;
            xor = xor ^ nums[nums.length-i-1];
        }
        return finalAns;
    }
}