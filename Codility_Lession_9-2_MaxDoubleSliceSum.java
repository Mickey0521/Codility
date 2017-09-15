package MaxDoubleSliceSum;

class Solution {
    public int solution(int[] A) {

        // (X, Y, Z)
        // 1st slice: A[X+1] + ... + A[Y-1] 
        // 2nd slice: A[Y+1] + ... + A[Z-1]
        // Key Point:
        // The array will be split at "Y" 
        
        // main idea:
        // if the middle point is "Y",
        // find "maxLeft" and "maxRight"
        
        int maxLeft[] = new int[A.length];
        int maxRight[] = new int[A.length];
        
        // 1) find "maxLeft"
        // maxLeft[i] is the maximum sum "contiguous subsequence" ending at index i 
        // note: because it is "contiguous", we only need the ending index (important)
        for(int i=1; i< A.length ;i++){   // be careful: from i=1 (because of maxLeft[i-1])
            maxLeft[i] = Math.max(0, maxLeft[i-1]+A[i] ); //golden slice algorithm: Math.max(0, maxLeft[i-1]+A[i] )
        } 
        
        // 2) find "maxRight"
        // maxRight[i] is the maximum sum "contiguous subsequence" starting at index i 
        // note: because it is "contiguous", we only need the starting index (important)
        for(int i=A.length-2; i >=0; i--){   // be careful: from i=A.length-2 (because of maxLeft[i+1])
            maxRight[i] = Math.max(0, maxRight[i+1]+A[i] ); //golden slice algorithm: Math.max(0, maxRight[i+1]+A[i] )
        } 
        
        // 3) find the maximum of "maxLeft + maxRight"
        int maxDoubleSlice =0;
        for(int i=1; i < A.length-1; i++){ // where "i" means "Y" in this problem
            if(maxLeft[i-1] + maxRight[i+1] > maxDoubleSlice)   // be careful: left end at "i-1" and right begins at "i+1"
                maxDoubleSlice = maxLeft[i-1] + maxRight[i+1];  // be careful: "not" maxLeft[i] + maxRight[i]
        } 
        
        return maxDoubleSlice;
    }
}
