/**
 * Created by Sarah on 1/24/2017.
 */
public class Collision {
    double time_until;
    Particle particle;
    public Collision(double time, Particle a){
        time_until=time;
        particle=a;
    }

    public double getTime(){
        return time_until;
    }

}
