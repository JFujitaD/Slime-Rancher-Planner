import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.*;

public class Background extends JPanel{
	private Image image = new ImageIcon("resources/background.jpg").getImage();
	private JFrame parent;

	public Background(JFrame frame) {
		this.parent = frame;
		this.setLayout(null);
	
		Rectangle bounds = parent.getBounds();	
		image = image.getScaledInstance(bounds.width, bounds.height, Image.SCALE_DEFAULT);
		
		// TEMPORARY
		Panel slimePanel = new Panel(SlimeRancherRepository.getSlime());
		this.add(slimePanel);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
	}
	
}
