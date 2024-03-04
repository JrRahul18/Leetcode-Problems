class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int max = 0;
        int score = 0;
        int i=0, j=tokens.length-1;
        while(i<=j){
            if(power >= tokens[i]){
                power-=tokens[i];
                i++;
                score++;
            }
            else if(score>0){
                power+=tokens[j];
                j--;
                score--;
            }
            else{
                break;
            }
            max= Math.max(max, score);
        }
        return max;
    }
}