class Solution {
    public String largestNumber(int[] nums) {
        String finalAns = "";
        Integer[] arr = new Integer[nums.length];
        for(int i=0; i<nums.length; i++){
            arr[i] = nums[i];
        }
        Arrays.sort(arr, (a, b) -> {
            String s1 = Integer.toString(a);
            String s2 = Integer.toString(b);
            return (s2 + s1).compareTo(s1 + s2);
        });
        if(arr[0] ==0){
            return "0";
        }
        for(int num: arr){
            finalAns+=num;
        }
        return finalAns;
    }
}