class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int XOR=0;
        if(nums1.length%2 != 0){
            for(int i=0; i<nums2.length; i++){
                XOR ^=nums2[i];
            }
        }
        if(nums2.length%2 != 0){
            for(int i=0; i<nums1.length; i++){
                XOR^=nums1[i];
            }
        }
        return XOR;
    }
}