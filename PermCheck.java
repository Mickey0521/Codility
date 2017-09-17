package PermCheck;

import java.util.*;
// note: remember to import (when using some data structures)

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        
        // to check "permutation"
        // the main idea is as follows:
        // 1. use set to remember which elements have appeared
        // 2. use "for loop" to check if all the elements from "1 to A.length" appeared
        // If all the elements have appeared, then "yes".
        // Otherwise, "no".
        
        Set<Integer> set = new HashSet<Integer>();
        
        for(int i=0; i < A.length; i++){
            set.add(A[i]);
        }
        
        // check if "all" the elements from "1 to A.length" appeared
        for(int i=1; i<= A.length; i++){
            if( set.contains(i) == false )
                return 0; // not a permutation (A[i] is missing)
        }
        
        // if it contains all the elements (from "1 to A.length")
        // then, "yes"
        return 1;       
    }
}
