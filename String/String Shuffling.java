public class Main {

    public static void main(String[] args) {
	// write your code here
        //A1B2C3D4E567890 -> ABCD 1234
        //Merge Sort
        String input = "A1B2C3D4";
        char[] output = shuffling(input);
        for(char outputChar : output) {
            System.out.println(outputChar);
        }


    }
    private static char[] shuffling(String input) {
        char[] chars = input.toCharArray();
        mergeSort(chars, 0, chars.length - 1);
        return chars;
    }
    private static void mergeSort(char[] chars, int left, int right) {
        //base case
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(chars, left, mid);
        mergeSort(chars, mid + 1, right);
        merge(chars, left, mid, right);
    }
    private static void merge(char[] chars, int left, int mid, int right) {
        int p1 = left;
        int p2 = mid + 1;
        int index = 0;
        char[] helper = new char[right - left + 1];
        while (p1 <= mid || p2 <= right) {
            if (p2 > right || p1 <= mid && 'A' <=chars[p1] && chars[p1] <= 'Z') {
                helper[index++] = chars[p1++];
            } else if (p1 > mid || p2 <= right && 'A' <= chars[p2] && chars[p2] <= 'Z') {
                helper[index++] = chars[p2++];
            } else if (p1 <= mid) {
                helper[index++] = chars[p1++];
            } else if(p2 <= mid) {
                helper[index++] = chars[p2++];
            }
        }
        System.arraycopy(helper, 0, chars, left, right - left + 1);
    }
}