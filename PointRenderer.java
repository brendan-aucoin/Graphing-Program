package points;
/*
 Brendan Aucoin
 2018/04/01
 this class is the visual part of the rendering points. it draws out points from an arraylist given to it by the DataStructure class 
 and draws out the line connecting the points.
 */
import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

import equation_handling.DataStructure;
import graphing.GraphHandler;

public class PointRenderer {
	private GraphHandler graphHandler;
	private Color color;
	private int pointSize;
	private LinkedList<Point> points;
	public PointRenderer(GraphHandler graphHandler,Color color) {
		this.graphHandler = graphHandler;
		this.color = color;
		pointSize = graphHandler.getPointSize();
		points = new LinkedList<Point>();
	}
	
	public PointRenderer(PointRenderer pr) {
		this.color = pr.color;
		this.graphHandler = pr.graphHandler;
		this.pointSize = pr.pointSize;
		this.points = pr.points;
	}
	public void render(Graphics g) {
		for(int i=0; i < points.size(); i++) {
			try {
			Point p = points.get(i);
			double x =  graphHandler.getWidth()/2 + 8 + (p.getX()*(graphHandler.getSquareSize()/graphHandler.getxIncrement()));
			double y =  graphHandler.getHeight()/2 -(p.getY()*(graphHandler.getSquareSize()/graphHandler.getyIncrement()));
			//System.out.println(p.getX()+ "," + p.getY());
			g.setColor(color);
			
			g.fillOval((int)(x - pointSize/2), (int)(y + pointSize), pointSize, pointSize);
			}catch(NullPointerException e) {return;}
		}
		/*drawing the line*/
		if(!DataStructure.random) {
			g.setColor(color);
			drawLines(g,0,points.size()/2-1);
			drawLines(g,points.size()/2,points.size()-1);
		}
	}
	private void drawLines(Graphics g,int startingPoint,int endingPoint) {
		   for(int i =startingPoint; i< endingPoint;i++){
			    Point p1 = points.get(i);
			    Point p2 = points.get(i+1);
			    double p1x =   graphHandler.getWidth()/2 + 8 + (p1.getX()*(graphHandler.getSquareSize()/graphHandler.getxIncrement()));
				double p1y =   pointSize + graphHandler.getHeight()/2 -(p1.getY()*(graphHandler.getSquareSize()/graphHandler.getyIncrement()));
			    
				double p2x = graphHandler.getWidth()/2 + 8 + (p2.getX()*(graphHandler.getSquareSize()/graphHandler.getxIncrement()));
				double p2y =  pointSize +  graphHandler.getHeight()/2 -(p2.getY()*(graphHandler.getSquareSize()/graphHandler.getyIncrement()));
			    
			    g.drawLine((int)(p1x),(int)(p1y),(int)(p2x),(int)(p2y));
			   }
	}
	public boolean hasPoint(Point p) {
		boolean contains = false;
		for(int i=0; i < points.size(); i++) {
			if(points.get(i).equals(p)) {
				contains =  true;
			}
			else {
				contains = false;
			}
		}
		return contains;
	}
	public void addPoint(double x,double y) {
		for(Point p : points) {
			if(!hasPoint(p)) {
				points.add(new Point(x,y));
			}
		}
	}
	public void addPoint(Point point) {
		for(Point p : points) {
			if(!hasPoint(p)) {
				points.add(point);
			}
		}
	}
	public void clearPoints() {
		points.clear();
	}
	public Color getColor() {return color;}

	public void setColor(Color color) {this.color = color;}

	public int getPointSize() {return pointSize;}

	public void setPointSize(int pointSize) {this.pointSize = pointSize;}

	public LinkedList<Point> getPoints() {return points;}
	public void setPoints(LinkedList<Point> points) {this.points = points;}
	
}
