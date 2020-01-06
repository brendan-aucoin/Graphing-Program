package graphing;
/*
 Brendan Aucoin
 2018/04/01
 this class is the gui that holds the graph and everything that goes on the graph.
 it is also the class that has the main (game) loop.
 */
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JPanel;

import GUI.MainGUI;
import equation_handling.DataStructure;
import points.PointRenderer;

public class GraphingPanel extends JPanel implements Runnable{
	private static final long serialVersionUID = 1L;
	private Canvas canvas;
	private boolean running;
	private Thread thread;
	private Graph graph;
	private GraphHandler graphHandler;
	private PointRenderer pr1,pr2,pr3;
	private boolean showPointRenderer1,showPointRenderer2,showPointRenderer3;
	private int timeDelay;
	private boolean graphFunction1;
	private boolean graphFunction2,graphFunction3;
	private DataStructure dataStructure;
	
	private String currentEquation;
	private PointRenderer currentPointRenderer;
	private int graphingIndex1 =0,graphingIndex2 =0,graphingIndex3 =0;
	
	public static int gameLoopTimeDelay =0;
	public GraphingPanel() {
		graphHandler = new GraphHandler(2,4,64,4,0,0);
		pr1 = new PointRenderer(graphHandler,Color.BLUE);
		pr2 = new PointRenderer(graphHandler,new Color(0,128,0));
		pr3 = new PointRenderer(graphHandler,new Color(128,0,0));
		dataStructure = new DataStructure();
		this.setLayout(new BorderLayout());
		this.setMaximumSize(new Dimension((int)(MainGUI.WIDTH/2.5),MainGUI.HEIGHT));
		this.setMinimumSize(new Dimension((int)(MainGUI.WIDTH/2.5),MainGUI.HEIGHT));
		this.setPreferredSize(new Dimension((int)(MainGUI.WIDTH/2.5),MainGUI.HEIGHT));
		canvas = new Canvas();
		canvas.setSize(this.getWidth(),this.getHeight());
		this.add(canvas,BorderLayout.CENTER);
		graph = new Graph(graphHandler);
		running = false;
		showPointRenderer1 = true;
		showPointRenderer2 = true;
		showPointRenderer3 = true;
		timeDelay = 9;
	}
	
	
	public void render() {
		 BufferStrategy bs = canvas.getBufferStrategy();
		   if(bs == null){canvas.createBufferStrategy(2);return;}
		   Graphics g = bs.getDrawGraphics();
		   canvas.paint(g);
		   //if(graph == null) {graph = new Graph(2,2,32,canvas.getWidth(),canvas.getHeight());return;}
		   g.setColor(Color.BLACK);
		   //g.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
		   graph.render(g);
		   if(showPointRenderer1) {pr1.render(g);}
		   if(showPointRenderer2){ pr2.render(g);}
		   if(showPointRenderer3) {pr3.render(g);}
		   g.dispose();
		   bs.show();
	}
	public void update() {
		if(graph == null) {graph = new Graph(graphHandler);}
		if(graph!=null) {graph.update();graph.setWidth(canvas.getWidth());graph.setHeight(canvas.getHeight());}
		if(canvas.getWidth() != 0 || canvas.getHeight() != 0) {
			graphHandler.setWidth(canvas.getWidth());graphHandler.setHeight(canvas.getHeight());
		}
		
		if(graphFunction1) {
			boolean keepGraphing = dataStructure.calculate(graphingIndex1, currentEquation, (int) ((graph.getxIncrement()*graph.getWidth()/1.5)/graph.getSquareSize()), graph, pr1);
			graphingIndex1++;
			if(keepGraphing == false) {
				graphFunction1 = false;
				graphingIndex1 =0;
			}
		}
		
		if(graphFunction2) {
			boolean keepGraphing = dataStructure.calculate(graphingIndex2, currentEquation, (int) ((graph.getxIncrement()*graph.getWidth()/1.5)/graph.getSquareSize()), graph, pr2);
			graphingIndex2++;
			if(keepGraphing == false) {
				graphFunction2 = false;
				graphingIndex2 =0;
			}
		}
		
		if(graphFunction3) {
			boolean keepGraphing = dataStructure.calculate(graphingIndex3, currentEquation, (int) ((graph.getxIncrement()*graph.getWidth()/1.5)/graph.getSquareSize()), graph, pr3);
			graphingIndex3++;
			if(keepGraphing == false) {
				graphFunction3 = false;
				graphingIndex3 =0;
			}
		}
	}
	
	public void setForGraphing(String equation,PointRenderer pr) {
		this.currentEquation = equation;
		this.currentPointRenderer =  pr;
	}
	
	
	
	public PointRenderer getPointRenderer1() {return pr1;}
	public PointRenderer getPointRenderer2() {return pr2;}
	public PointRenderer getPointRenderer3() {return pr3;}
	public GraphHandler getGraphHandler() {return new GraphHandler(graphHandler);}
	public Graph getGraph() {return graph;}
	public boolean isShowPointRenderer1() {return showPointRenderer1;}
	public void setShowPointRenderer1(boolean showPointRenderer1) {this.showPointRenderer1 = showPointRenderer1;}
	public boolean isShowPointRenderer2() {return showPointRenderer2;}
	public void setShowPointRenderer2(boolean showPointRenderer2) {this.showPointRenderer2 = showPointRenderer2;}
	public boolean isShowPointRenderer3() {return showPointRenderer3;}
	public void setShowPointRenderer3(boolean showPointRenderer3) {this.showPointRenderer3 = showPointRenderer3;}
	public void setTimeDelay(int timeDelay) {this.timeDelay = timeDelay;}
	public int getTimeDelay() {return timeDelay;}
	public DataStructure getDataStructure() {return dataStructure;}

	public boolean isGraphFunction1() {return graphFunction1;}
	public void setGraphFunction1(boolean graphFunction) {this.graphFunction1 = graphFunction;}
	public boolean isGraphFunction2() {return graphFunction2;}
	public void setGraphFunction2(boolean graphFunction2) {this.graphFunction2 = graphFunction2;}
	public boolean isGraphFunction3() {return graphFunction3;}
	public void setGraphFunction3(boolean graphFunction3) {this.graphFunction3 = graphFunction3;}


	public void start(){
		   if(running){return;}
		   running = true;
		   if(thread == null){thread = new Thread(this);}
		   thread.start();
		   
		 }
		 
		 public void stop(){
		   if(!running){return;}
		   running  = false;
		   try{thread.join();}catch(Exception e){e.printStackTrace();}
		 }
	public void run(){
		int fps = 120;//the frames per second./ ticks per second
		double timePerTick = 1000000000/fps;//becuase 1 billion nano seconds in 1 second
		double delta = 0;//how much time you have until you have to call the tick and render methods again.
		long now;//the time right now.
		long lastTime = System.nanoTime();//returns how many nano seconds our computer is running at.
		long timer = 0;
		int ticks =0;
		while(running)//game loop
		{
			now = System.nanoTime();//now is current time.
			delta += (now - lastTime)/timePerTick;
			timer += now -lastTime;//how much time has passed since the last call of tick and render
			lastTime = now;
			if(delta >= 1)//this is to achieve 60 fps.
			{
				update();
				render();
				ticks++;
				delta--;
			}	
			if(timer >= 1000000000)
			{
				System.out.println("Updates: " + ticks);
				ticks = 0;
				timer = 0;
			}
			try{Thread.sleep(gameLoopTimeDelay);}catch(InterruptedException ie){System.out.println("Game loop sleeping interuppted");}//could be 8
		}
		stop();
	}
	
	
	
}
