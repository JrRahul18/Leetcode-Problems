class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> hmap = new HashMap<>();
        for(char ch: s.toCharArray()){
            hmap.put(ch, hmap.getOrDefault(ch, 0)+1);
        }
        String finalAns="";
        for(char ch: order.toCharArray()){
            if(hmap.containsKey(ch)){
                int val = hmap.get(ch);
                for(int i=0; i<val; i++){
                    finalAns+=ch;
                }
                hmap.remove(ch);
                // finalAns+=ch;
                // hmap.put(ch, hmap.getOrDefault(ch, 0)-1);
                // if(hmap.get(ch)==0){
                //     hmap.remove(ch);
                // }
            }
        }
        for(Map.Entry<Character, Integer> entry: hmap.entrySet()){
            char ch = entry.getKey();
            int val = entry.getValue();
            for(int i=0; i<val; i++){
                finalAns+=ch;
            }
        }
        return finalAns;
        
    }
}