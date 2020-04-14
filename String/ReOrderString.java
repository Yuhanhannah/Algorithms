package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //A1B2C3D4e567890 -> ABCD 1234
        //Merge Sort
        String input = "ABCDE12345";
        char[] output = shuffling(input);
        for(char outputChar : output) {
            System.out.println(outputChar);
        }


    }
    private static char[] shuffling(String input) {
        char[] chars = input.toCharArray();
        if (chars.length % 2 == 1) {
            convert(chars, 0, chars.length - 2);
        } else {
            convert(chars, 0, chars.length - 1);
        }
        
        return chars;
    }
    private static void convert (char[] chars, int left, int right) {
        int size = right - left + 1;
        if (size <= 2) {
            return;
        }
        int mid = left + size / 2;
        int leftMid = left + size / 4;
        int rightMid = left + size * 3 / 4;

        //reverse
        reverse(chars, leftMid, mid - 1);
        reverse(chars, mid, rightMid - 1);
        reverse(chars, leftMid, rightMid - 1);

        convert(chars, left, left + 2 * (leftMid - left) - 1);
        convert(chars, left + 2 * (leftMid - left), right);
    }

    private static void reverse (char[] chars, int left, int right) {
        while (left <= right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }

    }
}
