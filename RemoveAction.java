package action_listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import graphing.GraphingPanel;

public class RemoveAction implements ActionListener{
	private JTextField inputTf1;
	private JButton removeButton1;
	private JTextField inputTf2;
	private JButton removeButton2;
	private JTextField inputTf3;
	private JButton removeButton3;
	private GraphingPanel graphingPanel;
	public RemoveAction(GraphingPanel graphingPanel,JTextField inputTf1,JButton removeButton1,JTextField inputTf2,JButton removeButton2,JTextField inputTf3,JButton removeButton3) {
		this.graphingPanel = graphingPanel;
		this.inputTf1 = inputTf1;
		this.removeButton1 = removeButton1;
		this.inputTf2 = inputTf2;
		this.removeButton2 = removeButton2;
		this.inputTf3 = inputTf3;
		this.removeButton3 = removeButton3;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == removeButton1) {
			inputTf1.setEnabled(true);
			inputTf1.setText("");
			graphingPanel.getPointRenderer1().clearPoints();
			graphingPanel.setShowPointRenderer1(true);
			graphingPanel.setGraphFunction1(false);
		}
		else if(e.getSource() == removeButton2) {
			inputTf2.setEnabled(true);
			inputTf2.setText("");
			graphingPanel.getPointRenderer2().clearPoints();
			graphingPanel.setShowPointRenderer2(true);
			graphingPanel.setGraphFunction2(false);
		}
		else if(e.getSource() == removeButton3) {
			inputTf3.setEnabled(true);
			inputTf3.setText("");
			graphingPanel.getPointRenderer3().clearPoints();
			graphingPanel.setShowPointRenderer3(true);
			graphingPanel.setGraphFunction3(false);
		}
	}
}
