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
		crests.put("Arsenal", "http://upload.wikimedia.org/wikipedia/en/thumb/5/53/Arsenal_FC.svg/323px-Arsenal_FC.svg.png");
		crests.put("Chelsea", "http://upload.wikimedia.org/wikipedia/en/thumb/c/cc/Chelsea_FC.svg/209px-Chelsea_FC.svg.png");
		crests.put("Manchester Utd.", "http://i.dailymail.co.uk/i/pix/2013/07/22/article-2373176-1AEFCE0E000005DC-673_148x152.jpg");
		
		URL initialURL = new URL((String) crests.get("Arsenal"));
		menuBar = new JMenuBar();
		menu = new JMenu("Premierleague Footbal Crests");
		menuBar.add(menu);
		frame.setJMenuBar(menuBar);
		
		for(Enumeration<String> e = crests.keys(); e.hasMoreElements();){
			String name = e.nextElement();
			JMenuItem menuItem = new JMenuItem(name);
			menu.add(menuItem);
			menuItem.addActionListener(new ActionListener() { 
			    public void actionPerformed(ActionEvent e) { 
					imageComponent.setIcon(new ImageProxy(string2URL(e.getActionCommand())));
					frame.repaint();
			    }
			});
		}
		
		Icon icon = new ImageProxy(initialURL);
		imageComponent = new ImageComponent(icon);
		frame.getContentPane().add(imageComponent);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(640, 480);
		frame.setVisible(true);
	} 
	
	public URL string2URL(String name){
		try {
			return new URL((String) crests.get(name));
		}
		catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
