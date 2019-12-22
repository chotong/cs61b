import static java.lang.Math.*;

public class Body {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    private static final double g = 6.67e-11;

    public Body(double xP, double yP, double xV, double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Body(Body b) {
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }

    public double calcDistance(Body b) {
        return sqrt(pow((this.xxPos - b.xxPos), 2) + pow((this.yyPos - b.yyPos), 2));
    }

    public double calcForceExertedBy(Body b) {
        return (g * this.mass * b.mass) / pow(calcDistance(b), 2);
    }
    
    public double calcForceExertedByX(Body b) {
        double pos = 0;
        if (this.xxPos > b.xxPos){
            pos = this.xxPos - b.xxPos;
        }
        else{
            pos = b.xxPos - this.xxPos;
        }
        return calcForceExertedBy(b) * (pos/calcDistance(b));
    }

    public double calcForceExertedByY(Body b) {
        double pos = 0;
        if (this.yyPos > b.yyPos) {
            pos = this.yyPos - b.yyPos;
        } else {
            pos = b.yyPos - this.yyPos;
        }
        return calcForceExertedBy(b) * (pos / calcDistance(b));
    }
    
    public double calcNetForceExertedByX(Body[] all) {
        double netX = 0;
        for(int i=0;i<all.length;i++){
            netX += calcForceExertedByX(all[i]);
        }
        return netX;
    }

    public double calcNetForceExertedByY(Body[] all) {
        double netY = 0;
        for (int i = 0; i < all.length; i++) {
            netY += calcForceExertedByY(all[i]);
        }
        return netY;
    }
    
    public void update(double s, double nX, double nY) {
        double aX = nX / this.mass;
        double aY = nY / this.mass;
        this.xxVel = this.xxVel + aX * s;
        this.yyVel = this.yyVel + aY * s;
        this.xxPos = this.xxVel * s + this.xxPos;
        this.yyPos = this.yyVel * s + this.yyPos;
    }

    public void draw() {
        StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
    }
}