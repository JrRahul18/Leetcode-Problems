class Solution {
    public int rectangleArea(int[] histogram){
        Stack<Integer> stk = new Stack<>();
        int maxArea= 0;
        for(int i=0; i<=histogram.length; i++){
            while(!stk.isEmpty() && (i == histogram.length || histogram[stk.peek()] >= histogram[i])){
                int height = histogram[stk.peek()];
                stk.pop();
                int width = 0;
                if(stk.isEmpty()) {
                    width = i;
                }
                else{
                    width = i-stk.peek()-1;
                }
                maxArea = Math.max(maxArea, width*height);
            }
            stk.push(i);
        }
        return maxArea;
    }
    public int maximalRectangle(char[][] matrix) {
        int finalAns = 0;
        int[] histogram = new int[matrix[0].length];
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] =='1'){
                    histogram[j]++;
                }
                else{
                    histogram[j]=0;
                    
                }
            }
            int area = rectangleArea(histogram);
            finalAns = Math.max(finalAns, area);
        }
        return finalAns;
    }
}