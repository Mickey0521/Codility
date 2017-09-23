package CountNonDivisible;

import java.util.*;

class Solution {
    public int[] solution(int[] A) {

        // main idea:
        // using "HashMap" to count 
        
        // map1(key, value)
        HashMap<Integer, Integer> map1 = new HashMap<>();
        // key: the elements, value, count of elements
        for(int i=0; i< A.length; i++){
            if(map1.containsKey(A[i]) == false){
                map1.put(A[i], 1); // add new element
            }
            else{
                 map1.put(A[i], map1.get(A[i])+1 ); // count++
            }
        }
        
        // map2(key, value)
        HashMap<Integer, Integer> map2 = new HashMap<>();
        // key: the elements, value, count of "number of non-divisors" of elements
        for( int n : map1.keySet() ){            
            int numDivisors =0;
            // find divisors from 1 to sqrt(n)
            int sqrtN = (int)Math.sqrt(n);  
            for(int i=1; i<=sqrtN; i++ ){
                if( n % i == 0){ // means: i could be a divisor
                    int anotherDivisor = n/i; 
    
                    if(map1.containsKey(i) == true ){
                        numDivisors = numDivisors + map1.get(i);
                    }
                    if(anotherDivisor != i){ // avoid double count (be careful)
                        if(map1.containsKey(anotherDivisor) == true){
                            numDivisors = numDivisors + map1.get(anotherDivisor);
                        }
                    }
                }
            }
            
            int numNonDivisors = A.length - numDivisors;
            map2.put(n, numNonDivisors); 
        }
        
        // results: number of non-divisors
        int[] results = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            results[i] = map2.get(A[i]);
        }

        return results;
    }
}
