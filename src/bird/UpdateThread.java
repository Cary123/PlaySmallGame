package bird;

import javax.swing.*;

public class UpdateThread extends Thread{
	JPanel panel;
	public UpdateThread(JPanel panel) {
		this.panel=panel;
		
	}
	public void run(){
		while(true){
		panel.repaint();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	}

}
