package TapeEquilibrium;

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        
        // Using the concept of Sum
        // and, (sum of the 2nd part) = Sum - (sum of the 1st part)
        // importantly, difference = |(sum of the 2nd part) - (sum of the 1st part)|
        
        // First, compute the sum (will be used for several times)
        int sum =0; // initial
        for(int i=0; i< A.length; i++){
            sum = sum + A[i];
        }
        
        // then, find the minimum difference
        int min_diff = Integer.MAX_VALUE;  // initial setting: Integer.MAX_VALUE
        
        int sum_part_one =0;
        int sum_part_two =0;
        int diff =0;
        
        // try to compute the above values in "one pass"!
        // for the possible partition-point P
        for(int p =1; p< A.length; p++){
            /* no need to use the second for loop (important)
            for(int j=0; j< p; j++){ // to compute the sum of the 1st part
                sum_part_one = sum_part_one + A[j];
            }
            */
            sum_part_one = sum_part_one + A[p-1];   // the sum of part one
            sum_part_two = sum - sum_part_one;      // the sum of part two
            diff = sum_part_one - sum_part_two;     // the difference
            if(diff <0)                             // absolute value
                diff = -diff;                       // all the values can be computed (one pass)
            
            min_diff = Math.min(min_diff, diff);    // min difference
        }
        return min_diff; // return the min difference   
    }
}
