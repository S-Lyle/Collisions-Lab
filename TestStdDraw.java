import java.util.PriorityQueue;

/**
 *
 * @author bmumey
 */
public class TestStdDraw {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MinPQ<Collision> pq;
        pq = new MinPQ<Collision>();
        double clockTime = 0.0; //a priority queue that takes Collisions ;

        StdDraw.setScale(-1, 1); //sets the size of the balls spinning //how do the borders work? BORDER is final variable 0 to 1
        StdDraw.enableDoubleBuffering();
        Particle[] Particles = new Particle[2];
        Particle A = new Particle(.1, .1, .2, .1, 0.05, 1, 200, 0, 0);
        Particles[0]=A;
        Particle B = new Particle(.4, .4, .1, .13, 0.05, 1, 0, 0, 150);
        Particles[1]=B;
       // Particle C = new Particle(.6, .6, .12, .1, 0.05, 1, 0, 198, 0);
        //Particles[2]=C;

        PQsort simulation = new PQsort(Particles);
        simulation.PQsorting(1000);

        /*for (double t = 0.0; true; t += 0.02) {//makes it spin faster
            double deltaT=0.02;
            StdDraw.clear();
            for(int i=0; i<Particles.length;i++) {

                *//*if (Particles[i].getX() >= 1 - 0.05 || Particles[i].getX() <= -1 + 0.05) { //adjusting boundary makes it closer to real boundary but you could miss a collision?
                      Particles[i].changevX(-1 * Particles[i].getvX());
                    //Particles[i].collidesY(Particles[i].getvX());
                    // System.out.println("Collided with x wall");
                }
                if (Particles[i].getY() >= 1 - 0.05 || Particles[i].getY() <= -1 + 0.05) { //make it match bounds
                     Particles[i].changevY(-1 * Particles[i].getvY());
                    //Particles[i].collidesX(Particles[i].getvY());
                    // System.out.println("collided with y wall");
                }*//*
                Particles[i].move(deltaT);
                // Particles[i].changeX(Particles[i].getX() + deltaT * (Particles[i].getvX()));
                //Particles[i].changeY(Particles[i].getY() + deltaT * (Particles[i].getvY()));

                StdDraw.setPenColor(Particles[i].getR(), Particles[i].getG(), Particles[i].getB());
                StdDraw.filledCircle(Particles[i].getX(), Particles[i].getY(), Particles[i].getRadius());
            }*/
           // StdDraw.show();
            //StdDraw.pause(10);

            //helps support the offscreen buffering
            //System.out.print("(" + A.getX() + "," +A.getY()+") ");
        }

    }

