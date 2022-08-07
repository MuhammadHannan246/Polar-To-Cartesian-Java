import java.util.*;
class PolarPoint
{
    double distance, angle;
    
    PolarPoint(double distance, double angle)
    {
        this.distance = distance;
        this.angle = angle;
    }
    
    PolarPoint()
    {
        distance = 0;
        angle = 0;
    }
    
    public Point PolarToCart(PolarPoint p)
    {
        double a = p.distance * Math.cos(angle);
        double b = p.distance * Math.sin(angle);
        Point cartesien = new Point(a,b);
        return cartesien;
    }
    
    public double dist(PolarPoint p1, PolarPoint p2)
    {
        double d = Math.sqrt((Math.pow(p1.distance,2)+ Math.pow(p2.distance,2))-(2*p1.distance*p2.distance*Math.cos(p1.angle - p2.angle)));
        return d;
    }
    
    @Override
    public String toString()
    {
        return "("+distance+","+angle+"°"+")";
    }
}
class Point extends PolarPoint
    {
        double x,y;
        
        Point(double x, double y)
        {
            this.x = x;
            this.y = y;
        }
        
        public PolarPoint CartesianToPolar(Point p, Point origin)
        {
            double dist = Math.sqrt(Math.pow(p.x - origin.x,2)+ Math.pow(p.y - origin.y, 2));
            double angle = Math.atan2(p.y - origin.y, p.x - origin.x );
            PolarPoint polarp = new PolarPoint(dist,angle);
            return polarp;
        }
        
        @Override
        public String toString()
        {
             return "("+x+","+y+")";
        }    
 }
 
public class TES03 {
	public static void main(String[] args) {
		Point origin = new Point(0,0);
        PolarPoint p1 = new PolarPoint(4,60);
        PolarPoint p3 = new PolarPoint(3,135);
        System.out.println("Polar Point: "+p1.toString());
        System.out.println();
        System.out.println("Polar To Cartesian: " +p1.PolarToCart(p1).toString());
        System.out.println();
        Point p2 = new Point(3,4);
        System.out.println("Cartesian to Polar: "+p2.CartesianToPolar(p2,origin).toString());
        System.out.println();
        System.out.println("Distance Between Two Points: "+p1.dist(p1,p3));


	}

}