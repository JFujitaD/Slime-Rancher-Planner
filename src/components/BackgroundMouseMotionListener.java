package components;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class BackgroundMouseMotionListener implements MouseMotionListener {
	private Background parent;
	
	public BackgroundMouseMotionListener(Background background) {
		parent = background;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		Panel panel = parent.getPanelFromPosition(e.getPoint());
		
		if(panel != null) {
			// Implement dragging feature
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
