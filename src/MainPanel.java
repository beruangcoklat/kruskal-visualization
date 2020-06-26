import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainPanel extends JPanel {

	public static int WIDTH;
	public static int HEIGHT;
	private Kruskal kruskal = new Kruskal();
	
	public MainPanel() {
		setFocusable(true);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		kruskal.render(g);
		repaint();
		WIDTH = this.getWidth();
		HEIGHT = this.getHeight();
	}
	
	public void generateNode(int len){
		kruskal.generateNode(len);
	}
	
	public void doMST(){
		kruskal.doMST();
	}
	
}
