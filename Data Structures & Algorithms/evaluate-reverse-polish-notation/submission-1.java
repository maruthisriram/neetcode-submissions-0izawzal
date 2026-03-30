class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for(String token:tokens){
            if(token.contentEquals("+")){
                String o1 = stack.pop();
                String o2 = stack.pop();
                stack.push(String.valueOf(Integer.valueOf(o2) + Integer.valueOf(o1)));
            }

            
            else if(token.contentEquals("-")){
                String o1 = stack.pop();
                String o2 = stack.pop();
                stack.push(String.valueOf(Integer.valueOf(o2) - Integer.valueOf(o1)));
            }

            
            else if(token.contentEquals("*")){
                String o1 = stack.pop();
                String o2 = stack.pop();
                stack.push(String.valueOf(Integer.valueOf(o2) * Integer.valueOf(o1)));
            }

            
            else if(token.contentEquals("/")){
                String o1 = stack.pop();
                String o2 = stack.pop();
                stack.push(String.valueOf(Integer.valueOf(o2) / Integer.valueOf(o1)));
            }else{
                stack.push(token);
            }
        }

        return Integer.valueOf(stack.pop());

    }
}
