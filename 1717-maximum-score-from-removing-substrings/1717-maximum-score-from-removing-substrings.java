class Solution {
    public int maximumGain(String s, int x, int y) {
        int finalAns = 0;
        int counta=0, countb=0;
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) =='a'){
                if(y>x && countb>0){
                    finalAns+=y;
                    countb--;
                }
                else{
                    counta++;
                }
            }
            else if(s.charAt(i)=='b'){
                if(x>y && counta>0){
                    finalAns+=x;
                    counta--;
                }
                else{
                    countb++;
                }
            }
            else{
                finalAns+= Math.min(counta, countb) * Math.min(x, y);
                counta=0;
                countb=0;
            }
        }
        finalAns+=Math.min(counta, countb)*Math.min(x, y);
        return finalAns;
    }
}