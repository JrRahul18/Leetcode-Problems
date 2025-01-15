class Solution {
    public boolean isSet(int x, int bit){
        return (x & (1 << bit) ) != 0;
    }
    public int setBit(int x, int bit){
        return x | (1 << bit);
    }
    public int unsetBit(int x, int bit){
        return x & (~(1 << bit));
    }
    public int minimizeXor(int num1, int num2) {
        int finalAns = num1;
        int targetSetBit = Integer.bitCount(num2);
        int currentSetBit = Integer.bitCount(num1);

        int bit = 0;

        if(currentSetBit < targetSetBit){
            while(currentSetBit < targetSetBit){
                if(!isSet(finalAns, bit)){
                    finalAns = setBit(finalAns, bit);
                    currentSetBit++;
                }
                bit++;
            }
        }
        else if(currentSetBit > targetSetBit){
            while(currentSetBit > targetSetBit){
                if( isSet(finalAns, bit)){
                    finalAns = unsetBit(finalAns, bit);
                    currentSetBit--;
                }
                bit++;
            }
        }
        return finalAns;

    }
}