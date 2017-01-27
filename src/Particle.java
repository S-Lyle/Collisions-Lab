/**
 * Created by Sarah on 1/21/2017.
 */

public class Particle {
    double X;
    double Y;
    double vX;
    double vY;
    double radius;
    double Yi;
    double Xi;
    double mass;
    int r;
    int g;
    int b;
    int count=0;
    private static final double INFINITY = Double.POSITIVE_INFINITY;


    public Particle(double X, double Y, double vX, double vY, double radius, double mass, int r, int g, int b){ //position and velocity
        this.X=X;
        this.Xi=X;
        this.Y=Y;
        this.Yi=Y; //X and Y initial
        this.vX=vX;
        this.vY=vY;
        this.radius=radius;
        this.mass = mass;
        this.r = r;
        this.g=g;
        this.b=b;
    }

    public double getX(){
       return X;
    }
    public double getY(){
        return Y;
    }
    public double getvX(){
        return vX;
    }
    public double getvY(){
        return vY;
    }
    public double getXi() {
        return Xi;
    }
    public double getYi(){
        return Yi;
    }
    public double getRadius(){
        return radius;
    }
    public int getR(){
        return r;
    }
    public int getG(){
        return g;
    }
    public int getB(){
        return b;
    }
    public void changeX(double a){
        X=a;
    }
    public void changeY(double b){
        Y=b;
    }
    public void changevX(double c){
        vX=c;
    }
    public void changevY(double d){
        vY=d;
    }
    public void changeXi(double e){Xi=e;}
    public void changeYi(double f){Yi=f;}

    public double collidesX(double t){//returns when particle collides with a wall vertically
        double currentT=t;
        double dt=-1;

        if (vX==0) return INFINITY;
        else if(vX>0) {
           dt= ((1-radius-X)/vX)-currentT;
        }
        else if(vX<0){
            dt=(radius-X)/vX-currentT;
        }
        return dt;
    }

    public double collidesY(double t){//returns when particle collides with a wall vertically
        double currentT=t;
        double dt=-1;
        if (vY==0) return INFINITY;
       else if(vY>0) {
            dt= ((1-radius-Y)/vY)-currentT;
        }
       else if(vY<0){
            dt=(radius-Y)/vY-currentT;
        }
        return dt;
    }
    public void bounceOff(Particle that) {
        double dx  = that.X - this.X;
        double dy  = that.Y - this.Y;
        double dvx = that.vX - this.vY;
        double dvy = that.vY - this.vY;
        double dvdr = dx*dvx + dy*dvy;             // dv dot dr
        double dist = this.radius + that.radius;   // distance between particle centers at collison

        // magnitude of normal force
        double magnitude = 2 * this.mass * that.mass * dvdr / ((this.mass + that.mass) * dist);

        // normal force, and in x and y directions
        double fx = magnitude * dx / dist;
        double fy = magnitude * dy / dist;

        // update velocities according to normal force
        this.vX += fx / this.mass;
        this.vY += fy / this.mass;
        that.vX= fx / that.mass;
        that.vY= fy / that.mass;

        // update collision counts
        this.count++;
        that.count++;
    }
    public double timeToHit(Particle that) {
        if (this == that) return INFINITY;
        double dx  = that.X - this.X;
        double dy  = that.Y - this.Y;
        double dvx = that.vX - this.vX;
        double dvy = that.vY - this.vY;
        double dvdr = dx*dvx + dy*dvy;
        if (dvdr > 0) return INFINITY;
        double dvdv = dvx*dvx + dvy*dvy;
        double drdr = dx*dx + dy*dy;
        double sigma = this.radius + that.radius;
        double d = (dvdr*dvdr) - dvdv * (drdr - sigma*sigma);
        // if (drdr < sigma*sigma) StdOut.println("overlapping particles");
        if (d < 0) return INFINITY;
        return -(dvdr + Math.sqrt(d)) / dvdv;
    }
    public void move(double dt) {
        X += vX * dt;
        Y += vY * dt;
    }

    public void bounceOffVerticalWall() {
        vX = -vX;
        count++;
    }

    /**
     * Updates the velocity of this particle upon collision with a horizontal
     * wall (by reflecting the velocity in the <em>y</em>-direction).
     * Assumes that the particle is colliding with a horizontal wall at this instant.
     */
    public void bounceOffHorizontalWall() {
        vY = -vY;
        count++;
    }
    public void draw() {
        StdDraw.setPenColor(r, g, b);
        StdDraw.filledCircle(X, Y, radius);
    }

}
