public class IntList {

    int first;
    IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    public int size() {
        if (rest == null) {
            return 1;
        } else
            return 1 + this.rest.size();
    }
    
    public int interativeSize() {
        IntList p = this;
        int i = 0;
        while (p != null) {
            i++;
            p = p.rest;
        }
        return i;
    }
    
    public int get(int n) {
        if (n == 0) {
            return first;
        }
        return rest.get(n - 1);
    }

    /** Returns an IntList identical to L, but with
      * each element incremented by x. L is not allowed
      * to change. */
    public static IntList incrList(IntList L, int x) {
        IntList LL = new IntList(L.get(L.size()-1) + x,null);
        int i = L.size()-2;
        while (i != 0) {
            LL = new IntList(L.get(i) + x, LL);
            i--;
        }
        LL = new IntList(L.get(0) + x, LL);
        return LL;
    }
    
    /** Returns an IntList identical to L, but with
      * each element incremented by x. Not allowed to use
      * the 'new' keyword. */
    public static IntList dincrList(IntList L, int x) {
        /* Your code here. */
        IntList R = L;
        while (R.rest != null) {
            R.first = R.first + x;
            R = R.rest;
        }
        R.first = R.first + x;
        
        return L;
    }

    public static void main(String[] args) {
        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L);
        IntList LL = IntList.incrList(L, 5);
        IntList R = IntList.dincrList(L, 10);
    }
}