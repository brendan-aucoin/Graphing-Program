package graphing;
/*
 Brendan Aucoin
 2018/04/01
 this class holds data for the increments on the x and y axis, the point size, the square size, and the width and height of the canvas.
 */
public class GraphHandler {
	private int xIncrement;
	private int yIncrement;
	private int squareSize;
	private int pointSize;
	private int width;
	private int height;
	public GraphHandler(int xIncrement,int yIncrement,int squareSize,int pointSize,int width,int height) {
		this.xIncrement = xIncrement;
		this.yIncrement = yIncrement;
		this.squareSize = squareSize;
		this.pointSize = pointSize;
		this.width = width;
		this.height = height;
	}
	public GraphHandler(GraphHandler graphHandler) {
		this.xIncrement = graphHandler.xIncrement;
		this.yIncrement = graphHandler.yIncrement;
		this.squareSize = graphHandler.squareSize;
		this.pointSize = graphHandler.pointSize;
		this.width = graphHandler.width;
		this.height = graphHandler.height;
	}
	public int getxIncrement() {return xIncrement;}

	public void setxIncrement(int xIncrement) {this.xIncrement = xIncrement;}

	public int getyIncrement() {return yIncrement;}

	public void setyIncrement(int yIncrement) {this.yIncrement = yIncrement;}

	public int getSquareSize() {return squareSize;}

	public void setSquareSize(int squareSize) {this.squareSize = squareSize;}

	public int getPointSize() {return pointSize;}

	public void setPointSize(int pointSize) {this.pointSize = pointSize;}

	public int getWidth() {return width;}

	public void setWidth(int width) {this.width = width;}

	public int getHeight() {return height;}

	public void setHeight(int height) {this.height = height;}
	
	
}
