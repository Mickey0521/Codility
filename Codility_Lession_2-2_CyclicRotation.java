class CyclicRotation {
    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        
        // Using the concept of "mod" (to make it cyclic)
        
        int[] new_array = new int[A.length]; // a new array
        
        for(int i=0; i< A.length; i++){
            int new_position = (i + K) % A.length; // using "mod" to do Cyclic Rotation           
            new_array[new_position] = A[i]; // put A[i] to the new position
        }
        
        return new_array; // return new array
    }
}
