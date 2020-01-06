package GUI;
/*
 Brendan Aucoin
 2018/04/01
 this class is the gui for all the swing components that the user can interact with.
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import action_listeners.RemoveAction;
import action_listeners.PauseAction;
import action_listeners.StartAction;
import graphing.GraphingPanel;

public class MainGUI {
	public static final int WIDTH = 1250,HEIGHT = 700;
	public GridBagConstraints c;
	private TopMenu menu;
	private GraphingPanel graphingPanel;
	private SettingsPanel settingsPanel;
	private JFrame f;
	private JPanel mainPanel,titlePanel,inputPanel,sliderPanel;
	private JLabel titleLabel,inputLabel;
	private JButton startButton1,startButton2,startButton3;
	private JButton pauseButton1,pauseButton2,pauseButton3;
	private JButton removeButton1,removeButton2,removeButton3;
	private JTextField inputTf1,inputTf2,inputTf3;
	private JSlider slider;
	private JButton setIncrementButton;
	public MainGUI() {
		c = new GridBagConstraints();
		init();	
	}
	private void init() {
		/*the frame*/
		initFrame();
		/*the panels*/
		initPanels();
		/*the labels*/
		initLabels();
		/*the buttons*/
		initButtons();
		/*the text fields*/
		initTextFields();
		/*the slider*/
		initSlider();
		
		makePanels();
		makeFrame();
		addActionListeners();
	}
	private void makeFrame() {
		f.add(mainPanel,BorderLayout.WEST);
		graphingPanel = new GraphingPanel();
		addGraphingPanel();
		
		settingsPanel = new SettingsPanel(this,graphingPanel);
		menu = new TopMenu(this,f);
		menu.addToFrame();
		f.setVisible(true);
		graphingPanel.start();
		f.repaint();
		f.revalidate();
	}
	public void addGraphingPanel() {
		f.add(graphingPanel,BorderLayout.CENTER);
	}
	public void addSettingsPanel() {
		f.remove(mainPanel);
		f.add(settingsPanel,BorderLayout.WEST);
		f.repaint();
		f.revalidate();
	}
	public void removeSettingsPanel() {
		f.remove(settingsPanel);
		f.add(mainPanel,BorderLayout.WEST);
		f.repaint();
		f.revalidate();
	}
	private void makePanels() {
		/*the title panel*/
		titlePanel.add(titleLabel,BorderLayout.CENTER);
		mainPanel.add(titlePanel,BorderLayout.NORTH);
		/*the input panel*/
		c.insets = new Insets(5,5,5,5);
		/*the first set*/
		JLabel firstSetLabel = null;
		firstSetLabel = GUI.setLabel(firstSetLabel, "Function 1", new Font("arial",Font.PLAIN,20), Color.BLACK);
		JLabel secondSetLabel = null;
		secondSetLabel = GUI.setLabel(secondSetLabel, "Function 2", new Font("arial",Font.PLAIN,20), Color.BLACK);
		JLabel thirdSetLabel = null;
		thirdSetLabel = GUI.setLabel(thirdSetLabel, "Function 3", new Font("arial",Font.PLAIN,20), Color.BLACK);
		
		c.weighty = 0.1;
		c.gridx = 1;
		c.gridy = 0;
		inputPanel.add(firstSetLabel,c);
		c.gridx = 1;
		c.gridy = 1;
		inputPanel.add(inputTf1,c);
		c.gridx = 2;
		c.gridy = 1;
		inputPanel.add(startButton1,c);
		c.gridx = 3;
		c.gridy = 1;
		inputPanel.add(pauseButton1,c);
		c.gridx = 4;
		c.gridy = 1;
		inputPanel.add(removeButton1,c);
		/*the second set*/
		c.gridx = 1;
		c.gridy =2;
		inputPanel.add(secondSetLabel,c);
		c.gridx = 1;
		c.gridy = 3;
		inputPanel.add(inputTf2,c);
		c.gridx = 2;
		c.gridy = 3;
		inputPanel.add(startButton2,c);
		c.gridx = 3;
		inputPanel.add(pauseButton2,c);
		c.gridx = 4;
		inputPanel.add(removeButton2,c);
		/*the third set*/
		c.gridx = 1;
		c.gridy = 4;
		inputPanel.add(thirdSetLabel,c);
		c.gridx = 1;
		c.gridy = 5;
		inputPanel.add(inputTf3,c);
		c.gridx = 2;
		c.gridy = 5;
		inputPanel.add(startButton3,c);
		c.gridx = 3;
		inputPanel.add(pauseButton3,c);
		c.gridx =4;
		inputPanel.add(removeButton3,c);
		
		mainPanel.add(inputPanel,BorderLayout.CENTER);
		
		/*the slider panel*/
		c.insets = new Insets(3,3,3,3);
		JLabel setIncrementLabel = null;
		setIncrementLabel = GUI.setLabel(setIncrementLabel, "Set Increment", new Font("arial",Font.PLAIN,20), Color.BLACK);
		c.gridx = 0;
		c.gridy = 0;
		sliderPanel.add(setIncrementLabel,c);
		c.gridx = 0;
		c.gridy =1;
		c.weightx = 1;
		sliderPanel.add(slider,c);
		c.gridx = 1;
		c.gridy = 1;
		sliderPanel.add(setIncrementButton,c);
		//mainPanel.add(sliderPanel,BorderLayout.SOUTH);
	}
	private void addActionListeners() {
		startButton1.addActionListener(new StartAction(graphingPanel,inputTf1,startButton1,inputTf2,startButton2,inputTf3,startButton3));
		startButton2.addActionListener(new StartAction(graphingPanel,inputTf1,startButton1,inputTf2,startButton2,inputTf3,startButton3));
		startButton3.addActionListener(new StartAction(graphingPanel,inputTf1,startButton1,inputTf2,startButton2,inputTf3,startButton3));
	
		pauseButton1.addActionListener(new PauseAction(graphingPanel,pauseButton1,pauseButton1,pauseButton1));
		pauseButton2.addActionListener(new PauseAction(graphingPanel,pauseButton2,pauseButton2,pauseButton2));
		pauseButton3.addActionListener(new PauseAction(graphingPanel,pauseButton3,pauseButton3,pauseButton3));
		
		removeButton1.addActionListener(new RemoveAction(graphingPanel,inputTf1,removeButton1,inputTf2,removeButton2,inputTf3,removeButton3));
		removeButton2.addActionListener(new RemoveAction(graphingPanel,inputTf1,removeButton1,inputTf2,removeButton2,inputTf3,removeButton3));
		removeButton3.addActionListener(new RemoveAction(graphingPanel,inputTf1,removeButton1,inputTf2,removeButton2,inputTf3,removeButton3));
	}
	private void initButtons() {
		/*the input buttons*/
		/*the start buttons*/
		startButton1 = GUI.setButton(startButton1, "Graph", new Dimension(80,40), new Color(176,196,222), Color.BLACK, new Font("arial",Font.PLAIN,20), null);
		startButton1.setBorder(new RoundedBorder(3));
		
		startButton2 = GUI.setButton(startButton2, "Graph", new Dimension(80,40), new Color(176,196,222), Color.BLACK, new Font("arial",Font.PLAIN,20), null);
		startButton2.setBorder(new RoundedBorder(3));
		
		startButton3 = GUI.setButton(startButton3, "Graph", new Dimension(80,40), new Color(176,196,222), Color.BLACK, new Font("arial",Font.PLAIN,20), null);
		startButton3.setBorder(new RoundedBorder(3));
		
		/*the show buttons*/
		pauseButton1 = GUI.setButton(pauseButton1, "Pause", new Dimension(80,40), new Color(176,196,222), Color.BLACK, new Font("arial",Font.PLAIN,20), null);
		pauseButton1.setBorder(new RoundedBorder(3));
		pauseButton2 = GUI.setButton(pauseButton2, "Pause", new Dimension(80,40), new Color(176,196,222), Color.BLACK, new Font("arial",Font.PLAIN,20), null);
		pauseButton2.setBorder(new RoundedBorder(3));
		pauseButton3 = GUI.setButton(pauseButton3, "Pause", new Dimension(80,40), new Color(176,196,222), Color.BLACK, new Font("arial",Font.PLAIN,20), null);
		pauseButton3.setBorder(new RoundedBorder(3));
		/*the removeButtons*/
		removeButton1 = GUI.setButton(removeButton1, "Remove", new Dimension(80,40), new Color(176,196,222), Color.BLACK, new Font("arial",Font.PLAIN,20), null);
		removeButton1.setBorder(new RoundedBorder(3));
		removeButton2 = GUI.setButton(removeButton2, "Remove", new Dimension(80,40), new Color(176,196,222), Color.BLACK, new Font("arial",Font.PLAIN,20), null);
		removeButton2.setBorder(new RoundedBorder(3));
		removeButton3 = GUI.setButton(removeButton3, "Remove", new Dimension(80,40), new Color(176,196,222), Color.BLACK, new Font("arial",Font.PLAIN,20), null);
		removeButton3.setBorder(new RoundedBorder(3));
		/*the incrmement button*/
		setIncrementButton = GUI.setButton(setIncrementButton, "Set", new Dimension(100,40), new Color(175,196,222), Color.BLACK, new Font("arial",Font.PLAIN,25), null);
	
		
	}
	private void initSlider() {
		slider = new JSlider(1,27,2);
		slider.setMajorTickSpacing(4);
		slider.setMinorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setSnapToTicks(true);
	}
	private void initTextFields() {
		inputTf1 = GUI.setTextField(inputTf1, 10, new Dimension(10,18), "", true);
		inputTf2 = GUI.setTextField(inputTf2, 10, new Dimension(10,18), "", true);
		inputTf3 = GUI.setTextField(inputTf3, 10, new Dimension(10,18), "", true);
	}
	private void initFrame() {
		f = GUI.setFrame(f, "Desmos 2.0", new Dimension(WIDTH,HEIGHT), new BorderLayout(), false);
		Image img = new ImageIcon(this.getClass().getResource("/dogIcon.png")).getImage();
		f.setIconImage(img);
	}
	private void initLabels() {
		/*the title label*/
		titleLabel = GUI.setLabel(titleLabel, "Desmos 2.0", new Font("Arial",Font.BOLD,50), new Color(255,215,0));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		/*the inputLabel*/
		inputLabel = GUI.setLabel(inputLabel, "Enter your function", new Font("Arial",Font.PLAIN,20),Color.BLACK);
	}
	private void initPanels() {
		mainPanel = new JPanel(new BorderLayout());
		mainPanel.setMaximumSize(new Dimension((int)(WIDTH/2.9),HEIGHT));
		mainPanel.setMinimumSize(new Dimension((int)(WIDTH/2.9),HEIGHT));
		mainPanel.setPreferredSize(new Dimension((int)(WIDTH/2.9),HEIGHT));
		mainPanel.setBackground(new Color(240,255,255));
		mainPanel.setBorder(new LineBorder(Color.GRAY,3));
		titlePanel = new JPanel(new BorderLayout());
		titlePanel.setBackground(new Color(240,255,255));
		inputPanel = new JPanel(new GridBagLayout());
		inputPanel.setBackground(new Color(240,255,255));
		
		sliderPanel = new JPanel(new GridBagLayout());
		sliderPanel.setBackground(new Color(240,255,255));
	}
	
}
