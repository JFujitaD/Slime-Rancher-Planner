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
		Panel selectedPanel = parent.getSelectedPanel();
		
		if(selectedPanel != null) {
			Dimension panelSize = selectedPanel.getSize();
			Point mousePoint = e.getPoint();
			int x = mousePoint.x - (panelSize.width / 2);
			int y = mousePoint.y - (panelSize.height / 2);
			Point centerPoint = new Point(x, y);
			selectedPanel.setLocation(centerPoint);
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
