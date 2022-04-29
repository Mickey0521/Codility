// Solution with O((N + M) * N) complexity, score 50%. Timeout exceptions in the test.
class Solution {
    public int solution(int[] A, int[] B, int[] C) {
        // write your code in Java SE 8
        Plunk[] plunks = new Plunk[A.length];
        for (int i = 0; i < A.length; i++) {
            plunks[i] = new Plunk(A[i], B[i]);
        }
        Arrays.sort(plunks, Comparator.comparing(e1 -> e1.x));

        for (int i = 0; i < C.length; i++) {
            while(plunks.length > 0) {
                int pIndex = findPlunk(C[i], plunks);
                if (pIndex > -1) {
                    plunks = removePlunk(plunks, pIndex);
                } else {
                    break;
                }
            }

            if (plunks.length == 0) {
                return i + 1;
            }
        }

        return -1;        
    }

    private int findPlunk(int nail, Plunk[] plunks) {
        int lower = 0;
        int upper = plunks.length -1;

        while (lower <= upper) {
            int mid = (lower + upper) / 2;
            if (plunks[mid].x > nail) {
                upper = mid - 1;
            } else if (plunks[mid].y < nail) {
                lower = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private Plunk[] removePlunk(Plunk[] x, int index) {
        Plunk[] res = new Plunk[x.length-1];

        int j = 0;
        for (int i = 0; i < x.length; i++) {
            if (i != index) {
                res[j] = x[i];
                j++;
            }
        }

        return res;
    }

    private class Plunk {
        public int x;
        public int y;

        Plunk(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
