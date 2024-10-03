import java.util.*;
public class play{
// code for implementing quick union

    public static void main(String[] args) {
    
    }
   
    public class QuickUnionF{
        private int [] id;
        

        public QuickUnionF(int N){
            id = N;
            for (int i = 0; i < N; i++) id[i] = i; //set id of each element to access itself.
        }

        private int root (int i){
            /*
             * Now here what we have is a cool little function. what this function does is
             * moves up the list if we are not at the root, remember the root will always index 
             * to itself? we keep going up the ids until we get it right.
             */

            while (i != id[i]) i = id[i];
            return i;
        }

        public boolean connected (int p, int q){
            //simple call the root function. the whole thing is based on our root function to be honest.
            return root(p) == root(q);
        }

        public void union (int p, int q){
            
            //union becomes easy. this algorithm is now in o(n) time. we simply change root of p to point to root of q.
            int i = root(p);
            int j = root(q);
            id[i] = j;
        }
    }

    // defects - trees can get toot tal and finds can be expensives.
    // unions is too expensive (n array access we have to find the root.)
 }