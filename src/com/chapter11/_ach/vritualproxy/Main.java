package com.chapter11._ach.vritualproxy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Main {
	private final String APP_TITLE = "Premierleague Footbal Crests";
	private final String INIT_CREST = "Arsenal";

	ImageComponent imageComponent;
	JFrame frame = new JFrame("Football Crests");
	JMenuBar menuBar;
	JMenu menu;
	Hashtable<String, String> crests = new Hashtable<String, String>();
	
	public static void main(String[] args) throws Exception {
		@SuppressWarnings("unused")
		Main main = new Main();
	}

	public Main() throws Exception {
		loadCrests();
		initMainWindow();
		reloadMainWindow();
	} 
	
	private void loadCrests(){
		crests.put("Arsenal", "http://i373.photobucket.com/albums/oo176/catur_pj2000album/my%20picture/arsenal_logo.jpg");
		crests.put("Chelsea", "https://vignette1.wikia.nocookie.net/lostpedia/images/2/23/Th_chelsea_crest.jpg");
		crests.put("Manchester Utd.", "http://i.dailymail.co.uk/i/pix/2013/07/22/article-2373176-1AEFCE0E000005DC-673_148x152.jpg");
	}
	
	
	private void initMainWindow() throws MalformedURLException{
		initImageComponent();
		createTopBar();
	}
	
	private void initImageComponent() throws MalformedURLException{
		URL initialURL = new URL((String) crests.get(INIT_CREST));
		Icon icon = new ImageProxy(initialURL);
		imageComponent = new ImageComponent(icon);
	}
	
	private void createTopBar(){
		menuBar = new JMenuBar();
		menu = new JMenu(APP_TITLE);
		menuBar.add(menu);
		frame.setJMenuBar(menuBar);
		
		prepareCrestsMenuWithActionListner();
	}
	
	private void prepareCrestsMenuWithActionListner(){
		for(Enumeration<String> enumeration = crests.keys(); enumeration.hasMoreElements();){
			String name = enumeration.nextElement();
			JMenuItem menuItem = new JMenuItem(name);
			
			menu.add(menuItem);
			
			menuItem.addActionListener(new ActionListener() {
				private URL url;

				public void actionPerformed(ActionEvent event) {
					try {
						url = string2URL(event.getActionCommand());
					} catch (MalformedURLException e) {
						e.printStackTrace();
					} finally{
						imageComponent.setIcon(new ImageProxy(url));
						frame.repaint();
					}
				}
			});
		}
	}
	
	private void reloadMainWindow(){
		frame.getContentPane().add(imageComponent);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(640, 480);
		frame.setVisible(true);
	}
	
	private URL string2URL(String name) throws MalformedURLException{
			return new URL((String) crests.get(name));
	}
}
