import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.*;

public class Panel extends JPanel {
	private final Dimension SIZE = new Dimension(100, 100);
	private final Point ORIGIN = new Point(50, 50);
	private Image image;
	
	public Panel(Displayable displayable) {
		this.setBounds(ORIGIN.x, ORIGIN.y, SIZE.width, SIZE.height);
		
		image = displayable.getImage().getScaledInstance(SIZE.width, SIZE.height, Image.SCALE_DEFAULT);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 10, 10, null);
	}
	
}
