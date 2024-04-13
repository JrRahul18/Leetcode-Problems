class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stk = new Stack<>();
        int[] leftSmall = new int[heights.length];
        int[] rightSmall = new int[heights.length];
        
        for(int i=0; i<heights.length; i++){
            while(!stk.isEmpty() && heights[stk.peek()] >= heights[i]){
                stk.pop();
            }
            if(stk.isEmpty()){
                leftSmall[i] = 0;
            }
            else{
                leftSmall[i] = stk.peek()+1;
            }
            stk.push(i);
        }
        
        Stack<Integer> stk2 = new Stack<>();
        for(int i = heights.length-1; i>=0; i--){
            while(!stk2.isEmpty() && heights[stk2.peek()] >= heights[i]){
                stk2.pop();
            }
            if(stk2.isEmpty()){
                rightSmall[i] = heights.length-1;
            }
            else{
                rightSmall[i] = stk2.peek()-1;
            }
            stk2.push(i);
        }
        int maxArea = 0;
        for(int i=0; i<heights.length; i++){
            maxArea = Math.max(maxArea, (rightSmall[i] - leftSmall[i] + 1)*heights[i]);
        }
        return maxArea;
    }
}