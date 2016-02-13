package simon;
import javax.swing.JFrame;

import java.awt.*;
public class Screen {
	private GraphicsDevice vc;
	
	public Screen(){
		// get acces to graphics card
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		vc = env.getDefaultScreenDevice();		
	}
	public void setFullScreen(DisplayMode dm, JFrame window){
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// window not decorated 
		window.setUndecorated(true);
		// set full screen 
		window.setResizable(false);
		// take window and set it to full screen
		vc.setFullScreenWindow(window);
		if(dm != null && vc.isDisplayChangeSupported()){
			try {
				vc.setDisplayMode(dm);
			} catch (Exception e) {
				System.out.println("ERROR SCREEN");
			}
		}
	}
	
	public Window getFullScreenWindow(){
		return vc.getFullScreenWindow();
	}
	
	public void restoreScreen(){
		Window w = vc.getFullScreenWindow();
		if (w != null) {
			w.dispose();
		}
		vc.setFullScreenWindow(null);
	}
}
