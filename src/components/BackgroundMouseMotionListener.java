package components;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class BackgroundMouseMotionListener implements MouseMotionListener {
	private Background parent;
	
	public BackgroundMouseMotionListener(Background background) {
		parent = background;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		Point mousePoint = e.getPoint();
		Panel panel = parent.getPanelFromPosition(mousePoint);
		
		if(panel != null) {
			Dimension panelSize = panel.getSize();
			int x = mousePoint.x - (panelSize.width / 2);
			int y = mousePoint.y - (panelSize.height / 2);
			Point centerPoint = new Point(x, y);
			panel.setLocation(centerPoint);
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
