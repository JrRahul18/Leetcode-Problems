class Solution {
    public String countOfAtoms(String formula) {
        // String finalAns="";
        Stack<HashMap<String, Integer>> stk = new Stack<>();
        stk.push(new HashMap<String, Integer>());
        
        for(int i=0; i<formula.length(); i++){
            if(formula.charAt(i)=='('){
                stk.push(new HashMap<>());
            }
            else if(formula.charAt(i)==')'){
                HashMap <String, Integer> temp = stk.peek();
                stk.pop();
                
                i++;
                String tempString="";
                while(i<formula.length() && Character.isDigit(formula.charAt(i)) ){
                    tempString+=formula.charAt(i);
                    i++;
                }
                int num=1;
                if(tempString.length() != 0){
                    num = Integer.parseInt(tempString);
                }
                for(String key: temp.keySet()){
                    int val =temp.get(key);
                    val = val*num;
                    temp.put(key, val);
                }
                for(String key: temp.keySet()){
                    int val = temp.get(key);
                    stk.peek().put(key, stk.peek().getOrDefault(key, 0)+val);
                }
                i--;
            }
            else{
                String currentString = "";
                currentString+=formula.charAt(i);
                i++;
                while(i<formula.length() && Character.isLowerCase(formula.charAt(i))){
                    currentString+=formula.charAt(i);
                    i++;
                }
                String currentInt = "";
                while(i<formula.length() && Character.isDigit(formula.charAt(i))){
                    currentInt+=formula.charAt(i);
                    i++;
                }
                int num =1;
                if(currentInt.length()>0){
                    num = Integer.parseInt(currentInt);
                }
                stk.peek().put(currentString, stk.peek().getOrDefault(currentString, 0)+num);
                i--;
            }
        }
        TreeMap<String, Integer> finalMap = new TreeMap<>(stk.peek());
        StringBuilder finalAns = new StringBuilder();
        for(String key: finalMap.keySet()){
            finalAns.append(key);
            int num = finalMap.get(key);
            if(num>1){
                finalAns.append(num);
            }
        }
        return finalAns.toString();
    }
}