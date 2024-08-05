class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> hmap = new HashMap<>();
        for(String str: arr){
            hmap.put(str, hmap.getOrDefault(str, 0)+1);
        }
        int count=0;
        for(String str: arr){
            if(hmap.get(str) == 1){
                count++;
            }
            if(count == k){
                return str;
            }
        }
        return "";
    }
}