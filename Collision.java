/**
 * Created by Sarah on 1/24/2017.
 */
public class Collision implements Comparable<Collision> {
    double time_until;
    Particle particle1;
    Particle particle2;
    public Collision(double time, Particle a, Particle b){
        time_until=time;
        particle1=a;
        particle2=b;
    }

    public double getTime(){
        return time_until;
    }
    public Particle getParticle1() {return particle1;}
    public Particle getParticle2() {return particle2;}

    @Override
    public int compareTo(Collision o) {
        return 0;
    }
}
