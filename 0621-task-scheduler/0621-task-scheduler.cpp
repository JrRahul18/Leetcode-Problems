class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        vector<int> storeChar(26, 0);
        int finalAns = 0;
        priority_queue<int> pq;
        
        for(char &ch: tasks){
            storeChar[ch-'A']++;
        }
        for(int i=0; i<26; i++){
            if(storeChar[i] > 0){
                pq.push(storeChar[i]);
            }
        }
        while(!pq.empty()){
            vector<int> count;
            for(int i=1; i<=n+1; i++){
                if(!pq.empty()){
                    int val = pq.top();
                    pq.pop();
                    val--;
                    count.push_back(val);
                }
            }
            
            for(int &num: count){
                if(num>0){
                    pq.push(num);
                }
            }
            if(pq.empty()){
                finalAns +=count.size();
            }
            else{
                finalAns += n+1;
            }
        }
        return finalAns;
        
    }
};