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
        PriorityQueue<Collision> MinPQ=new PriorityQueue<Collision>(); //a priority queue that takes Collisions ;

        StdDraw.setScale(-2, 2); //sets the size of the balls spinning //how do the borders work? BORDER is final variable 0 to 1
        StdDraw.enableDoubleBuffering();
        Particle A = new Particle(.5, .5, .1, .2, 0.05);

        for (double t = 0.0; true; t += 0.02) { //makes it spin faster
            double x = Math.sin(t); //sets the location of the balls.
            double y = Math.cos(t);
            StdDraw.clear();
            StdDraw.filledCircle(x, y, 0.05);
            StdDraw.filledCircle(-x, -y, 0.05);

           // double x2= .1+t*.3; //need position and velocity
            //double y2=.1+t*.3;


            if(A.getX()>=2-0.05||A.getX()<=0+0.05){ //adjusting boundary makes it closer to real boundary but you could miss a collision
                A.changevX(-1*A.getvX());
                A.changeXi(A.getX());
                System.out.println("Collided with x wall");
            }
            if(A.getY()>=2-0.05||A.getY()<=0+0.05){
                A.changevY(-1*A.getvY());
                A.changeYi(A.getY());
                System.out.println("collided with y wall");
            }
            double x2a= A.getX()+t*A.getvX(); //need position and velocity
            double y2a=A.getY()+A.getvY()*t;
            StdDraw.filledCircle(x2a, y2a, 0.05); // need to update the position of the particle as it moves
            A.changeX(A.getXi()+t*(A.getvX()));
            A.changeY(A.getYi()+t*(A.getvY()));
            StdDraw.show();
            StdDraw.pause(10); //helps support the offscreen buffering
            //System.out.print(A.getX()+ " ");
            System.out.print("(" + A.getX() + "," +A.getY()+") ");
        }

    }
}
