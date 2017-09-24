package CountDistinctSlices;

class Solution {
    public int solution(int M, int[] A) {

        // This solution is more clever, and much faster O(n)
        
        // main idea: 
        // use "boolean[]" to record if an integer is already seen 
        // also use "leftEnd" and "rightEnd"
        
        boolean[] seen = new boolean[M+1]; // from 0 to M 
        // Arrays.fill(seen, false); // note: "false" by default
        
        int leftEnd=0;
        int rightEnd=0;
        int numSlice =0;
        
        // key point: move the "leftEnd" and "rightEnd" of a slice
        while(leftEnd < A.length && rightEnd < A.length){
            
            // case 1: distinct (rightEnd)
            if( seen[A[rightEnd]] == false){ 
                // note: not just +1 
                // there could be (rightEnd - leftEnd + 1) combinations (be careful)
                numSlice = numSlice + (rightEnd - leftEnd + 1);
                if(numSlice >= 1_000_000_000)
                    return 1_000_000_000;
                
                // increase the slice to right by "1" (important)
                seen[A[rightEnd]] = true;
                rightEnd++; 
            }
            // case 2: not distinct
            else{ 
                // decrease the slice from left by "1" (important)
                // remove A[leftEnd] from "seen" (be careful)
                seen[A[leftEnd]] = false;
                leftEnd++;
            } 
        }
        
        return numSlice;
    }
}
