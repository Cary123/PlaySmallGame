package bird;

import java.awt.event.*;

import javax.swing.*;

class PanelListenerLeft_Right extends KeyAdapter{ 
	static int sum=0;
	Cage cage;
	public static int getSum(){
		return sum;
	}
	public static void setSum(int su){
		sum=su;
	}

    //当按键按下  
    public void keyPressed(KeyEvent e){  
    	
        int code = e.getKeyCode();  
        switch (code) {  
//        case KeyEvent.VK_UP:  
//            Player.up = true;  
//            break;  
//        case KeyEvent.VK_DOWN:  
//            Player.down = true;  
//            break;  
        case KeyEvent.VK_LEFT:  
            PaoMove.left = true;
            //Cage.zidan[1].stop();
            
            break;  
        case KeyEvent.VK_RIGHT:  
            PaoMove.right= true;  
            break;  

        case KeyEvent.VK_SPACE:
        //	if(sum<=Cage.zidan_sum){
        	if(sum==0){
        		DaZhong.start=true;
        		ZiDan.flag=true;
            	Cage.zidan[sum]=new ZiDan();
            	Cage.zidan[sum].setOver(false);        	
            	Cage.drawLabel();
            	System.out.println(sum);
        	}
        	else{
        	DaZhong.start=true;
        	sum++;
            if(Cage.zidan[sum-1].getOver()==true){
        	ZiDan.flag=true;
        	Cage.zidan[sum]=new ZiDan();
        	Cage.zidan[sum].setOver(false);
        	sum++;
        	Cage.drawLabel();
        	System.out.println(sum);
            }
        	}
        	
        	
        	//Cage.qiu[0].stop();
        	//Cage.qiu[1].stop();
        	
        	
//        	}
//        	else
//        		JOptionPane.showMessageDialog(cage, "子弹不足");
        	break;
        	
        default:  
            break;  
        }  
    }  
    //当按键释放  
    public void keyReleased(KeyEvent e){  
        int code = e.getKeyCode();  
        switch (code) {                   
//        case KeyEvent.VK_UP:  
//            Player.up = false;  
//            break;  
//        case KeyEvent.VK_DOWN:  
//            Player.down = false;  
//            break;  
        case KeyEvent.VK_LEFT:  
            PaoMove.left = false;  
            break;  
        case KeyEvent.VK_RIGHT:  
            PaoMove.right = false;  
            break;  

        default:  
            break;  
        }  
    }  
} 