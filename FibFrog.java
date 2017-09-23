package FibFrog;

import java.util.*;
// for using "point" (java.awt.*)
import java.awt.*;

class Solution {
    public int solution(int[] A) {

        // note: cannot use "List" (both java.util.* and java.awt.* have "List")
        ArrayList<Integer> fibonacci = new ArrayList<>();
        fibonacci.add(0); // note: f(0) = 0 (as in the quesion)
        fibonacci.add(1);
        // note: using "while" is better than "for" (avoid errors)
        while(true){
            int temp1 = fibonacci.get( fibonacci.size()-1 );
            int temp2 = fibonacci.get( fibonacci.size()-2 );
            fibonacci.add( temp1 + temp2 ); 
            
            // if already bigger than length, then break;
            if(temp1 + temp2 > A.length){ 
                break;
            }
        }
        
        // reverse "List": from big to small
        Collections.reverse(fibonacci);
        
        // use "queue" with "point"
        // point(x,y) = point("position", "number of steps")
        ArrayList<Point> queue = new ArrayList<>(); 
        queue.add( new Point(-1, 0) ); // position:-1, steps:0
        
        // index: the current index for queue element 
        int index=0; 
        while(true){
            // cannot take element from queue anymore
            if(index == queue.size() ){ 
                return -1;
            }
            
            // take element from queue
            Point current = queue.get(index); 
            
            // from big to small 
            for(Integer n: fibonacci){
                int nextPosition = current.x + n;
                
                // case 1: "reach the other side" 
                if(nextPosition == A.length){ 
                    // return the number of steps
                    return current.y + 1; 
                }
                
                // case 2: "cannot jump"
                // note: nextPosition < 0 (overflow, be careful)
                else if( (nextPosition > A.length) || (nextPosition < 0)|| (A[nextPosition]==0) ){
                    // note: do nothing 
                }
                
                // case 3: "can jump" (othe cases)
                else{
                    // jump to next position, and step+1
                    Point temp = new Point(nextPosition, current.y + 1); 
                    // add to queue
                    queue.add(temp);  
                    
                    A[nextPosition] = 0; // key point: for high performance~!!
                } 
            }
            
            index++; // take "next element" from queue
        }
    }
}
