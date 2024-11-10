class Solution {
    static void updateBits(int num, int[] bitArray, int check){
        
        for(int i=0; i<bitArray.length; i++){
            if( ((num >> i) & 1) >0){
                bitArray[i]+=check;
            }
        }
    }
    static int getNumber(int[] bitArray){
        int ans = 0;
        
        for(int i=0; i<bitArray.length; i++){
            if(bitArray[i] > 0){
                ans = ans | (1 << i); 
            }
        }
        return ans;
    }
    public int minimumSubarrayLength(int[] nums, int k) {
        int finalAns = Integer.MAX_VALUE;
        
        int[] bitArray = new int[32];
        
        int i=0, j=0, current=0;
        
        while(j<nums.length){
            updateBits(nums[j], bitArray, 1);
            
            while(i<=j && getNumber(bitArray) >=k){
                finalAns = Math.min(finalAns, j-i+1);
                updateBits(nums[i], bitArray, -1);
                i++;
            }
            
            j++;
        }
        if(finalAns == Integer.MAX_VALUE) return -1;
        return finalAns;
    }
}