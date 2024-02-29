class Solution {
    class Pair{
        int p1;
        int p2;
        Pair(int p1, int p2){
            this.p1 = p1;
            this.p2 = p2;
        }
    }
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        // Arrays.sort(meetings, (a, b)->a[2]<b[2]);

        boolean[] checkVisited = new boolean[n];
        checkVisited[0] = true;
        checkVisited[firstPerson] = true;

        TreeMap<Integer, List<Pair>> timeMap = new TreeMap<>();
        for(int [] meeting: meetings){
            if(!timeMap.containsKey(meeting[2])){
                timeMap.put(meeting[2], new ArrayList<Pair>());
            }
            timeMap.get(meeting[2]).add(new Pair(meeting[0], meeting[1]));
        }

        for(Map.Entry<Integer, List<Pair>> entry: timeMap.entrySet()){
            int time = entry.getKey();
            List<Pair> lst = entry.getValue();
            HashMap<Integer, List<Integer>> graph = new HashMap<>();
            Queue<Integer> q = new LinkedList<Integer>();
            HashSet<Integer> hset = new HashSet<>();

            for(Pair temp: lst){
                int p1 = temp.p1;
                int p2 = temp.p2;
                if(!graph.containsKey(p1)){
                    graph.put(p1, new ArrayList<>());
                }
                if(!graph.containsKey(p2)){
                    graph.put(p2,new ArrayList<>());
                }
                graph.get(p1).add(p2);
                graph.get(p2).add(p1);
                if(checkVisited[p1] == true && !hset.contains(p1)){
                    q.add(p1);
                    hset.add(p1);
                }
                if(checkVisited[p2] == true && !hset.contains(p2)){
                    q.add(p2);
                    hset.add(p2);
                }
            }

            while(!q.isEmpty()){
                int p = q.peek();
                q.poll();
                List<Integer> nbrList = graph.getOrDefault(p, Collections.emptyList());
                for(int nbr: nbrList){
                    if(checkVisited[nbr] == false){
                        checkVisited[nbr] = true;
                        q.add(nbr);
                    }
                }

            }

        }
        List<Integer> finalAns = new ArrayList<>();
        for(int i=0; i<checkVisited.length; i++){
            if(checkVisited[i] == true){
                finalAns.add(i);
            }
        }
        return finalAns;



    }
}