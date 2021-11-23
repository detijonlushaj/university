import java.util.Comparator;

public class A6g1 implements Comparator<Loc> {

    @Override
    public int compare(Loc o1, Loc o2) {
        int cmp = Integer.compare(o1.getX(), o2.getX());
        
        if (cmp == 0) {
            return Integer.compare(o1.getY(), o2.getY());
        }
        return cmp;
    }
    
}
