package components;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BackgroundMouseListener implements MouseListener {
	private Background parent;
	
	public BackgroundMouseListener(Background background) {
		parent = background;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		parent.getDatabaseManager().saveToDatabase(parent.getComponents());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
