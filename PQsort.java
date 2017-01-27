/**
 * Created by Sarah on 1/24/2017.
 */
public class PQsort  {
    public double compare(Collision one, Collision two){
        return two.getTime()-one.getTime();
    } //if negative, one is farther away and two happens first.
    //if positive, two is farther away and one happens first

}
