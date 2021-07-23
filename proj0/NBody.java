public class NBody{
	public static double readRadius(String str){
		In in=new In(str);
		int firstItemInFile=in.readInt();
		double radius=in.readDouble();
		return radius;
	}
	public static Planet[] readPlanets(String str){

		In in=new In(str);
		int N = in.readInt();
		double secondItemInFile = in.readDouble();
		Planet[] planets=new Planet[N];
		for(int i=0;i<N;i++){

			double xxPos=in.readDouble();
			double yyPos=in.readDouble();
			double xxVel=in.readDouble();
			double yyVel=in.readDouble();
			double mass=in.readDouble();
			String imgFileName=in.readString();
			planets[i]=new Planet(xxPos,yyPos,xxVel,yyVel,mass,imgFileName);
		}
		return planets;
	}
	public static void main(String[] args) {
		double T=Double.valueOf(args[0]);
		double dt=Double.valueOf(args[1]);
		String filename=args[2];
		double radius=readRadius(filename);
		Planet[] planets=readPlanets(filename);
		StdDraw.setScale(-radius,radius);
		StdDraw.picture(0, 0, "images/starfield.jpg");
		for(int i=0;i<planets.length;i++){
			planets[i].draw();
		}

		StdDraw.enableDoubleBuffering();
		double t=0;
		while(t<T){
			double[] xForces=new double[planets.length];
			double[] yForces=new double[planets.length];
			for(int i=0;i<planets.length;i++){
				xForces[i]=planets[i].calcNetForceExertedByX(planets);
				yForces[i]=planets[i].calcNetForceExertedByY(planets);
			}
			for(int i=0;i<planets.length;i++){
				planets[i].update(dt,xForces[i],yForces[i]);
			}
			//StdDraw.setScale(-radius,radius);
			StdDraw.picture(0,0,"images/starfield.jpg");
			for(int i=0;i<planets.length;i++){
				planets[i].draw();
			}
			StdDraw.show();
			StdDraw.pause(1);
			t=t+dt;
		}
		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < planets.length; i++) {
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
					planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
					planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
		}



	}

}
		
