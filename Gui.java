import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Gui extends JFrame{
	ArrayList<Entity> drawables = new ArrayList<Entity>();
	GameApp ga;
	public int offx = 0, offy = 0;
	BufferedImage doubleBuffer = new BufferedImage(800, 600, BufferedImage.TYPE_3BYTE_BGR);
	Graphics bg = doubleBuffer.getGraphics();
	public Gui(GameApp ga){
		this.ga = ga;
		this.drawables = ga.drawables;
		addKeyListener(ga);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(100, 100);
		setBackground(Color.BLACK);
		setVisible(true);
		setSize(800 + getInsets().left + getInsets().right, 600 + getInsets().top + getInsets().bottom);
		
	}
	public void paint(Graphics g){
		bg.clearRect(0, 0, getWidth(), getHeight());
		for(Entity e:drawables){
			e.draw(bg, offx, offy);
		}
		
		g.drawImage(doubleBuffer, getInsets().left, getInsets().top, null);
	}
}
