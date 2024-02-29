class Solution {
    class DSU{
        int[] parentArray;
        int[] size;
        int count;
        public DSU(int n){
            parentArray = new int[n];
            size = new int[n];
            count = n;
            for(int i=0; i<n; i++){
                parentArray[i] = i;
                size[i] = i;

            }
        }
        public int find (int x){
            if(x == parentArray[x]){
                return x;
            }
            return parentArray[x] = find(parentArray[x]);
        }
        public void union(int x, int y){
            int parent_x = find(x);
            int parent_y = find(y);
            if(parent_x == parent_y){
                return;
            }
            if(size[parent_x] > size[parent_y]){
                parentArray[parent_y] = parent_x;
                size[parent_x] += size[parent_y];
            }
            else if(size[parent_x] < size[parent_y]){
                parentArray[parent_x] = parent_y;
                size[parent_y]+=size[parent_x];
            }
            else{
                parentArray[parent_x] = parent_y;
                size[parent_y]+= size[parent_x];
            }
            count -=1;
        }
        public int maxSize(){
            return count;
        }
    }
    public boolean canTraverseAllPairs(int[] nums) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        DSU dsu = new DSU(nums.length);
        for(int i=0; i<nums.length; i++){
            for(int factor = 2; factor*factor <= nums[i]; factor++){
                if(nums[i]% factor != 0){
                    continue;
                }
                if(!hmap.containsKey(factor)){
                    hmap.put(factor, i);
                }
                else{
                    int idx = hmap.get(factor);
                    dsu.union(idx, i);
                }
                while(nums[i] % factor == 0){
                    nums[i] = nums[i]/factor;
                }
            }
            if(nums[i]>1){
                if(!hmap.containsKey(nums[i])){
                    hmap.put(nums[i], i);
                }
                else{
                    int idx = hmap.get(nums[i]);
                    dsu.union(idx, i);
                }
            }
        }
        if(dsu.maxSize() != 1){
            return false;
        }
        return true;
    }
}