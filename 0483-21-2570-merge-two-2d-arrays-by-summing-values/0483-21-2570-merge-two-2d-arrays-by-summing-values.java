class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]> finalAns = new ArrayList<>();

        TreeMap<Integer, Integer> hmap = new TreeMap<>();
        for(int i=0; i<nums1.length; i++){
            hmap.put(nums1[i][0], hmap.getOrDefault(nums1[i][0], 0) + nums1[i][1]);
        }

        for(int i=0; i<nums2.length; i++){
            hmap.put(nums2[i][0], hmap.getOrDefault(nums2[i][0], 0) + nums2[i][1]);
        }
        for(Map.Entry<Integer, Integer> entry: hmap.entrySet()){
            finalAns.add(new int[]{entry.getKey(), entry.getValue()});
        }
        return finalAns.toArray(new int[0][]);
    }
}