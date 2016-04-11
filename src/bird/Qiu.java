package bird;
import java.awt.*;
import java.awt.Event.*;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

public class Qiu extends Thread{
	private int xdir=2*(1-2*(int)Math.round(Math.random()));
	private int ydir=2*(1-2*(int)Math.round(Math.random()));
	private boolean running=false;
	private Cage cage=null;
	int x;
	int y;

	ImageIcon iconhudie=new ImageIcon("image/ppyellow.png");
	ImageIcon iconbird=new ImageIcon("image/ppblue.png");
	
//	ImageIcon icon2=new ImageIcon("picture//girl.jpg");
//	ImageIcon icon3=new ImageIcon("picture//ccc.jpg");
//	ImageIcon icon4=new ImageIcon("picture//ccc.jpg");
	
	Image hudie = iconhudie.getImage();
    Image bird = iconbird.getImage();
	public Qiu(Cage _cage,int _x,int _y)
	{
		cage=_cage;
		x=_x;
		y=_y;
		start();
	}
   public void start(){
	   running=true;
	   super.start();
   }
   public void halt(){
	   running=!running;
   }
   private void move(){
	   x+=xdir;
	   y+=ydir;
	   if(x>(cage.getWidth()-265)){
		   x=cage.getWidth()-265;
		   xdir*=(-1);
		  
	   }
	   if(x<0)
		   xdir*=(-1);
	   if(y>cage.getHeight()-215){
		   y=cage.getHeight()-215;
		   ydir*=(-1);
	   }
	   if(y<0)
		   ydir*=(-1);
   }
   public void run(){
	   while(running){
		   move();
		   try{
			   sleep(120);
			   
		   }catch(InterruptedException ie){
			   System.err.println("Thread interrupted");
		   }
	   }   
   }
   public static int getLocala(Qiu qiu){
		return qiu.x+25;
	}
   
   public static int getLocalb(Qiu qiu){
		return qiu.y+25;
	}
   public static void setLocala(Qiu qiu){
		 qiu.x=-50;
	}
  
  public static void setLocalb(Qiu qiu){
		qiu.y=-50;
	}
   public void draw1(Graphics g){
	   g.drawImage(bird,x,y,50,50,cage);
   
   }
   public void draw2(Graphics g){
	   g.drawImage(hudie,x,y,50,50,cage);
   
   }
   
}

