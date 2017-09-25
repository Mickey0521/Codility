package MaxNonoverlappingSegments;

class Solution {
    public int solution(int[] A, int[] B) {

        // main idea:
        // Using "greedy" method to find non-overlapping segments
        
        // because the segments are sorted by their rightEnds
        // we use "for loop" from rightEnd to left 
        // and just need to keep the "value of leftEnd" (key point)

        // spcial case
        if(A.length==0)
            return 0;
        
        int N = A.length;
        // keep the value of leftEnd: A[i]
        // the 1st segment: A[N-1]
        int currentLeftEnd = A[N-1];
        int numNonOverlap =1;
        
        for(int i=N-2; i >=0; i--){
            // if "rightEnd < leftEnd", nonOverlap++
            // and update the value of leftEnd
            if(B[i] < currentLeftEnd){
                numNonOverlap++;
                currentLeftEnd = A[i];
            }
            // if "leftnEnd is shorter", 
            // update the value of leftEnd (important)
            if(A[i] > currentLeftEnd){
                currentLeftEnd = A[i];
            }
        }
        
        return numNonOverlap;
    }
}
