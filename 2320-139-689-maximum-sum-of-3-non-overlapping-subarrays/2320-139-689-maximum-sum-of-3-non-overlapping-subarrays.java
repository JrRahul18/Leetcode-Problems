class Solution {
    static List<Integer> finalAns;
    static int[][] dp;
    static int solve(int idx, int count, int k, int[] storeSum){
        if(count==0)return 0;

        if(idx>=storeSum.length){
            return Integer.MIN_VALUE;
        }

        if(dp[idx][count] != -1){
            return dp[idx][count];
        }

        int take=0, notTake=0;
        
        
        take = storeSum[idx]+solve(idx+k, count-1, k, storeSum);
        notTake = solve(idx+1, count, k, storeSum);

        return dp[idx][count]= Math.max(take, notTake);
    }
    static void fill(int idx, int count, int k, int[] storeSum){

        if(count<=0 || idx >= storeSum.length) return;

        int take=0, notTake=0;
        take = storeSum[idx] + solve(idx+k, count-1, k, storeSum);
        notTake = solve(idx+1, count, k, storeSum);

        if(take>=notTake){
            finalAns.add(idx);
            fill(idx+k, count-1, k, storeSum);
        }
        else{
            fill(idx+1, count, k, storeSum);
        }
    }
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        finalAns = new ArrayList<>();

        dp = new int[nums.length+1][4];

        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }

        int[] storeSum = new int[nums.length-k+1];

        int current = 0;
        for(int i=0; i<k; i++){
            current+=nums[i];
        }
        storeSum[0]=current;
        int p=k;

        for(int i=1; i<storeSum.length; i++){
            current+=nums[p];
            current-=nums[p-k];
            storeSum[i]=current;
            p++;
        }

        fill(0, 3, k, storeSum);

        return finalAns.stream().mapToInt(Integer::intValue).toArray();

    }
}