public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public Planet(double xP, double yP, double xV, double yV, double m, String img){
       xxPos=xP;
       yyPos=yP;
       xxVel=xV;
       yyVel=yV;
       mass=m;
       imgFileName=img;

    }
    public Planet(Planet p){
	    xxPos=p.xxPos;
	    yyPos=p.yyPos;
	    xxVel=p.xxVel;
	    yyVel=p.yyVel;
	    mass=p.mass;
	    imgFileName=p.imgFileName;

    }
    public double calcDistance(Planet p){
        double dx=this.xxPos-p.xxPos;
        double dy=this.yyPos-p.yyPos;
        double r=Math.sqrt(dx*dx+dy*dy);
        return r;
    }
    public double calcForceExertedBy(Planet p){
        final double G=6.67e-11;
        double r=this.calcDistance(p);
        double F=G*this.mass*p.mass/(r*r);
        return F;
    }
    public double calcForceExertedByX(Planet p){
        double dx=this.xxPos-p.xxPos;
        double r=this.calcDistance(p);
        double F=this.calcForceExertedBy(p);
        double Fx=-F*dx/r;
        return Fx;
    }
    public double calcForceExertedByY(Planet p){
        double dy=this.yyPos-p.yyPos;
        double r=this.calcDistance(p);
        double F=this.calcForceExertedBy(p);
        double Fy=-F*dy/r;
        return Fy;
    }
    public double calcNetForceExertedByX(Planet[] allPlanets){
        double netFx=0;
        for (Planet allPlanet : allPlanets) {
            if (!this.equals(allPlanet))
                netFx += this.calcForceExertedByX(allPlanet);
        }
        return netFx;
    }
    public double calcNetForceExertedByY(Planet[] allPlanets){
        double netFy=0;
        for (Planet allPlanet : allPlanets) {
            if (!this.equals(allPlanet))
                netFy += this.calcForceExertedByY(allPlanet);
        }
        return netFy;
    }
    public void update(double dt, double fX, double fY){
        double ax=fX/this.mass;
        double ay=fY/this.mass;
        xxVel=xxVel+ax*dt;
        yyVel=yyVel+ay*dt;
        xxPos=xxPos+xxVel*dt;
        yyPos=yyPos+yyVel*dt;
    }
    public void draw(){
        StdDraw.picture(xxPos,yyPos,"images/"+this.imgFileName);
    }
}
