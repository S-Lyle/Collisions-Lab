/**
 * Created by Sarah on 1/24/2017.
 */
public class PQsort implements Comparable<Collision> {
    public double compare(Collision one, Collision two){
        return two.getTime()-one.getTime();
    }

    @Override
    public int compareTo(Collision o) {
        return 0;
    }
}
