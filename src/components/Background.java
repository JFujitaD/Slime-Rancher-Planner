package components;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

import javax.swing.*;

public class Background extends JPanel implements ImageObserver {
	private Image image = new ImageIcon("resources/background.jpg").getImage();
	private JFrame parent;

	public Background(JFrame frame) {
		parent = frame;
		setLayout(null);
		
		addMouseMotionListener(new BackgroundMouseMotionListener(this));
	
		Rectangle bounds = parent.getBounds();	
		image = image.getScaledInstance(bounds.width, bounds.height, Image.SCALE_DEFAULT);
	}
	
	public Panel getPanelFromPosition(Point point) {
		Component[] components = getComponents();
		
		for(Component c : components) {
			Panel p = (Panel) c;
			int x = p.getX();
			int y = p.getY();
			int w = p.getWidth();
			int h= p.getHeight();
			
			if((point.x >= x && point.x <= x + w) && (point.y >= y && point.y <= y + h)) {
				return p;
			} 
		}
		return null;
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
