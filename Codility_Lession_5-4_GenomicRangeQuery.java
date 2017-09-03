class GenomicRangeQuery {
    public int[] solution(String S, int[] P, int[] Q) {
        
        // result: the minimal impact of each query
        int[] result = new int[P.length];

        // to count "A"、"C"、"G"、"T"
        // A[i] means: num of 'a' from 0 to i-1
        int A[] = new int[S.length()+1];
        int C[] = new int[S.length()+1];
        int G[] = new int[S.length()+1];
        int T[] = new int[S.length()+1];
        // note: we use "S.length()+1" 
        // which will let A[0]=0, C[0]=0, G[0]=0, T[0]=0
        // becasue we will compute number of 'a' by "A[Q+1] - A[P]"
        // we actually shift to right by one, and assume the biginning is a dummy '0' 

        // counting ( note: A[0]=0, C[0]=0, G[0]=0, T[0]=0 )
        for (int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == 'A')
            {
                A[i+1] = A[i]+1;
                C[i+1] = C[i];
                G[i+1] = G[i];
                T[i+1] = T[i];
            }
            else if(S.charAt(i) == 'C')
            {
                A[i+1] = A[i];
                C[i+1] = C[i]+1;
                G[i+1] = G[i];
                T[i+1] = T[i];
            }
            else if(S.charAt(i) == 'G')
            {
                A[i+1] = A[i];
                C[i+1] = C[i];
                G[i+1] = G[i]+1;
                T[i+1] = T[i];
            }
            else if(S.charAt(i) == 'T')
            {
                A[i+1] = A[i];
                C[i+1] = C[i];
                G[i+1] = G[i];
                T[i+1] = T[i]+1;
            }
        }

        // to handle the queries
        int num_of_query = P.length; // or Q.length
        for (int i = 0; i < num_of_query; i++) {
            int a = A[ Q[i] + 1] - A[ P[i] ]; // num of 'a' between P and Q
            int c = C[ Q[i] + 1] - C[ P[i] ]; // num of 'c' between P and Q
            int g = G[ Q[i] + 1] - G[ P[i] ]; // num of 'g' between P and Q
            
            if(a > 0){ // there is 'a'
                result[i] = 1;
            }
            else if(c > 0){ // there is 'c'
                result[i] = 2;
            }
            else if(g > 0){ // there is 'g'
                result[i] =3;
            }
            else{ // there is only 'T'
                result[i] =4;
            }
        }

        return result;
    }
}
