package bird;

import java.awt.Image;

import javax.swing.ImageIcon;

public interface Pao {
	ImageIcon iconhudie=new ImageIcon("image/hudie.png");
	ImageIcon iconbird=new ImageIcon("image/bird.png");
	ImageIcon iconflower=new ImageIcon("image/flower.jpg");
	ImageIcon iconbackground1=new ImageIcon("image/background1.jpg");
	ImageIcon iconpao=new ImageIcon("image/pao.png");
	ImageIcon iconzidan=new ImageIcon("image/zidan.png");
	
	
	Image zidan = iconpao.getImage();
	Image pao = iconpao.getImage();
	Image bird = iconhudie.getImage();
	Image hudie = iconhudie.getImage();
	Image flower = iconhudie.getImage();
	Image background1 = iconbackground1.getImage();

	

}
