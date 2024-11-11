class Solution {
    public boolean primeSubOperation(int[] nums) {
        int[] isPrime = new int[1001];
        Arrays.fill(isPrime, 1);
        isPrime[0]=0;
        isPrime[1]=0;
        
        for(int i=2; i * i<1001; i++){
            if(isPrime[i] == 1){
                for(int j = i*i; j<1001; j+=i){
                    isPrime[j]=0;
                }
            }
        }
        
        for(int i=nums.length-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                continue;
            }
            
            for(int j=2; j<nums[i]; j++){
                if(isPrime[j]==0) continue;
                
                if(nums[i]-j < nums[i+1]){
                    nums[i] = nums[i]-j;
                    break;
                }
            }
            
            if(nums[i]>=nums[i+1]) return false;
            
        }
        return true;
        
    }
}