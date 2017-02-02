/**
 * Created by Sarah on 1/24/2017.
 */
public class Collision implements Comparable<Collision> {
    double time_until;
    Particle particle1;
    Particle particle2;
    int val1;
    int val2;
    public Collision(double time, Particle a, Particle b){
        time_until=time;
        particle1=a;
        particle2=b;
        if(a!=null) val1=a.count();
        else        val1=-1;
        if(b!=null) val2=b.count();
        else        val2=-1;
    }

    public double getTime(){
        return time_until;
    }

    public int compareTime(Collision two) {
        return Double.compare(two.time_until, this.time_until);
    }
    public boolean isValid() {
            if (particle1 != null && particle1.count() != val1) return false;
            if (particle2 != null && particle2.count() != val2) return false; //i changed to particle 2 for count()
            return true;
    }
   // public void clean(){
     //   for(int i=0;i<pq.length;i++ ){

       // }
    //}

    @Override
    public int compareTo(Collision o) {
        if (this.getTime()>o.getTime()){
            return 1;
        }
        else if(this.getTime()<o.getTime()){
            return -1;
        }
        else
            return 0;
        //return Double.compare(this.getTime(),o.getTime());
    }
}

