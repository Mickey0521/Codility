package FrogRiverOne;

import java.util.*;

class Solution {
    public int solution(int X, int[] A) {
        // write your code in Java SE 8
        
        // the main ideas:
        // 1. create a "set", and put "1~X" into the set first.
        // 2. when a number matches a number in the set, 
        //    then remove the number from the set.
        // 3. when the set becomes "empty",
        //    all the numbers "1~X" have appeared
        
        Set<Integer> set = new HashSet<Integer>();
        
        // put "1~X" into the set first
        for(int i=1; i<= X; i++){
            set.add(i);
        }
        
        for(int i=0; i< A.length; i++){
            if( set.contains(A[i]) == true ){ // when a number appears,
                set.remove(A[i]);             // then, remove it from the set
            }
            if(set.isEmpty() == true){        // nothing in the set
                return i;                     // In second i, "1~X" have all appeared 
            }
        }
        
        // not all the elements "1~X" appeared
        return -1;
    }
}
