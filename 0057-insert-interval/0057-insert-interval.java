class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int rem = 0;
        for(int [] interval: intervals){
            if(interval[1]< newInterval[0]){
                ans.add(interval);
                rem++;
            }
            else if(interval[0] > newInterval[1]){
                // rem++;
                break;
            }
            else{
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
                rem++;
            }
        }
        ans.add(newInterval);
        while(rem<intervals.length){
            ans.add(intervals[rem]);
            rem++;
        }
        // return ans.toArray(new int[ans.size()][]);
        int[][] finalAns = new int[ans.size()][2];
        for(int i=0; i<finalAns.length; i++){
            finalAns[i][0] = ans.get(i)[0];
            finalAns[i][1] = ans.get(i)[1];
        }
        return finalAns;
        
        
    }
}