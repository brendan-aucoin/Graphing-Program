package action_listeners;
/*
 Brendan Aucoin
 2018/04/01
 this is the action class for the 3 start buttons that graph the functions.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import equation_handling.DataStructure;
import graphing.Graph;
import graphing.GraphingPanel;
import points.PointRenderer;

public class StartAction implements ActionListener{
	private JTextField inputTf1;
	private JButton startButton1;
	private JTextField inputTf2;
	private JButton startButton2;
	private JTextField inputTf3;
	private JButton startButton3;
	private PointRenderer pr1,pr2,pr3;
	private DataStructure dataStructure;
	private Graph graph;
	private GraphingPanel graphingPanel;
	public StartAction(GraphingPanel graphingPanel,JTextField inputTf1,JButton startButton1,JTextField inputTf2,JButton startButton2,JTextField inputTf3,JButton startButton3) {
		pr1 = graphingPanel.getPointRenderer1();
		pr2 = graphingPanel.getPointRenderer2();
		pr3 = graphingPanel.getPointRenderer3();
		graph = graphingPanel.getGraph();
		this.graphingPanel = graphingPanel;
		dataStructure = graphingPanel.getDataStructure();
		//dataStructure = new DataStructure();
		this.inputTf1 = inputTf1;
		this.startButton1 = startButton1;
		this.inputTf2 = inputTf2;
		this.startButton2 = startButton2;
		this.inputTf3 = inputTf3;
		this.startButton3 = startButton3;
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == startButton1) {
			String input = inputTf1.getText();
			
			if(!input.equals("")) {
			//boolean enable = dataStructure.calculate(input,(int) ((graph.getxIncrement()*graph.getWidth()/1.5)/graph.getSquareSize()),graph,pr1);
			
			graphingPanel.setForGraphing(input, pr1);
			dataStructure.setUpCalculation(input,(int) ((graph.getxIncrement()*graph.getWidth()/1.5)/graph.getSquareSize()),graph,pr1);
			inputTf1.setEnabled(false);
			graphingPanel.setGraphFunction1(true);
			
			//if(enable) {inputTf1.setEnabled(false);}
			}
		}
		else if(e.getSource() == startButton2) {
			String input = inputTf2.getText();
			if(!input.equals("")) {
				
				graphingPanel.setForGraphing(input, pr2);
				dataStructure.setUpCalculation(input,(int) ((graph.getxIncrement()*graph.getWidth()/1.5)/graph.getSquareSize()),graph,pr2);
				inputTf2.setEnabled(false);
				graphingPanel.setGraphFunction2(true);
				
			//boolean enable = dataStructure.calculate(input,(int) ((graph.getxIncrement()*graph.getWidth()/1.5)/graph.getSquareSize()),graph,pr2);
			//if(enable) {inputTf2.setEnabled(false);}
			}
		}
		else if(e.getSource() == startButton3) {
			String input = inputTf3.getText();
			if(!input.equals("")) {
				graphingPanel.setForGraphing(input, pr3);
				dataStructure.setUpCalculation(input,(int) ((graph.getxIncrement()*graph.getWidth()/1.5)/graph.getSquareSize()),graph,pr3);
				inputTf1.setEnabled(false);
				graphingPanel.setGraphFunction3(true);
			//boolean enable = dataStructure.calculate(input,(int) ((graph.getxIncrement()*graph.getWidth()/1.5)/graph.getSquareSize()),graph,pr3);
			//if(enable) {inputTf3.setEnabled(false);}
			}
		}
	}
}
