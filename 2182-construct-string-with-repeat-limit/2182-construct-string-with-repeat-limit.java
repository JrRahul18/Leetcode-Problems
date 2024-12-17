class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        StringBuilder finalAns = new StringBuilder();
        int[] charCount = new int[26];
        
        for(int i=0; i<s.length(); i++){
            charCount[s.charAt(i)-'a']++;
        }
        PriorityQueue<Character> pq = new PriorityQueue<>( (a,b) -> (b-'a') - (a-'a') );
        
        for(int i=0; i<charCount.length; i++){
            if(charCount[i] > 0){
                pq.add( (char) (i+'a'));
            }
        }
        
        while(!pq.isEmpty()){
            char temp = pq.peek();
            pq.poll();
            int limit = Math.min(repeatLimit, charCount[temp-'a']);
            
            for(int k=0; k<limit; k++){
                finalAns.append(temp);
            }
            charCount[temp-'a']-=limit;
            if(charCount[temp-'a'] > 0 && !pq.isEmpty()){
                char newTemp = pq.peek();
                pq.poll();
                finalAns.append(newTemp);
                charCount[newTemp-'a']--;
                if(charCount[newTemp-'a'] > 0){
                    pq.add(newTemp);
                }
                pq.add(temp);
            }
            
        }
        return finalAns.toString();
    }
}