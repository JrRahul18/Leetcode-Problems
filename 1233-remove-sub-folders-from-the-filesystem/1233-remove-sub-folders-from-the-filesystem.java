class Solution {
    public List<String> removeSubfolders(String[] folder) {
        HashSet<String> hset = new HashSet<>();
        List<String> finalAns = new ArrayList<>();
        for(String str: folder){
            hset.add(str);
        }
        
        for(String f: folder){
            String temp = f;
            boolean check = false;
            while(temp.length() != 0){
                int idx = temp.lastIndexOf('/');
                if(idx == -1) break;
                
                temp = temp.substring(0, idx);
                if(hset.contains(temp)){
                    check = true;
                    break;
                }
            }
            if(check == false) finalAns.add(f);
        }
        return finalAns;
    }
}