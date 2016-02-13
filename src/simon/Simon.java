package simon;
import javax.swing.JFrame;

import simon.Screen;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.renderable.RenderableImageOp;
import java.util.ArrayList;
import java.util.List;

public class Simon extends JFrame {
	
    private List<Rectangle> boxes;
    private int width = 50;
    private int height = 50;
    private int startX = 10;
    private int startY = 20;
	
	private Image doubleBufferImage;
	private Graphics dbGraphics;
	public Simon() {
		// TODO Auto-generated constructor stub
		jpanel();
		
	}
	public void jpanel(){
		setTitle("Java Game");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//DisplayMode md = new DisplayMode(800, 600, 16, DisplayMode.REFRESH_RATE_UNKNOWN);
		
	}
	
	public static void main(String[] args) {
		DisplayMode dm = new DisplayMode(800, 600, 16, DisplayMode.REFRESH_RATE_UNKNOWN);
		Simon sim = new Simon();
		sim.run(dm);
	}
	public void run(DisplayMode dm){
		setBackground(Color.pink);
		setForeground(Color.white);
		Screen screen = new Screen();
		try {
			screen.setFullScreen(dm, this);
			try {
				Thread.sleep(3000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		} finally {
			screen.restoreScreen();
		}
		
	}
	
	public void paintComponent(Graphics g){
//		super.paintComponents(g);
//		boxes = new ArrayList<Rectangle>();
//        for(int i =0;i<4;i++){
//        	//boxes.add(new Rectangle(startX+(width+startX)*i, startY, width, height));
//        	for (int j = 0; j < 4; j++) {
//        		boxes.add(new Rectangle(startX+(width+startX)*i, startY, width, height));
//			}
//        }
//      
//        Graphics2D g2 = (Graphics2D) g;
//        for(int i =0;i<boxes.size();i++){
//            g2.draw(boxes.get(i));
//        }
//        g2.setColor(Color.BLUE);
//        for(int i =0;i<boxes.size();i++){
//            g2.fill(boxes.get(i));
//        }

	}
	public Dimension getPreferredSize(){
		return new Dimension(boxes.size()*(width+startX)+startX,height+startY*2);
	}
	public void paint(Graphics g){
		
		//paintComponent(g);
		Rectangle r1 = new Rectangle(200, 76, 300, 300);
		Rectangle r2 = new Rectangle(100, 180, 300, 300);
		Rectangle r3 = new Rectangle(400, 170, 300, 300);
		Rectangle r4 = new Rectangle(500, 100, 300, 300);
		g.setColor(Color.YELLOW);
		g.fillRect(r1.x, r1.y, r1.width, r1.height);
		g.setColor(Color.BLUE);
		g.fillRect(r2.x, r2.y, r2.width, r2.height);
		g.setColor(Color.RED);
		g.fillRect(r3.x, r3.y, r3.width, r3.height);
		g.setColor(Color.GREEN);
		g.fillRect(r4.x, r4.y, r4.width, r4.height);
		
		repaint();		

	}

}
