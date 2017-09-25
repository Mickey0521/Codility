package NumberSolitaire;

class Solution {
    public int solution(int[] A) {

        // main idea:
        // using "dynamic programming" to build up the solution
        // (bottom up)
        
        int[] dp = new int[A.length];
        dp[0] = A[0];

        // build up from "dp[1], dp[2], ..., dp[A.length-1]"
        for(int i=1; i<A.length; i++){
            
            // keep the biggest one 
            // be very careful: could be negtive (so use Integer.MIN_VALUE)
            int max = Integer.MIN_VALUE;
            
            // a die could be "1 to 6" 
            for(int die=1; die<=6; die++){
                if( i-die >= 0){
                    // very important: not "A[i-die]+A[i]"
                    // instead, have to use "dp[i-die]+A[i]"
                    max = Math.max( dp[i-die]+A[i], max );
                    // dynamic programming:
                    // take the best:
                    // takeBest( dp[i-j] + value[j], curBest )
                }
            }    
            dp[i] = max; // keep the best one as the dp value    
        }
        
        return dp[A.length-1];
    }
}
