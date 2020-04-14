 public static String charDeDuplication(String input) {
       if (input == null || input.length() == 0) {
           return input;
       }
       int slow = 0;
       int fast = 1;
       char[] arr = input.toCharArray();
       while (fast < arr.length) {
           if (arr[fast] == arr[slow]) {
               fast++;
           } else {
               arr[++slow] = arr[fast++];
           }
       }
       return new String(arr, 0, slow);
    }