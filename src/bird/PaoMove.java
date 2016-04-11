package bird;

import java.awt.Image;

import javax.swing.ImageIcon;

public class PaoMove extends Thread implements Pao{
	static boolean left=false;
	static boolean right=false;
	Cage cage;

	static int paox=300;
	static int paoy=565;
	public void move(){
		if(left==true){
			if(paox>0){
			paox=paox-2;
			}
			else
				paox=0;
		}
		else if(right==true){
			if(paox<580){
			paox=paox+2;
			}
			else
				paox=580;
		}
	}
	public void run(){
		while(true){
		move();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
}
