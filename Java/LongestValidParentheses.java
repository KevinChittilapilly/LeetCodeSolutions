class Solution {
    public int longestValidParentheses(String s) {
        if(s.equals("")||s==null){
            return 0;
        }
        Stack<Character> parentheses=new Stack<Character>();
        
       // ArrayList<Integer> totalCount=new ArrayList<Integer>();
        Stack<Integer> index=new Stack<Integer>();
        index.add(-1);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                parentheses.add('(');
                index.add(i);
            }
            else{
                if(parentheses.size()>0&& parentheses.peek()=='('){
                    parentheses.pop();
                    index.pop();
                }
                else{
                parentheses.add(')');
                index.add(i);
                }
            }
        }
        index.add(s.length());
        if(index.size()==1){
            return index.peek();
        }
        int max_len=-1;
        while(index.size()!=1){
            int x=index.peek();
            index.pop();
            int y=index.peek();
           // index.pop();
            int ans=x-y-1;
            if(ans>max_len){
                max_len=ans;
            }
            //totalCount.add(ans);
        }
        //System.out.println(parentheses);
        //System.out.println(index);
        //System.out.println(totalCount);

        return max_len;
    }
}