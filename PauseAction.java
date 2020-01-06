package action_listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import equation_handling.DataStructure;
import graphing.GraphingPanel;

public class PauseAction implements ActionListener {
	private JButton showButton1,showButton2,showButton3;
	private GraphingPanel graphingPanel;
	public PauseAction(GraphingPanel graphingPanel,JButton showButton1,JButton showButton2,JButton showButton3) {
		this.showButton1 = showButton1;
		this.showButton2 = showButton2;
		this.showButton3 = showButton3;
		this.graphingPanel = graphingPanel;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == showButton1) {
			//graphingPanel.setShowPointRenderer1(!graphingPanel.isShowPointRenderer1());
			graphingPanel.setGraphFunction1(!graphingPanel.isGraphFunction1());
		}
		else if(e.getSource() == showButton2) {
			//graphingPanel.setShowPointRenderer2(!graphingPanel.isShowPointRenderer2());
			graphingPanel.setGraphFunction2(!graphingPanel.isGraphFunction2());
		}
		else if(e.getSource() == showButton3) {
			//graphingPanel.setShowPointRenderer3(!graphingPanel.isShowPointRenderer3());
			graphingPanel.setGraphFunction3(!graphingPanel.isGraphFunction3());
		}
	}
}
