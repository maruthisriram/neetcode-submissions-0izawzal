class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for(int i = 0;i<temperatures.length;i++){
            int temp = temperatures[i];
            if(stack.isEmpty() || temperatures[stack.peek()] >= temp){
                stack.push(i);
            }else{
                while(!stack.isEmpty() && temperatures[stack.peek()]< temp) {
                    res[stack.peek()] = i - stack.pop(); 
                }
                stack.push(i);
            }
        }
        return res;
    }
}
