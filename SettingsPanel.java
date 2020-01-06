package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import equation_handling.DataStructure;
import graphing.GraphingPanel;

public class SettingsPanel extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JLabel titleLabel;
	private JTextField xScaleTf,yScaleTf,squareSizeTf;
	private JButton applyButton,backButton;
	private JCheckBox showLineBox;
	private GraphingPanel graphingPanel;
	private JPanel mainPanel,titlePanel,inputPanel;
	private MainGUI mainGUI;
	public static GridBagConstraints c = new GridBagConstraints();
	public SettingsPanel(MainGUI mainGUI,GraphingPanel graphingPanel) {
		super();
		this.mainGUI = mainGUI;
		this.graphingPanel = graphingPanel;
		this.setBackground(new Color(240,255,255));
		this.setLayout(new BorderLayout());
		this.setMaximumSize(new Dimension((int)(MainGUI.WIDTH/2.4),MainGUI.HEIGHT));
		this.setMinimumSize(new Dimension((int)(MainGUI.WIDTH/2.4),MainGUI.HEIGHT));
		this.setPreferredSize(new Dimension((int)(MainGUI.WIDTH/2.4),MainGUI.HEIGHT));
		
		init();
		makePanel();
		add(mainPanel,BorderLayout.CENTER);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== applyButton) {
			String xScaleStr = xScaleTf.getText();
			String yScaleStr = yScaleTf.getText();
			String squareSizeStr = squareSizeTf.getText();
			//boolean showLine = showLineButton.isSelected();
			boolean showLine = showLineBox.isSelected();
			System.out.println(showLine);
			/*converting all the strings to ints and changing the graphing panel varaibale*/
			if(showLine) {
				DataStructure.random = false;
			}
			else {
				DataStructure.random = true;
			}
			int xScale = 0;
			int yScale = 0;
			int squareSize = 0;
			if(!xScaleStr.equals("") || !yScaleStr.equals("") || !squareSizeStr.equals("")) {
			try {
			 xScale = Integer.parseInt(xScaleStr);
			 yScale = Integer.parseInt(yScaleStr);
			 squareSize = Integer.parseInt(squareSizeStr);
			}catch(NumberFormatException ex) {JOptionPane.showMessageDialog(null, "Error You Must Enter All Fields Correctly");return;}
			
			if(xScale <2 || yScale < 2) {JOptionPane.showMessageDialog(null, "The Scale must be more than 2");return;}
			if(xScale >100 || yScale >100) {JOptionPane.showMessageDialog(null, "The Scale must be less than 100");return;}
			if(squareSize <16) {JOptionPane.showMessageDialog(null, "The square size must be more than than 16");return;}
			if(squareSize > 120) {JOptionPane.showMessageDialog(null, "The square size must be less than 120");return;}
			
			graphingPanel.getGraph().setSquareSize(squareSize);
			graphingPanel.getGraph().setxIncrement(xScale);
			graphingPanel.getGraph().setyIncrement(yScale);
			}
			xScaleTf.setText("");
			yScaleTf.setText("");
			squareSizeTf.setText("");
			mainGUI.removeSettingsPanel();
		}
		
		else if(e.getSource()== backButton) {
			xScaleTf.setText("");
			yScaleTf.setText("");
			squareSizeTf.setText("");
			mainGUI.removeSettingsPanel();
		}
	}
	private void init() {
		titleLabel = GUI.setLabel(titleLabel, "Settings", new Font("Arial",Font.BOLD,50), new Color(255,215,0));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		xScaleTf = GUI.setTextField(xScaleTf, 10, new Dimension(10,18), "", true);
		yScaleTf = GUI.setTextField(xScaleTf, 10, new Dimension(10,18), "", true);
		squareSizeTf = GUI.setTextField(xScaleTf, 10, new Dimension(10,18), "", true);
		
		applyButton = GUI.setButton(applyButton, "Apply", new Dimension(90,40), new Color(176,196,222), Color.BLACK, new Font("arial",Font.PLAIN,20), this); 
		backButton = GUI.setButton(backButton, "Back", new Dimension(90,40), new Color(176,196,222), Color.BLACK, new Font("arial",Font.PLAIN,20), this);
		applyButton.setBorder(new RoundedBorder(3));
		backButton.setBorder(new RoundedBorder(3));
		
		showLineBox = new JCheckBox("Show Line");
		showLineBox.setBackground(new Color(240,255,255));
		
		mainPanel = GUI.setPanel(mainPanel, new Color(240,255,255), new Dimension(0,0), new BorderLayout());
		titlePanel = GUI.setPanel(titlePanel, new Color(240,255,255), new Dimension(0,0), new BorderLayout());
		inputPanel = GUI.setPanel(mainPanel, new Color(240,255,255), new Dimension(0,0), new GridBagLayout());
	}
	
	
	private void makePanel() {
		c.insets = new Insets(10,10,10,10);
		c.weighty = 2;
		c.gridx = 1;
		c.gridy = 0;
		inputPanel.add(titleLabel,c);
		JLabel xScaleLabel = null;
		xScaleLabel = GUI.setLabel(xScaleLabel, "x scale", new Font("arial",Font.PLAIN,12), Color.BLACK);
		JLabel yScaleLabel = null;
		yScaleLabel = GUI.setLabel(xScaleLabel, "y scale", new Font("arial",Font.PLAIN,12), Color.BLACK);
		JLabel squareSizeLabel = null;
		squareSizeLabel = GUI.setLabel(squareSizeLabel, "square size", new Font("arial",Font.PLAIN,12), Color.BLACK);
		
		c.gridx = 1;
		c.gridy =1;
		inputPanel.add(xScaleLabel,c);
		c.gridx = 1;
		c.gridy = 2;
		inputPanel.add(xScaleTf,c);
		
		c.gridx = 1;
		c.gridy = 3;
		inputPanel.add(yScaleLabel,c);
		c.gridx = 1;
		c.gridy = 4;
		inputPanel.add(yScaleTf,c);
		
		c.gridx = 1;
		c.gridy =5;
		inputPanel.add(squareSizeLabel,c);
		c.gridx = 1;
		c.gridy = 6;
		inputPanel.add(squareSizeTf,c);
		
		//c.gridx = 1;
		//c.gridy = 7;
		//inputPanel.add(showLineBox,c);
		
		c.gridx = 0;
		c.gridy = 8;
		inputPanel.add(applyButton,c);
		
		c.gridx = 3;
		c.gridy = 8;
		inputPanel.add(backButton,c);
		
		mainPanel.add(inputPanel,BorderLayout.CENTER);
	}
	
	
	
}
