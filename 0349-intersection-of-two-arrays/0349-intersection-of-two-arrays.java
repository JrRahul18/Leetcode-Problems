class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hset = new HashSet<>();
        for(int num: nums1){
            hset.add(num);
        }
        List<Integer> store = new ArrayList<>();
        for(int num: nums2){
            if(hset.contains(num)){
                hset.remove(num);
                store.add(num);
            }
        }
        int[] finalAns = new int[store.size()];
        for(int i=0; i<finalAns.length; i++){
            finalAns[i] = store.get(i);
        }
        return finalAns;
    }
}