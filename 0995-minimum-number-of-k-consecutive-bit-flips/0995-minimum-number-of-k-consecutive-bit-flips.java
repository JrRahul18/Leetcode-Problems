class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int finalAns = 0, current = 0;
        int[] flippedArray = new int[nums.length];
        for(int i =0; i<nums.length; i++){
            if(i-k>=0){
                current = current ^ flippedArray[i-k];
            }
            
            if((nums[i] == 0 && current%2 ==0) || (nums[i] != 0 && current%2 != 0)){
                if(i+k > nums.length) return -1;
                
                finalAns++;
                flippedArray[i] = 1;
                current++;
            }
        }
        return finalAns;
    }
}