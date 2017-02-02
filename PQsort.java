/**
 * Created by Sarah on 1/24/2017.
 */
public class PQsort  {
    public MinPQ<Collision> pq;
    public double clockTime = 0.0;
    public Particle[] particles;

    public PQsort(Particle[] particles){
        this.particles=particles;
    }
    public double compare(Collision one, Collision two){
        return two.getTime()-one.getTime();
    } //if negative, one is farther away and two happens first.
    //if positive, two is farther away and one happens first
    public void predict(Particle a, double limit) {
        if (a == null) return;
        for (int i = 0; i < particles.length; i++) {
            double dt = a.timeToHit(particles[i]);
            if (clockTime + dt <= limit)
                pq.insert(new Collision(clockTime + dt, a, particles[i]));
        }
        double dtX = a.collidesX();
        double dtY = a.collidesY();
        if (clockTime + dtX <= limit) pq.insert(new Collision(clockTime + dtX, null, a));
        if (clockTime + dtY <= limit) pq.insert(new Collision(clockTime + dtY, a, null));
    }
    public void redraw(double limit) {
        StdDraw.clear();
        for (int i = 0; i < particles.length; i++) {
            particles[i].draw();
        }
        StdDraw.show();
        StdDraw.pause(10);
        /*if (clockTime < limit) {
            pq.insert(new Collision(((clockTime + 1.0) / .5), null, null));
        }*/
    }

    public void PQsorting(double timeLimit) {
        pq = new MinPQ<Collision>();
        for (int i = 0; i < particles.length; i++) {
            predict(particles[i], timeLimit);
        }
        pq.insert(new Collision(0, null, null));

        while (!pq.isEmpty()) {

            // get impending event, discard if invalidated
            Collision main = pq.delMin();
            if (!main.isValid()) continue;
            Particle one = main.particle1;
            Particle two = main.particle2;

            for (int i = 0; i < particles.length; i++) {
                particles[i].move(main.time_until - clockTime);
            }
            clockTime = main.time_until;

            if      (one != null && two != null) one.bounceOff(two);              // particle-particle collision
            else if (one != null && two == null) one.bouncevY();   // particle-wall collision
            else if (one == null && two != null) two.bouncevX(); // particle-wall collision
            else if (one == null && two == null) redraw(timeLimit);

            redraw(timeLimit);

            predict(one, timeLimit);
            predict(two, timeLimit);

        }
    }
}
