package bird;

import java.awt.Graphics;

public class ZiDan extends Thread implements Pao{
//	static int danx=PaoMove.paox+5;
//	static int dany=PaoMove.paoy+15;
	static boolean flag=false;
	Cage cage;
	int zidanx;
	int zidany;	
	boolean over;
	ZiDan(){
		zidanx=PaoMove.paox+5;
		zidany=PaoMove.paoy+15;
		start();
	}
	public void move(){
		zidany-=5;	 
	}
	
	public boolean getOver(){
		return over;
	}
	public void setOver(boolean over){
		this.over=over;
	}
	public void run(){
		while(zidany>-20){
			if(flag==true){
		        move();
			}
			
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}	
		over=true;
	}
	public static int getLocalx(ZiDan zidan){
		return zidan.zidanx+5;
	}
	public static int getLocaly(ZiDan zidan){
		return zidan.zidany;
	}
	public static void setLocala(ZiDan zidan){
		zidan.zidanx=-100;
	}
	public static void setLocalb(ZiDan zidan){
		zidan.zidany=-100;
	}
	public void draw3(Graphics g){

		g.drawImage(zidan, zidanx,zidany, 10,20,cage);
		
		
	}
}
