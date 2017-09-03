// Codility Lession 6 
// NumberOfDiscIntersections
// note: need to import (to use "Arrays.sort(int[])" )
import java.util.*;

// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        
        // main idea:
        // 1. store all the "lower points" and "upper points" of the discs
        // 2. count the intersections (if one upper point > one lower point)
        
        // note: use "long" for big numbers (be careful)
        long[] lower = new long[A.length];
        long[] upper = new long[A.length];
        
        for(int i=0; i<A.length; i++){
            lower[i] = i - (long)A[i]; // note: lower = center - A[i]
            upper[i] = i + (long)A[i]; // note: upper = center + A[i]
        }
        
        // "sort" the "lower points" and "upper points"
        Arrays.sort(upper);
        Arrays.sort(lower);
        
        int intersection = 0; // number of intersections
        int j=0; // for the lower points
        
        // scan the upper points
        for(int i=0; i<A.length; i++){
        
            // for the curent "j" (lower point)
            while( j < A.length && upper[i] >= lower[j]){
                    intersection = intersection + j; // add j intersections
                    intersection = intersection - i; // minus "i" (avoid double count) 
                    j++;
            }          
        }
        
        // for the overflow cases
        if(intersection > 10_000_000)
            return -1;
        
        return intersection; // number of intersections      
    }
}
