class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if(arr == null || arr.length == 0){
            return result;
        }else if(x <= arr[0]){
           for(int i = 0; i < k; i++){
               result.add(arr[i]);
           }
            
            return result;
        }else if(x >= arr[arr.length - 1]){
            for(int i = arr.length - k; i < arr.length; i++){
               result.add(arr[i]);
           }
            return result;
        }
        int xPos = findCloest(arr, x);
        int left = xPos;
        int right = xPos + 1 <= arr.length - 1 ? xPos + 1 : arr.length - 1;
        
        for(int i = 0; i < k; i++){
             if(right > arr.length - 1 || left >= 0 && x - arr[left] <= arr[right] - x){
                result.add(arr[left]);
                left--;;
            }else{
                result.add(arr[right]);
                right++;
            }
        }
    
        Collections.sort(result); 
        return result;
    }
    
    private int findCloest(int[] arr, int target){
        int left = 0, right = arr.length - 1;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] < target){
                left = mid;
            }else{
                right = mid;
            }
        }
        return target - arr[left] < arr[right] - target ? left : right;
    }
}