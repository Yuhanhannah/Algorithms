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
        while(!stack1.isEmpty()){
            int currentMin = Integer.MAX_VALUE;
            //push all of the elements from stack1 to stack2 and get the cur min value(unsorted);
            while(!stack1.isEmpty()){
                int temp = stack1.pop();
                currentMin = Math.min(temp, currentMin);
                stack2.push(temp);
            }
            //push back all of the elements from stack 2 to stack1 except the current min and the sorted elements
            //get the count of the min value
            //int count = 0;
            while(!stack2.isEmpty()){
                int temp = stack2.peek();
                if(temp < currentMin){
                    break;
                }else if(temp == currentMin){
                    stack2.pop();
                }else{
                    stack1.push(stack2.pop());
                }
            }
            //push the min value to stack 2
            stack2.push(currentMin);
        }
        while(!stack2.isEmpty()){
            result.add(stack2.pop());
         }
        Collections.reverse(result);
        return result;
    }
}