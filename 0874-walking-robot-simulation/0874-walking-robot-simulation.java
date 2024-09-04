class Solution {
    static int[] xArray = {0, 1, 0, -1};
    static int[] yArray = {1, 0, -1, 0};
    
    public int robotSim(int[] commands, int[][] obstacles) {
        int finalAns = 0;
        
        int x=0, y=0, d=0;
        
        Set<String> hset = new HashSet<>();
        for(int[] obs: obstacles){
            hset.add(obs[0] + " " + obs[1]);
        }
        
        for(int c: commands){
            if(c == -1){
                d = (d+1)%4;
            }
            else if(c == -2){
                d = (d+3)%4;
            }
            else{
                for(int i=1; i<=c; i++){
                    if(!hset.contains( (x+xArray[d]) + " " + (y+yArray[d]) )){
                        x=x+xArray[d];
                        y=y+yArray[d];
                    }
                    else{
                        break;
                    }
                }
                
                finalAns = Math.max(finalAns, x*x + y*y);
            }
        }
        return finalAns;
    }
}