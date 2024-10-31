class Solution {
    static long dp[][];
    public long solve(int ridx, int fidx, List<Integer> robot, List<Integer> factories){
        
        if(ridx == robot.size()) return 0;
        
        if(fidx == factories.size()) return (long)1e12;
        
        if(dp[ridx][fidx] != -1) return dp[ridx][fidx];
        
        long take=0, notTake=0;
        
        take = Math.abs(robot.get(ridx) - factories.get(fidx)) + solve(ridx+1, fidx+1, robot, factories);
        notTake = solve(ridx, fidx+1, robot, factories);
        
        return dp[ridx][fidx] = Math.min(take, notTake);
    }
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        long finalAns = 0;
        
        Collections.sort(robot);
        
        Arrays.sort(factory, (a,b) -> a[0]-b[0]);
        List<Integer> factories = new ArrayList<>();
        
        for(int[] f: factory){
            for(int i=0; i<f[1]; i++){
                factories.add(f[0]);
            }
        }
        
        dp = new long[robot.size()+1][factories.size()+1];
        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
        
        return solve(0, 0, robot, factories);
    }
}