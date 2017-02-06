/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package teststddraw;

//import edu.princeton.cs.algs4.StdDraw;

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
        StdDraw.setCanvasSize(400, 400);

        StdDraw.enableDoubleBuffering();
/*        Particle[] Particles = new Particle[7];
        Particle A = new Particle(.3, .5, .12 ,.2, 0.05, 1, 200, 0, 0);
        Particles[0]=A;
        Particle B = new Particle(.1, 0, .1, .1, 0.05, 1, 0, 0, 150);
        Particles[1]=B;
        Particle C = new Particle(.6, .6, .12, .1, 0.05, 1, 0, 198, 0);
        Particles[2]=C;
        Particle D = new Particle(.8, .6, .12, .1, 0.05, 1, 0, 20, 170);
        Particles[3]=D;
        Particle E = new Particle(.2, .5, .12, .1, 0.05, 1, 0, 150, 15);
        Particles[4]=E;
        Particle F = new Particle(.1, .9, .12, .1, 0.05, 1, 240, 60, 50);
        Particles[5]=F;
        Particle G = new Particle(.3, .7, .12, .1, 0.05, 1, 200, 100, 100);
        Particles[6]=G;*/
        StdOut.print("ENTER DATA");
        int n = StdIn.readInt();
        Particle [] particles = new Particle[n];
            for (int i = 0; i < n; i++) {
                double rx     = StdIn.readDouble();
                double ry     = StdIn.readDouble();
                double vx     = StdIn.readDouble();
                double vy     = StdIn.readDouble();
                double radius = StdIn.readDouble();
                double mass   = StdIn.readDouble();
                int r         = StdIn.readInt();
                int g         = StdIn.readInt();
                int b         = StdIn.readInt();
                //Color color   = new Color(r, g, b);
                particles[i] = new Particle(rx, ry, vx, vy, radius, mass, r,g,b);
            }

        PQsort simulation = new PQsort(particles);
        simulation.PQsorting(1000);

    }

    }
