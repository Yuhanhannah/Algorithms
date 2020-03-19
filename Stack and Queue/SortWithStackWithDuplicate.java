class Solution {
    public List<Integer> sortArray(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return result;
        }
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for(int num : nums){
            stack1.push(num);
        }
        int n = nums.length;
        while(!stack1.isEmpty()){
            int currentMin = Integer.MAX_VALUE;
            //push all of the elements from stack1 to stack2 and get the min value
            while(!stack1.isEmpty()){
                int temp = stack1.pop();
                currentMin = Math.min(temp, currentMin);
                stack2.push(temp);
            }
            //push back all of the elements from stack2 to stack1
            //except the current min
            //push all of the current min to stack2
            int count = 0;
            while(!stack2.isEmpty()){
                int temp = stack2.peek();
                if(temp < currentMin){
                    break;
                }else if(temp > currentMin){
                    stack1.push(stack2.pop());
                }else{
                    stack2.pop();
                    count++;
                }
            }
            //push all of the currentMin to stack2 
            for(int j = 0; j < count; j++){
                stack2.push(currentMin);
            }
        }
        while(!stack2.isEmpty()){
            result.add(stack2.pop());
         }
        Collections.reverse(result);
        return result;
    }
}