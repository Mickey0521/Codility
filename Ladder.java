package Ladder;

class Solution {
    public int[] solution(int[] A, int[] B) {

        // The task is to find out the number of ways 
        // someone can climb up a ladder of N rungs 
        // by ascending one or two rungs at a time.
        // It is not very hard to see that 
        // this number is just the "Fibonacci number of order N"
        
        // we implemented an easy dynamic programming approach 
        // to compute Fibonacci numbers, this will take complexity O(n)
        
        // I use binary operators to keep track of "N modulo 2^{30}" 
        // otherwise. the Fibonacci numbers will cause a memory overflow (be careful~!!)
        // and we are also asked to return "numbers modulo some power of 2"
        
        int L = A.length;
       
        // determine the "max" for Fibonacci
        int max = 0;
        for (int i = 0; i < L; i++) {
            max = Math.max(A[i], max);
        }
        //max += 2; // for Fibonacci
        
        int[] fibonacci = new int[max+1]; // plus one for "0"
        
        // initial setting of Fibonacci (importnat)
        fibonacci[0] =1;
        fibonacci[1] =1;

        for(int i=2; i<= max; i++){
            fibonacci[i] = (fibonacci[i-1] + fibonacci[i-2]) % (1 << 30);
            // we want to find the result of "a number modulo 2^P"
            // if we first let the number modulo 2^Q (Q > P) 
            // then, modulo 2^P, the esult is the same.
            // So, "we first modulo 2^30" to avoid overflow
            // where, 2^30 == 1 << 30 
        }
        
        // to find "results"
        int[] results = new int[L];
        
        for(int i=0; i<L; i++){
            results[i] = fibonacci[A[i]] % (1 << B[i]); // where, "1 << B[i]" means 2^B[i]
        }
        
        return results;
    }
}
