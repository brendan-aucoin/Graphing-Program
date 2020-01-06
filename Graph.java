package graphing;
/*
 Brendan Aucoin
 2018-03-31
 this is a class that draws a Cartesian plane onto a screen.
 it holds data for how big the graph is and the increments for the x and y axis.
 */

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class Graph{
	private int xIncrement;
	private int yIncrement;
	private int squareSize;
	private int width,height;
	private int tempIncrement;
	public Graph(int xIncrement,int yIncrement,int squareSize,int width,int height) {
		this.xIncrement = xIncrement;
		this.yIncrement = yIncrement;
		this.squareSize = squareSize;
		this.width = width;
		this.height = height;
		tempIncrement = 0;
	}
	public Graph(Graph graph) {
		this.xIncrement = graph.xIncrement;
		this.yIncrement = graph.yIncrement;
		this.squareSize = graph.squareSize;
		this.width = graph.width;
		this.height = graph.height;
	}
	public Graph(GraphHandler graphHandler) {
		this.width = graphHandler.getWidth();
		this.height = graphHandler.getHeight();
		this.xIncrement = graphHandler.getxIncrement();
		this.yIncrement = graphHandler.getyIncrement();
		this.squareSize = graphHandler.getSquareSize();
		
	}
	public void update() {
		if(xIncrement <2) {
			setxIncrement(2);
		}
		if(yIncrement < 2) {
			setyIncrement(2);
		}
		if(squareSize <16) {
			setSquareSize(16);
			setyIncrement(2);
			setxIncrement(2);
		}
		if(squareSize > 100) {
			setSquareSize(16);
			setyIncrement(2);
			setxIncrement(2);
		}
	}
	 public void render(Graphics g){
		    Graphics2D g2d = (Graphics2D)g;
		    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		    /*drawing the x and y axis lines*/
		    g2d.setStroke(new BasicStroke(3));
		    /*x*/
		    g2d.drawLine(0,height/2+5,width,height/2+5);
		    /*y*/
		    g2d.drawLine(width/2+8,0,width/2+8,height);
		    
		    /*drawing all the other lines*/
		    g2d.setStroke(new BasicStroke(1));
		    /*the x lines*/
		    for(int x = 0;x < (xIncrement*width/2)/squareSize;x++){
		      g2d.drawLine(0,height - (x* squareSize),width,height - (x* squareSize));
		    }
		    
		    /*the y lines*/
		    for(int y = 0; y < (xIncrement*height)/squareSize;y++){
		     g.drawLine(y*squareSize,0,y*squareSize,height);
		    }
		    
		    drawIncrementingNumber(g);
	 }
	 private void drawIncrementingNumber(Graphics g) {
		 /*the x numbers*/
		 String fontSizeStr = String.valueOf(tempIncrement);
		 g.setColor(Color.RED);
		 g.setFont(new Font("Arial",Font.PLAIN,fontSizeStr.length() * 3));
		 /*positive x*/
		 tempIncrement = xIncrement;
		 for(int x = 0; x < (xIncrement * width/4)/squareSize; x++) {
			 g.drawString(tempIncrement + "",(squareSize  + width/2+ x*squareSize) - xIncrement, height/2 + g.getFont().getSize()*2);
			 tempIncrement+=xIncrement;
		 }
		 /*negative x*/
		 tempIncrement = -xIncrement;
		 for(int x =0; x< (xIncrement*width/4)/squareSize; x++) {
			 g.drawString(tempIncrement + "", (width/2 - x*squareSize) - squareSize, height/2 + g.getFont().getSize()*2);
			 tempIncrement -=xIncrement;
		 }
		 
		 /*the y numbers*/
		 /*positive y*/
		 tempIncrement = yIncrement;
		 for(int y =0; y < (yIncrement*height/4)/squareSize; y++) {
			 g.drawString(tempIncrement +"",width/2+ 8 - squareSize/yIncrement - yIncrement,height/2 - squareSize/2 - y*squareSize);
			 tempIncrement+=yIncrement;
		 }
		 
		 /*the negative y*/
		 tempIncrement = - yIncrement;
		 for(int y = 0; y < (yIncrement*height/4)/squareSize;y++) {
			 g.drawString(tempIncrement+"", width/2+8 - squareSize/yIncrement - g.getFont().getSize(), height/2  +squareSize + y*squareSize);
			 tempIncrement -= yIncrement;
		 }
	 }
	 public void setGraph(GraphHandler graphHandler) {
		 this.xIncrement = graphHandler.getxIncrement();
		 this.yIncrement = graphHandler.getyIncrement();
		 this.squareSize = graphHandler.getSquareSize();
	 }
	public int getSquareSize() {return squareSize;}
	public void setSquareSize(int squareSize) {this.squareSize = squareSize;}
	public int getWidth() {return width;}
	public void setWidth(int width) {this.width = width;}
	public int getHeight() {return height;}
	public void setHeight(int height) {this.height = height;}
	public int getxIncrement() {return xIncrement;}
	public void setxIncrement(int xIncrement) {this.xIncrement = xIncrement;}
	public int getyIncrement() {return yIncrement;}
	public void setyIncrement(int yIncrement) {this.yIncrement = yIncrement;}
	
	
}