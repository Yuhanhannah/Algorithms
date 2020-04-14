    public static String removeSpaces(String input) {
        if (input == null || input.length() == 0) {
            return "wrong";
        }
        char[] array = input.toCharArray();
        int slow = 0;
        int fast = 0;
        int wordCount = 0;
        while (fast < array.length) {
            while (fast < array.length && array[fast] == ' ') {
                fast++; //1. skip all the ' ' in front of each word
            }
            if (fast == array.length) {
                break;
            }
            if (wordCount > 0) {
                array[slow++] = ' '; // add ' ' in front of 2nd+ word
            }
            while (fast < array.length && array[fast] != ' ') {
                array[slow++] = array[fast++]; //copy a word
            }
            wordCount++;
        }
        return new String(array, 0, slow);
    }