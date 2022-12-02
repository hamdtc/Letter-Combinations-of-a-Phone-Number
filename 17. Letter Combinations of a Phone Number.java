class Solution {
    public List<String> letterCombinations(String digits) {
        //we have to store the char in some where either map or array
        // 0 and 1 are blank
        String []chars=new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","xywz"};
        
        //now output should be a list may linked list also work,like queue
        List<String> ans= new LinkedList<>();
        
         // if digits=0 then nothing to add
        if(digits.length()==0) return ans;
        
        // we have to do backtracking for this fn, because we will find each possibilities
        //here we pass new "" to add into ans
        //0 which we pass to start from 0th index
        backTracking(chars,digits,ans,0,"");
        return ans;
        
    }
    
    static void backTracking(String[] chars,String digits, List<String> ans,int i, String toAdd){
        // base case is when i reaches digits end then add to ans
        //if i==digit length, then there no element in digit strings (out of bound) 
        if(i==digits.length()){
            ans.add(toAdd);
            return;
        }
        
        //taking integer for the string which we want to iterate from chars
        String curr=chars[Character.getNumericValue(digits.charAt(i))];
        
        //iterate through the value we get
        for(int j=0;j<curr.length();j++){
            toAdd+=curr.charAt(j);
            backTracking(chars,digits,ans,i+1,toAdd);
            
            // if we finish with one character we have to remove and from back again so
            toAdd=toAdd.substring(0,toAdd.length()-1);
        }
        
    }
}

