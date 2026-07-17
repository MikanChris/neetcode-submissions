class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < tokens.length; i++){ 
            String token = tokens[i];         
            if(!token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/")){
                int num = Integer.parseInt(token);
                stack.push(num);
            }else{               
                
                if(token.equals("+")){
                    int a = stack.peek();
                    stack.pop();
                    int b = stack.peek() + a;
                    stack.pop();
                    stack.push(b);
                }if(token.equals("-")){
                    int a = stack.peek();
                    stack.pop();
                    int b = stack.peek() - a;
                    stack.pop();
                    stack.push(b);
                }if(token.equals("*")){
                    int a = stack.peek();
                    stack.pop();
                    int b = stack.peek() * a;
                    stack.pop();
                    stack.push(b);
                }if(token.equals("/")){
                    int a = stack.peek();
                    stack.pop();
                    int b = stack.peek() / a;
                    stack.pop();
                    stack.push(b);
                }
            }
        }

        return stack.pop();
    }
}
