class AllOne {
    HashMap<String, Integer> hmap;
    TreeSet<Pair> tset;
    class Pair{
        int count;
        String key;
        Pair(int count, String key){
            this.count = count;
            this.key = key;
        }
    }

    public AllOne() {
        hmap = new HashMap<>();
        tset = new TreeSet<>((a, b) -> a.count == b.count ? a.key.compareTo(b.key) : a.count-b.count);
        
    }
    
    public void inc(String key) {
        hmap.put(key, hmap.getOrDefault(key, 0)+1);
        int temp = hmap.get(key);
        tset.remove(new Pair(temp-1, key));
        tset.add(new Pair(temp, key));
    }
    
    public void dec(String key) {
        int temp = hmap.get(key);
        
        tset.remove(new Pair(temp, key));
        
        if(temp == 1){
            hmap.remove(key);
        }
        else{
            hmap.put(key, temp-1);
            tset.add(new Pair(temp-1, key));
        }
        
    }
    
    public String getMaxKey() {
        if(tset.isEmpty())return "";
        
        return tset.last().key;
    }
    
    public String getMinKey() {
        if(tset.isEmpty()) return "";
        return tset.first().key;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */