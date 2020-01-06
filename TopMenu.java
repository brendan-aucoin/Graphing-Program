package GUI;
/*
 Brendan Aucoin
 2018/04/01
 this class is the class that holds all the data for the menu bar and what it contains and does
 upon action.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import equation_handling.Equation;
import graphing.GraphingPanel;
import music.MusicPlayer;

public class TopMenu implements ActionListener{
	public static final String COUNTRY_GIRL_PATH = "country girl.wav";
	public static final String HELL_PATROL_PATH = "hell patrol.wav";
	private JFrame f;
	private MusicPlayer musicPlayer;
	private JMenuBar mb;
	private JMenu settings,timeDelay,music;
	private JMenuItem changeSettingsItem;
	private JMenuItem setTimeDelayItem;
	private JMenuItem countryGirlStartItem,countryGirlPlayItem,countryGirlPauseItem,hellPatrolStartItem,hellPatrolPlayItem,hellPatrolPauseItem;
	private MainGUI mainGUI;
	public TopMenu(MainGUI mainGUI,JFrame f) {
		this.mainGUI = mainGUI;
		this.f = f;
		musicPlayer = new MusicPlayer();
		init();
	}
	
	
	/*the action*/
	public void actionPerformed(ActionEvent e) {
		/*settings*/
		if(e.getSource() == changeSettingsItem) {
			mainGUI.addSettingsPanel();
		}
		/*time delay*/
		if(e.getSource() == setTimeDelayItem) {
			String timeDelayStr = "";
			int timeDelay = 0;
			try {
			timeDelayStr = JOptionPane.showInputDialog(null,"Enter what time delay you would like. (1-15)");
			 timeDelay = Integer.parseInt(timeDelayStr);}
			catch(NumberFormatException ex) {JOptionPane.showMessageDialog(null, "Error");timeDelay =9;return;}
			catch(InputMismatchException ex) {JOptionPane.showMessageDialog(null, "Error");timeDelay = 9;return;}
			catch(NullPointerException ex) {timeDelay = 9;return;}
			if(timeDelay > 100 || timeDelay < 0) {JOptionPane.showMessageDialog(null,"You must enter a number between 1 and 12");}
			GraphingPanel.gameLoopTimeDelay = timeDelay;
			Equation.amount = timeDelay;
		}
		/*music*/
		else if(e.getSource() == countryGirlStartItem) {
			musicPlayer.playSound(COUNTRY_GIRL_PATH);
			countryGirlPlayItem.setEnabled(true);
			countryGirlPauseItem.setEnabled(true);
			hellPatrolPlayItem.setEnabled(false);
			hellPatrolPauseItem.setEnabled(false);
		}
		else if(e.getSource() == countryGirlPlayItem) {
			musicPlayer.startSound();
			
			countryGirlPlayItem.setEnabled(false);
			countryGirlPauseItem.setEnabled(true);
		}
		else if(e.getSource() == countryGirlPauseItem) {
			musicPlayer.stopSound();
			
			countryGirlPauseItem.setEnabled(false);
			countryGirlPlayItem.setEnabled(true);
		}
		else if(e.getSource() == hellPatrolStartItem) {
			musicPlayer.playSound(HELL_PATROL_PATH);
			hellPatrolPlayItem.setEnabled(true);
			hellPatrolPauseItem.setEnabled(true);
			countryGirlPlayItem.setEnabled(false);
			countryGirlPauseItem.setEnabled(false);
		}
		else if(e.getSource() == hellPatrolPlayItem) {
			musicPlayer.startSound();
			
			hellPatrolPlayItem.setEnabled(false);
			hellPatrolPauseItem.setEnabled(true);
		}
		else if(e.getSource() == hellPatrolPauseItem) {
			musicPlayer.stopSound();
			
			hellPatrolPauseItem.setEnabled(false);
			hellPatrolPlayItem.setEnabled(true);
		}
	}
	private void init() {
		mb = new JMenuBar();
		/*the menus*/
		settings = new JMenu("Settings");
		settings.addActionListener(this);
		timeDelay = new JMenu("Time Delay");
		music = new JMenu("Music");
		/*the menu items*/
		changeSettingsItem = new JMenuItem("Change Settings");
		changeSettingsItem.addActionListener(this);
		setTimeDelayItem = new JMenuItem("set Time Delay");
		setTimeDelayItem.addActionListener(this);
		countryGirlStartItem = new JMenuItem("Start Country Girl");
		countryGirlStartItem.addActionListener(this);
		countryGirlPlayItem = new JMenuItem("Play Country Girl");
		countryGirlPlayItem.addActionListener(this);
		countryGirlPlayItem.setEnabled(false);
		countryGirlPauseItem = new JMenuItem("Pause Country Girl");
		countryGirlPauseItem.addActionListener(this);
		countryGirlPauseItem.setEnabled(false);
		hellPatrolStartItem = new JMenuItem("Start Hell Patrol");
		hellPatrolStartItem.addActionListener(this);
		hellPatrolPlayItem = new JMenuItem("Play Hell Patrol");
		hellPatrolPlayItem.addActionListener(this);
		hellPatrolPlayItem.setEnabled(false);
		hellPatrolPauseItem = new JMenuItem("Pause Hell Patrol");
		hellPatrolPauseItem.addActionListener(this);
		hellPatrolPauseItem.setEnabled(false);
		addToMenuBar();
	}
	private void addToMenuBar() {
		/*the settings*/
		settings.add(changeSettingsItem);
		/*the time delay*/
		timeDelay.add(setTimeDelayItem);
		/*the music*/
		music.add(countryGirlStartItem);
		music.add(countryGirlPlayItem);
		music.add(countryGirlPauseItem);
		music.add(hellPatrolStartItem);
		music.add(hellPatrolPlayItem);
		music.add(hellPatrolPauseItem);
		
		mb.add(settings);
		mb.add(timeDelay);
		mb.add(music);
	}
	
	public void addToFrame() {
		f.setJMenuBar(mb);
	}
}
