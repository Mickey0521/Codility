package PermMissingElem;

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        
        // Using the concept of "Sum = (ceiling + floor) * height /2"
        // So---> Sum = (1 + N+1) * N /2
        // the missing element can be found by minus other elements
        
        // note: need to use "long" to avoid potential bugs (large numbers)
        long ceiling = A.length +1;
        long floor = 1;
        long height = A.length + 1; // note: need to plus extra "1" 
                                    // because there is one element "missing"! 
                                    // be careful about this (important)
        long sum = (ceiling +floor) * height /2; // main idea
        /*        
        int high = A.length +1; 
        int low = 1;
        int height = A.length + 1; 
        int sum = (high +low) * height /2; // main idea
        */
        long missing_number = sum; // initial setting (sum)
        
        for(int i=0; i<A.length; i++){
            missing_number = missing_number - A[i]; // minus other elements
        }
        
        return (int)missing_number; // return the missing element (long->int)
    }
}
