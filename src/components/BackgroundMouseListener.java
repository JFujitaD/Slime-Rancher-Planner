package components;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
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
		Point mousePoint = e.getPoint();
		Panel panel = parent.getPanelFromPosition(mousePoint);
		
		for(Component c : parent.getComponents()) {
			c.repaint();
		}
		
		if(panel != null) {
			if(parent.getSelectedPanel() != null) {
				parent.getSelectedPanel().setSelected(false);
			}
			panel.setSelected(true);
			panel.repaint();
			parent.setSelectedPanel(panel);
		} else {
			parent.getSelectedPanel().setSelected(false);
			parent.getSelectedPanel().repaint();
			parent.setSelectedPanel(null);
		}
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
