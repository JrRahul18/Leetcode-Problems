class Solution {
    class Pair{
        char letter;
        int freq;
        Pair(char letter, int freq){
            this.letter = letter;
            this.freq = freq;
        }
    }
    public String longestDiverseString(int a, int b, int c) {
        String finalAns = "";
        PriorityQueue<Pair> pq = new PriorityQueue<>((p,q)-> q.freq - p.freq);
        if(a>0) pq.offer(new Pair('a', a));
        if(b>0) pq.offer(new Pair('b', b));
        if(c>0) pq.offer(new Pair('c', c));
        
        while(!pq.isEmpty()){
            Pair temp = pq.peek();
            pq.poll();
            
            if(finalAns.length() > 1 && finalAns.charAt(finalAns.length()-1) == temp.letter && finalAns.charAt(finalAns.length()-2) == temp.letter ){
                if(pq.isEmpty()) break;
                
                Pair temp2 = pq.peek();
                pq.poll();
                finalAns+=temp2.letter;
                temp2.freq--;
                if(temp2.freq > 0) pq.offer(temp2);
                pq.offer(temp);
            }
            else{
                finalAns+=temp.letter;
                temp.freq--;
                if(temp.freq > 0) pq.offer(temp);
            }
            
        }
        return finalAns;
    }
}