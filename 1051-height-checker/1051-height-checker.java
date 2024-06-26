class Solution {
    public int heightChecker(int[] heights) {
        int[] temp = heights.clone();
        Arrays.sort(temp);
        int finalAns = 0;
        for(int i=0; i<heights.length; i++){
            if(temp[i] != heights[i]) finalAns++;
        }
        return finalAns;
    }
}