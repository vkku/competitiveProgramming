package me.vkku.arrays;

import java.io.IOException;

class MaxOccurence {
    public int findNumbers(int[] nums) {

        int count = 0;
        for (int n : nums) {
            count += 1 & (int) Math.log10(n);
        }
        return count;

   }

    /*//Driver
    public static void main(String[] args) throws IOException {
        int ar[] = {12,345,2,6,7896};
        MaxOccurence m = new MaxOccurence();
        System.out.println(m.findNumbers(ar));
    }*/
}