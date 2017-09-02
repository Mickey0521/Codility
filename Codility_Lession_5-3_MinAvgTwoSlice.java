// you can also use imports, for example:
// import java.util.*;

class Solution {
    public int solution(int[] A) {

        // main idea:
        // we know from the problem description 
        // that the slices have a minimum length of 2.
        // The trick to this problem is 
        // that the min average slice has "the length of 2 or 3"
        // So, we only need to calculate the avg of the slices of length 2 and 3

        // note: return the start position (of the min average slice)
        
        // note: because we will use "/", we need to use "float" (not "int")
        float min = Integer.MAX_VALUE; 
        int min_start_position =0;   // to store the start position
        
        // note: for "i< A.length -2"
        for(int i=0; i< A.length -2; i++){  
            
            // note: need to use "float"
            float avg_2 = (float) (A[i]+A[i+1])/2;         // avg of length of 2
            float avg_3 = (float) (A[i]+A[i+1]+A[i+2])/3;  // avg of length of 3
            
            // for debugging
            // System.out.println(i + " " + avg_2 + " " + avg_3);
            
            // take the smaller one
            float cur_min_avg = Math.min(avg_2, avg_3);
            
            // keep the smallest one
            if(cur_min_avg < min){
                min = cur_min_avg;
                min_start_position = i;
            }
        }
        
        // note: for the last missing case
        // case: avg of length of 2 "A[A.length-2] + A[A.length-1]"
        int avg_2 = (A[A.length-2]+A[A.length-1]) / 2;
        if( avg_2 < min){
             min = avg_2;
             min_start_position = A.length-2;
        }
        
        return min_start_position;       
    }
}
