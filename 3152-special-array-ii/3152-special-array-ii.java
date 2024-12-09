class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        boolean[] finalAns = new boolean[queries.length];
        // Arrays.fill(finalAns, false);
        int[] count = new int[nums.length];
        
        for(int i=1; i<count.length; i++){
            if(nums[i]%2 == nums[i-1]%2){
                count[i]=count[i-1]+1;
            }
            else{
                count[i]=count[i-1];
            }
        }
        
        
        for(int i=0; i<queries.length; i++){
            int[] q = queries[i];
            if(count[q[1]] - count[q[0]] == 0){
                finalAns[i]=true;
            }
        }
        return finalAns;
        
        
    }
}