import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

import javax.swing.*;

public class Background extends JPanel implements ImageObserver {
	private Image image = new ImageIcon("resources/background.jpg").getImage();
	private JFrame parent;

	public Background(JFrame frame) {
		this.parent = frame;
		this.setLayout(null);
	
		Rectangle bounds = parent.getBounds();	
		image = image.getScaledInstance(bounds.width, bounds.height, Image.SCALE_DEFAULT);
	}

	@Override
	public boolean imageUpdate(Image img, int infoflags, int x, int y, int w, int h) {
		this.repaint();
		return true;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
	}
	
}
