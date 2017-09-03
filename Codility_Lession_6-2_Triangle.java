package Triangle;

// note: need to import (so, we can use "Arrays.sort(int[])")
import java.util.*;

// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {

    // main idea: for any combination (A[i-2], A[i-1], A[i]) 
    // we just need to check if A[i-2] + A[i-1] > A[i] (important)
    // note: A[i-2] + A[i-1] is the max possible combination (needed to check)

        // Using "Arrays.sort(int[])"
        Arrays.sort(A);
        
        // note: start from i=2
        for(int i=2; i< A.length; i++){
            if((long)A[i-2] + (long)A[i-1] > (long)A[i]) // note: using "long" for overflow cases
                return 1; 
            // note: we just need one combination
        }
        
        // otherwise, return 0 (no triangular)
        return 0;
    }
}
