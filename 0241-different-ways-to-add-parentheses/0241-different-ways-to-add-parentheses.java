class Solution {
    List<Integer> finalAns;
    public List<Integer> solve(String s){
        
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '+' || ch == '-' || ch =='*'){
                List<Integer> left = solve(s.substring(0, i));
                List<Integer> right = solve(s.substring(i+1, s.length()));
                
                for(int a: left){
                    for(int b: right){
                        if(ch == '+') ans.add(a+b);
                        else if(ch == '-') ans.add(a-b);
                        else ans.add(a*b);
                    }
                }
            }
        }
        if(ans.isEmpty()) ans.add(Integer.parseInt(s));
        return ans;
    }
    public List<Integer> diffWaysToCompute(String expression) {
        return solve(expression);
        
    }
}