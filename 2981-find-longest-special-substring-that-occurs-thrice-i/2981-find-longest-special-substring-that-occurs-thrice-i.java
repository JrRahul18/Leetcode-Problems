class Solution {
    class Pair{
        char ch;
        int count;
        Pair(char ch, int count){
            this.ch=ch;
            this.count=count;
        }
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Pair pair = (Pair) obj;
            return ch == pair.ch && count == pair.count;
        }


        public int hashCode() {
            return 31 * Character.hashCode(ch) + Integer.hashCode(count);
        }
    }
    public int maximumLength(String s) {
        int finalAns=0;
        HashMap<Pair, Integer> hmap = new HashMap<>();
        int len=0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            len=0;
            for(int j=i; j<s.length(); j++){
                if(ch == s.charAt(j)){
                    len++;
                    Pair temp = new Pair(ch, len);
                    hmap.put(temp, hmap.getOrDefault(temp, 0)+1);
                }else{
                    break;
                }
            }
        }
        
        for(Map.Entry<Pair, Integer> entry: hmap.entrySet()){
            int subLength=entry.getKey().count;
            if(entry.getValue() >= 3){
                finalAns = Math.max(finalAns, subLength);
            }
            
        }
        return finalAns==0 ? -1 : finalAns;
    }
}