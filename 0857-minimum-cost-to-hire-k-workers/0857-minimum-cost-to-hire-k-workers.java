class Solution {
    class Tuple{
        int wage;
        int quality;
        double ratio;
        Tuple(int wage, int quality, double ratio){
            this.wage = wage;
            this.quality = quality;
            this.ratio = ratio;
        }
    }
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        double finalAns = 0;
        Tuple[] arr = new Tuple[wage.length];
        for(int i=0; i<wage.length; i++){
            double ratio = (double) wage[i]/ quality[i];
            arr[i] = new Tuple(wage[i], quality[i], ratio);
        }
        
        Arrays.sort(arr, (a,b)-> Double.compare(a.ratio, b.ratio));
        
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> b.quality - a.quality);
        int sum = 0;
        for(int i=0; i<=k-1; i++){
            pq.offer(arr[i]);
            sum+=arr[i].quality;
        }
        
        
        finalAns = arr[k-1].ratio * sum;
        
        for(int i=k; i<arr.length; i++){
            double ratio = arr[i].ratio;
            pq.offer(arr[i]);
            sum+=arr[i].quality;
            
            if(pq.size() > k){
                Tuple temp = pq.peek();
                pq.poll();
                sum = sum - temp.quality;
            }
            finalAns = Math.min(finalAns, ratio * sum);
            
        }
        return finalAns;
        // return 1;
        
    }
}