package components;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.ImageObserver;

import javax.swing.*;

import models.Displayable;

public class Panel extends JPanel implements ImageObserver {
	private static final Dimension SIZE = new Dimension(100, 100);
	private static final Point ORIGIN = new Point(50, 50);
	private Image image;
	private String name;
	
	public Panel(Displayable displayable) {
		setBounds(ORIGIN.x, ORIGIN.y, SIZE.width, SIZE.height);
		name = displayable.getName();
		image = displayable.getImage().getScaledInstance(SIZE.width, SIZE.height, Image.SCALE_DEFAULT);
	}
	
	public Panel(Displayable displayable, Dimension customSize) {
		setBounds(0, 0, customSize.width, customSize.height);
		name = displayable.getName();
		image = displayable.getImage().getScaledInstance(customSize.width, customSize.height, Image.SCALE_DEFAULT);
	}
	
	public String getName() {
		return name;
	}

	@Override
	public boolean imageUpdate(Image img, int infoflags, int x, int y, int w, int h) {
		repaint();
		return true;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
	}
	
}
