class Solution {
    static String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    
    static String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    static String[] thousands = {"", "Thousand", "Million", "Billion"};
    
    public String func(int num){
        if(num==0) return "";
        else if(num < 20){
            return ones[num] + " ";
        }
        else if(num < 100){
            return tens[num/10]+ " " + func(num%10);
        }
        else{
            return ones[num/100] + " Hundred " + func(num%100);
        }  
    }
    
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        String finalAns = "";
        int pointer = 0;
        while(num > 0){
            if(num % 1000 != 0){
                finalAns = func(num%1000) + thousands[pointer]+" "+finalAns;
            }
            num = num/1000;
            pointer++;
        }
        return finalAns.trim();
        
        
    }
}