class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> lst = new ArrayList<>();
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int num: nums1){
            hmap.put(num, hmap.getOrDefault(num, 0)+1);
        }
        for(int num: nums2){
            if(hmap.containsKey(num)){
                lst.add(num);
                hmap.put(num, hmap.get(num)-1);
                if(hmap.get(num) == 0){
                    hmap.remove(num);
                }
            }
        }
        int [] finalAns = new int[lst.size()];
        for(int i=0; i<lst.size(); i++){
            finalAns[i] = lst.get(i);
        }
        return finalAns;
    }
}