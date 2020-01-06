package equation_handling;
import java.util.ArrayList;
import java.util.Collections;
/*
 Brendan Aucoin
 2018/04/01
 this.class loops through the entire graph and plots points using the static method from the equation class. and adds all those
 points to the array list.
 */
import java.util.LinkedList;
import java.util.Random;

import javax.script.ScriptException;
import javax.swing.JOptionPane;

import graphing.Graph;
import points.Point;
import points.PointRenderer;

public class DataStructure {
	private LinkedList<Point>data;
	public static boolean random;
	private ArrayList<Double>randPoints;
	public DataStructure() {
		data = new LinkedList<Point>();
		random = true;
	}
	public void setUpCalculation(String equation,int limit,Graph graph,PointRenderer pr) {
		//if you want random order.
			if(random) {
				randPoints = new ArrayList<Double>();
				for(double i =-limit; i <= limit; i+=0.1) {
					randPoints.add(i);
				}
				Random rand = new Random();
				while (randPoints.size() < limit) {
				double random = 0 + (limit - 0) * rand.nextDouble();
				if (!randPoints.contains(random)) {
					randPoints.add(random);
				}
			}
			Collections.shuffle(randPoints);
		}
	}
	public boolean calculate(int index,String equation,int limit,Graph graph,PointRenderer pr) {
		if(random) {
			double x =0;
			try {
			x = randPoints.get(index);
			}catch(IndexOutOfBoundsException e) {return false;}
			double y = Double.NaN;
			try {
				y= Equation.calculate(equation, x).doubleValue();
			}catch(ScriptException e) {JOptionPane.showMessageDialog(null, "Error");return false;}
			
			
			if(Double.isNaN(y)) {
				//clear();
				return true;
			}
			
			else {
				data.add(new Point(x,y));
				applyToGraph(pr);
			}	
			return true;
		}
		else {
			double x = index;
			double negX = -index;
			double y = Double.NaN;
			double negY = Double.NaN;
			try {
				y= Equation.calculate(equation, x).doubleValue();
				negY= Equation.calculate(equation, negX).doubleValue();
			}catch(ScriptException e) {JOptionPane.showMessageDialog(null, "Error");return false;}
			
			
			if(Double.isNaN(y)) {
				//clear();
				return true;
			}
			
			else {
				data.add(new Point(x,y));
				data.add(new Point(negX,negY));
				applyToGraph(pr);
			}	
			return true;
		}
	}
	
	/*public boolean calculate(String equation,int limit,Graph graph,PointRenderer pr) {
		//the positive
		if(random) {
			ArrayList<Double> randPoints = new ArrayList<Double>();
			for(double i =-limit; i <= limit; i+=0.1) {
				randPoints.add(i);
			}
			Random rand = new Random();
				while (randPoints.size() < limit) {

					double random = 0 + (limit - 0) * rand.nextDouble();
					if (!randPoints.contains(random)) {
						randPoints.add(random);
					}
				}
				Collections.shuffle(randPoints);
				for(int i=0; i < randPoints.size(); i++) {
					double x = randPoints.get(i);
					double y = Double.NaN;//not a number
					try {
						y = Equation.calculate(equation,x).doubleValue();}catch(ScriptException e) {JOptionPane.showMessageDialog(null, "Error");return false;}
						
					if(Double.isNaN(y)) {
						clear();
					}
					else {
						data.add(new Point(x,y));
						applyToGraph(pr);
					}	
				}

		}
	    
		else {
			for(double x = 0; x <= limit; x += 0.1) {
				double y = Double.NaN;//not a number
				try {
				y = Equation.calculate(equation,x).doubleValue();}catch(ScriptException e) {JOptionPane.showMessageDialog(null, "Error");return false;}
				
				if(Double.isNaN(y)) {
					clear();
				}
				else {
					data.add(new Point(x,y));
					applyToGraph(pr);
				}
			}
			//the negative
			for(double x= 0; x >=-limit; x-= 0.1) {
				
				double y = Double.NaN;//not a number
				try {
				y = Equation.calculate(equation,x).doubleValue();}catch(ScriptException e) {JOptionPane.showMessageDialog(null, "Error");return false;}
				if(Double.isNaN(y)) {
					clear();
				}
				else {
					data.add(new Point(x,y));
					applyToGraph(pr);
				}
			}
		}
		//applyToGraph(pr);
		return true;
	}//end of calculate
*/

	public void clear() {
		data = new LinkedList<Point>();
	}
	private void applyToGraph(PointRenderer pr) {
		pr.setPoints(data);
	}
}
