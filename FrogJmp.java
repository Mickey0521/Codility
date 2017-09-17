package FrogJmp;

class Solution {
    public int solution(int X, int Y, int D) {
        // write your code in Java SE 8
        
        long difference = Y - X;
        
        long plus =0; // note: need to decide if to "plus one" or not
        
        if( difference % D !=0 ) // using "mod" to decide
            plus =1;             // if not "perfectly Divisible", then plus one 
        
        long hop =0; // number of hops the frog needs to jump
        
        hop = difference / D;
        
        hop = hop + plus;
        
        return (int)hop; // return number of hops (long -> int)
    }
}
