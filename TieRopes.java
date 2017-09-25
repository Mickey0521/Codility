package TieRopes;

class Solution {
    public int solution(int K, int[] A) {

        // notice that only "adjacent ropes" can be tied
        // so, the problem is simple; we can use "greedy" method
        
        int total =0;
        int currentLength=0;
        
        for(int i=0; i<A.length; i++){
            currentLength = currentLength + A[i];
            if(currentLength >= K){
                total++;
                currentLength=0; // update
            }
        }
        return total;
    }
}
