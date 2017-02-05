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
                pq.insert(new Collision(dt, a, particles[i]));
        }
        double dtX = a.collidesX(); //time when a will collide with X or Y
        double dtY = a.collidesY();
        if (clockTime + dtX <= limit) pq.insert(new Collision(dtX, null, a));
        if (clockTime + dtY <= limit) pq.insert(new Collision(dtY, a,null));
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
    public void move(Particle p, double dt){
        double a =dt;
        double inc=0.2;
        while(inc<a){
            p.changeX(p.getXi()+ p.getvX() * inc);
            p.changeY(p.getYi()+p.getvY() * inc);
            inc+=0.01;
            redraw(1000);
        }
    }


    public void PQsorting(double timeLimit) {
        pq = new MinPQ<Collision>();
        for (int i = 0; i < particles.length; i++) {
            predict(particles[i], timeLimit);
        }
        pq.insert(new Collision(0, null, null));


        while (!pq.isEmpty()) {

            Collision main = pq.delMin();
            if (!main.isValid()) continue;
            Particle one = main.particle1;
            Particle two = main.particle2;

            //something is making the PQ code miss collisions, i think its how I implement time and the efficiency of this code
            for (double inc = 0; inc <=main.time_until; inc+=0.01){
                for (int i = 0; i < particles.length; i++) {
                    particles[i].changeX(particles[i].getX() + particles[i].getvX() * 0.01); //make this match inc number
                    particles[i].changeY(particles[i].getY() + particles[i].getvY() * 0.01);
                }
                redraw(1000);
            }
            clockTime += main.time_until;
            if      (one != null && two != null) one.bounceOff(two);              // particle-particle collision
            else if (one != null && two == null) one.bounceoffHorizontalWall();   // particle-wall collision
            else if (one == null && two != null) two.bounceoffVerticalWall(); // particle-wall collision
            else if (one == null && two == null) redraw(timeLimit);

            for(int i=0; i<particles.length; i++)
                predict(particles[i], timeLimit);

        }

    }
}
