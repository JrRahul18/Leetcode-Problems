class Solution {
    static int dp[][];
    public int solve(int idx, int currentRemWidth, int maxHeight, int[][] books, int shelfWidth){
        
        if(idx>=books.length){
            return maxHeight;
        }
        
        if(dp[idx][currentRemWidth] != -1) return dp[idx][currentRemWidth];
        
        int take=Integer.MAX_VALUE, notTake = Integer.MAX_VALUE;
        
        if(books[idx][0] <= currentRemWidth){
            take = solve(idx+1, currentRemWidth-books[idx][0], Math.max(maxHeight, books[idx][1]), books, shelfWidth );
        }
        
        notTake = maxHeight + solve(idx+1, shelfWidth-books[idx][0], books[idx][1], books, shelfWidth);
        
        return dp[idx][currentRemWidth] = Math.min(take, notTake);
        
    }
    public int minHeightShelves(int[][] books, int shelfWidth) {
        dp = new int[1001][1001];
        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(0, shelfWidth, 0, books, shelfWidth);
    }
}