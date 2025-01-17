class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int[] original = new int[derived.length];
        original[0] = 0;
        for(int i=0; i<derived.length-1; i++){
            original[i+1] = original[i] ^ derived[i];
        }

        if((original[derived.length-1] ^ original[0]) == derived[derived.length-1]){
            return true;

        }

        original[0] = 1;
        for(int i=0; i<derived.length-1; i++){
            original[i+1] = original[i] ^ derived[i];
        }
        if((original[derived.length-1] ^ original[0]) == derived[derived.length-1]){
            return true;
        }
        return false;
    }
}