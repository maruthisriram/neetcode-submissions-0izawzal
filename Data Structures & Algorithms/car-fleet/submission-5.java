class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        HashMap<Integer, Integer> positionToSpeed = new HashMap<>();
        for(int i=0;i<position.length;i++){
            positionToSpeed.put(position[i], speed[i]);
        }
        Stack<Double> stack = new Stack<>();
        Arrays.sort(position);
        
        
        for(int i = position.length - 1;i>=0;i--){
            int p = position[i];
            double time = (target - p)/(double) positionToSpeed.get(p);
            stack.push(time);
             if (stack.size() >= 2 &&
                stack.peek() <= stack.get(stack.size() - 2))
            {
                stack.pop();
            }
        }

        return stack.size();
        
    }
}
