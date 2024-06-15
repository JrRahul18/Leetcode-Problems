class Solution {
    class Pair{
        int capital;
        int profit;
        Pair(int capital, int profit){
            this.capital = capital;
            this.profit = profit;
        }
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        List<Pair> projects = new ArrayList<>();
        int finalAns=w;
        for(int i=0; i<profits.length; i++){
            projects.add(new Pair(capital[i], profits[i]));
        }
        Collections.sort(projects, ((a, b)-> (a.capital-b.capital)));
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->b.profit-a.profit);
        
        int i=0;
        while(k>0){
            while (i<projects.size() && projects.get(i).capital <= finalAns) {
                pq.add(projects.get(i));
                i++;
            }
            if(pq.isEmpty())break;
            finalAns+= pq.peek().profit;
            pq.poll();
            k--;
            
        }
        return finalAns;
    }
}