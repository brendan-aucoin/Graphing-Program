package points;
/*
 Brendan Aucoin
 2018/04/01
 this class has the data for a x and y point on the Cartesian plane.
 */
public class Point implements Comparable<Point>{
	private double x,y;
	public Point(double x,double y) {
		this.x = x;
		this.y = y;
	}
	public Point(Point p) {
		this.x = p.x;
		this.y = p.y;
	}
	public boolean equals(Point p) {
		if(this == p) {return true;}
		if(x == p.x && y == p.y) {return true;}
		else {return false;}
	}
	public String toString() {
		return "X = " + x + ", Y = " + y;
	}
	public int compareTo(Point p) {
		double compareX=((Point)p).getX();
        /* For Ascending order*/
        return (int)(this.x-compareX);
	}
	public double getX() {return x;}
	public void setX(double x) {this.x = x;}
	public double getY() {return y;}
	public void setY(double y) {this.y = y;}
	
	
}
