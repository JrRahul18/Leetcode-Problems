class NumberContainers {
    HashMap<Integer, Integer> idxToNum;
    HashMap<Integer, PriorityQueue<Integer>> numToIdx;

    public NumberContainers() {
        idxToNum = new HashMap<>();
        numToIdx = new HashMap<>();
    }
    
    public void change(int index, int number) {
        idxToNum.put(index, number);

        if(!numToIdx.containsKey(number)){
            numToIdx.put(number, new PriorityQueue<>((a, b) -> a-b ));
        }
        numToIdx.get(number).add(index);
    }
    
    public int find(int number) {
        if(!numToIdx.containsKey(number)) return -1;

        while(!numToIdx.get(number).isEmpty() ){
            int travIdx = numToIdx.get(number).peek();
            if(idxToNum.get(travIdx) == number){
                return travIdx;
            }
            numToIdx.get(number).poll();
        }
        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */