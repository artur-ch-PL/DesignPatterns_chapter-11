package com.chapter11._ach.vritualproxy;

import java.awt.Component;
import java.awt.Graphics;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ImageProxy implements Icon {
	URL imageURL;
	volatile ImageIcon imageIcon;
	boolean retriving = false;
	Thread retrievalThread;
	
	public ImageProxy(URL imageURL) {
		this.imageURL = imageURL;
	}
	
	@Override
	public int getIconHeight() {
		if(imageIcon != null){
			return imageIcon.getIconHeight();
		} else {
			return 640;
		}
	}

	@Override
	public int getIconWidth() {
		if(imageIcon != null){
			return imageIcon.getIconWidth();
		} else {
			return 480;
		}
	}
	
	synchronized void setImageIcon(ImageIcon imageIcon) {
		this.imageIcon = imageIcon;
	}

	@Override
	public void paintIcon(final Component c, Graphics g, int x, int y) {
		if(imageIcon != null){
			imageIcon.paintIcon(c, g, x, y);
		} else {
			g.drawString("Downloading crest...", x+240, y+310);
			if(!retriving){
				retriving = true;
				retrievalThread = new Thread(new Runnable() {
					@Override
					public void run() {
						setImageIcon(new ImageIcon(imageURL, "Football Club Crest"));
						c.repaint();
					}
				});
				retrievalThread.start();
			}
		}
	}

}
