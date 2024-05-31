class Solution {
    public int[] singleNumber(int[] nums) {
        if(nums.length == 2) return nums;
        int [] finalAns = new int[2];
        long xor = 0;
        
        for(int num: nums){
            xor = xor^num;
        }
        long bitMask = xor & (-xor);
        
        int count1=0, count2=0;
        
        for(int num: nums){
            if((num & bitMask) != 0){
                count1 = count1^num;
            }
            else{
                count2 = count2^num;
            }
        }
        finalAns[0] = count1;
        finalAns[1] = count2;
        return finalAns;
        
    }
}