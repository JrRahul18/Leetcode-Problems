class Solution {
public:
    int findMinArrowShots(vector<vector<int>>& points) {
        int n = points.size();
        sort(begin(points), end(points));
        
        vector<int> prevPoint = points[0];
        int finalAns = 1;
        
        for(int i=1; i<points.size(); i++){
            if(points[i][0]>prevPoint[1]){
                finalAns++;
                prevPoint = points[i];
            }
            else{
                prevPoint[0] = max(prevPoint[0], points[i][0]);
                prevPoint[1] = min(prevPoint[1], points[i][1]);
            }
        }
        return finalAns;
    }
};