package bird;

import java.awt.Button;
import java.awt.Image;
import javax.swing.*;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;
import java.awt.Event.*;

public class Cage extends JFrame implements ActionListener,Pao{
	JPanel backgroundpanel;
	private JButton start=new JButton("开始");
	private JButton quit=new JButton("暂停");
	private JButton over=new JButton("结束");
	JLabel lb1=new JLabel("子弹总数:");
	JLabel lb2=new JLabel("子弹剩余:");
	JLabel lb3=new JLabel();
	static JLabel lb4=new JLabel();
	JLabel lb5=new JLabel("命中次数:");
	static JLabel lb6=new JLabel();
	static int clicknumber=0;
	

	JMenuBar mb=new JMenuBar();
	JMenu m1=new JMenu("文件");
	JMenu m2=new JMenu("编辑");
	JMenu m3=new JMenu("模式");
	JMenu m4=new JMenu("帮助");
	JMenuItem mi1=new JMenuItem("检查更新");
	JMenuItem mi2=new JMenuItem("设置");
	JMenuItem mi3=new JMenuItem("关闭程序");
	JMenuItem mi4=new JMenuItem("导入mod");
	JMenuItem mi5=new JMenuItem("删除mod");
	JMenuItem mi6=new JMenuItem("普通模式");
	JMenuItem mi7=new JMenuItem("困难模式");
	JMenuItem mi8=new JMenuItem("游戏玩法");
	JMenuItem mi9=new JMenuItem("详细信息");

	
	static int qiu_sum=8;
	static int zidan_sum=20;
	static Qiu qiu[]=new Qiu[qiu_sum];
	static ZiDan zidan[]=new ZiDan[zidan_sum];
	
//	Image bird=Toolkit.getDefaultToolkit().getImage("image/bird.jpg");

	public Cage(){
		
		
		super("打动物小游戏");
		setSize(815,665);
			
		mb.add(m1);
		mb.add(m2);
		mb.add(m3);
		mb.add(m4);
		m1.add(mi1);
		m1.add(mi2);
		m1.add(mi3);
		m2.add(mi4);
		m2.add(mi5);
		m3.add(mi6);
		m3.add(mi7);
		m4.add(mi8);
		m4.add(mi9);
		add("North",mb);
				
		backgroundpanel=new JPanel(){
			public void paintComponent(Graphics g){
				g.drawImage(background1, 0, 0, null);
				super.paintComponent(g);
				g.drawImage(pao, PaoMove.paox, PaoMove.paoy, 20, 36, this);
				g.drawRect(0, 0, this.getWidth()-200, this.getHeight()-100);
				for(int i=0;i<qiu.length;i++)//画球的运动
					if(qiu[i]!=null){
						qiu[i].draw1(g);
						qiu[++i].draw2(g);
					}
				for(int i=0;i<zidan.length;i++){//画子弹的运动
					if(zidan[i]!=null){
						zidan[i].draw3(g);
					}
				}
				if(DaZhong.po=true){
				}
			}
		};
		
		UpdateThread up=new UpdateThread(backgroundpanel);
		up.start();
		
		PaoMove pm=new PaoMove();
		pm.start();
		
		DaZhong da=new DaZhong();
		da.start();
		
		backgroundpanel.setLayout(null);
		backgroundpanel.setOpaque(false);
		
		start.setBounds(600, 0, 60, 30);
		quit.setBounds(665, 0, 60, 30);
		over.setBounds(730, 0, 60, 30);
		lb1.setBounds(620, 35, 100, 30);
		lb2.setBounds(620, 70, 100, 30);
		lb3.setBounds(720, 35, 60, 30);
		lb4.setBounds(720, 70, 60, 30);
		lb5.setBounds(620, 105, 100, 30);
		lb6.setBounds(720, 105, 60, 30);
		
		lb3.setText(String.valueOf(zidan_sum));
		lb4.setText(String.valueOf(zidan_sum));
		lb6.setText(String.valueOf(DaZhong.MingZhongSum));
		
		

		backgroundpanel.add(start);
		backgroundpanel.add(quit);
		backgroundpanel.add(over);
		backgroundpanel.add(lb1);
		backgroundpanel.add(lb2);
		backgroundpanel.add(lb3);
		backgroundpanel.add(lb4);
		backgroundpanel.add(lb5);
		backgroundpanel.add(lb6);
		add("Center",backgroundpanel);
		
		
		quit.addActionListener(this);	
		start.addActionListener(this);
		over.addActionListener(this);
		
		PanelListenerLeft_Right pl=new PanelListenerLeft_Right();
		this.addKeyListener(pl);

		
		
//		System.out.println(this.getSize().width);
//		System.out.println(this.getSize().height);
//		System.out.println((int)((this.getSize().width)*Math.random()));
//		System.out.println((int)((this.getSize().height)*Math.random()));
//		

}
	public void setLocation(){
		for(int i=0;i<qiu.length;i++){
			int x=(int)((this.getSize().width-250)*Math.random());
			int y=(int)((this.getSize().height-150)*Math.random());
			qiu[i]=new Qiu(this,x,y);
		}
		
		
	}
	public void actionPerformed(ActionEvent ae){
		
		
		if(ae.getSource()==start){
			qiu_sum=8;
			zidan_sum=20;
			DaZhong.MingZhongSum=0;
			qiu=new Qiu[qiu_sum];
			zidan=new ZiDan[zidan_sum];
			setLocation();
			quit.setText("暂停");
			clicknumber=0;
			lb3.setText(String.valueOf(zidan_sum));
			lb4.setText(String.valueOf(zidan_sum));
			lb6.setText(String.valueOf(DaZhong.MingZhongSum));
			
		//	start.setText("重来一局");
			/*
			for(int i=0;i<qiu.length;i++){
				qiu[i].halt();
				qiu[i]=new Qiu(this,qiu[i].x,qiu[i].y);				
			}
			*/
			this.requestFocus();
		}
		if(ae.getSource()==quit){
			clicknumber++;
			if(clicknumber%2==0){
				quit.setText("暂停");
				for(int i=0;i<qiu.length;i++){
					qiu[i]=new Qiu(this,qiu[i].x,qiu[i].y);	
				}
			
			}
			else{
				 quit.setText("继续");
				for(int i=0;i<qiu.length;i++){
					qiu[i].halt();
				}
			}
			this.requestFocus();
		}
		
		if(ae.getSource()==over){
			quit.setText("暂停");
			clicknumber=0;
			for(int i=0;i<qiu.length;i++){
				qiu[i].halt();
				qiu[i]=new Qiu(this,qiu[i].x=-50,qiu[i].y=-50);
				
			}
		    this.requestFocus();
		}
				
	}

	public static void drawLabel(){
		lb4.setText(String.valueOf(zidan_sum-PanelListenerLeft_Right.getSum()));
	}
	public static void drawLabel2(){
		lb6.setText(String.valueOf(DaZhong.MingZhongSum));
	}
	
	public static void main(String [] arg){
		Cage table=new Cage();
		table.setVisible(true);
		table.setLocationRelativeTo(null);
		table.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}




			
}
