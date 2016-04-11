package bird;

import java.util.*;

public class DaZhong extends Thread{
	static int MingZhongSum=0;
	static boolean po=false;
	static int localx;
	static int localy;
	static boolean gameover=true;
	static boolean start=false;
	static Set<Qiu> set=new TreeSet<Qiu>();
	static List<Qiu> setall=new ArrayList<Qiu>();
	static Set<Qiu> setrest=new TreeSet<Qiu>();
	public void jiance(){
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		if(PanelListenerLeft_Right.sum>0){
			System.out.println("ok1");
			System.out.println("ZiDanX"+ZiDan.getLocalx(Cage.zidan[0]));
			System.out.println("ZiDanY"+ZiDan.getLocaly(Cage.zidan[0]));
			System.out.println("Qiux"+Qiu.getLocala(Cage.qiu[0]));
			System.out.println("Qiuy"+Qiu.getLocalb(Cage.qiu[0]));
			if(ZiDan.getLocalx(Cage.zidan[0])<Qiu.getLocala(Cage.qiu[0])+50&&ZiDan.getLocalx(Cage.zidan[0])>Qiu.getLocala(Cage.qiu[0])-50){
				if(ZiDan.getLocaly(Cage.zidan[0])<Qiu.getLocalb(Cage.qiu[0])+50&&ZiDan.getLocaly(Cage.zidan[0])>Qiu.getLocalb(Cage.qiu[0])-50){
					System.out.println("打中");				
					po=true;
					Qiu.setLocala(Cage.qiu[0]);
					Qiu.setLocalb(Cage.qiu[0]);
					ZiDan.setLocala(Cage.zidan[0]);
					ZiDan.setLocalb(Cage.zidan[0]);
					Cage.qiu[0].stop();
					Cage.zidan[0].stop();
				}
			}
		
	}
	*/
		while(start){
		
		if(PanelListenerLeft_Right.sum>-1){
			PanelListenerLeft_Right.sum=PanelListenerLeft_Right.getSum();
			System.out.println("ZiDanX:"+ZiDan.getLocalx(Cage.zidan[PanelListenerLeft_Right.sum]));
			System.out.println("ZiDanY:"+ZiDan.getLocaly(Cage.zidan[PanelListenerLeft_Right.sum]));
			for(int i=0;i<Cage.qiu_sum;i++){
				setall.add(Cage.qiu[i]);
				}
			//System.out.println("ok1");
			
	//		System.out.println("Qiux"+Qiu.getLocala(Cage.qiu[0]));
	//		System.out.println("Qiuy"+Qiu.getLocalb(Cage.qiu[0]));
			Iterator<Qiu> it=setall.iterator();
			int rest=0;
			Qiu qiurest[]=new Qiu[setall.size()];
			while(it.hasNext()){
				 qiurest[rest++]=it.next();
			}
			if(setall.size()==0){
				gameover=false;
			}
			System.out.println(setall);
			for(int j=0;j<qiurest.length;j++){
			//if(ZiDan.getLocalx(Cage.zidan[PanelListenerLeft_Right.sum])<Qiu.getLocala(qiurest[j])+25&&ZiDan.getLocalx(Cage.zidan[PanelListenerLeft_Right.sum])>Qiu.getLocala(qiurest[j])-25){
			//	if(ZiDan.getLocaly(Cage.zidan[PanelListenerLeft_Right.sum])<Qiu.getLocalb(qiurest[j])+25&&ZiDan.getLocaly(Cage.zidan[PanelListenerLeft_Right.sum])>Qiu.getLocalb(qiurest[j])-25){
				if	(Math.hypot((ZiDan.getLocalx(Cage.zidan[PanelListenerLeft_Right.sum])-Qiu.getLocala(qiurest[j])), ZiDan.getLocaly(Cage.zidan[PanelListenerLeft_Right.sum])-Qiu.getLocalb(qiurest[j]))<25){
					
					System.out.println("打中");
					++MingZhongSum;
					Cage.drawLabel2();
					//set.add(Cage.qiu[j]);
					setall.remove(qiurest[j]);
					po=true;
					Qiu.setLocala(qiurest[j]);
					Qiu.setLocalb(qiurest[j]);
					ZiDan.setLocala(Cage.zidan[PanelListenerLeft_Right.sum]);
					ZiDan.setLocalb(Cage.zidan[PanelListenerLeft_Right.sum]);
				//	Cage.zidan[PanelListenerLeft_Right.sum].stop();
				//	qiurest[j].stop();
				}
			}
			}
		}
	}	
		
/*
		if(PanelListenerLeft_Right.sum>0){
		for(int i=0;i<PanelListenerLeft_Right.sum;i++){
			{
				if (Cage.zidan[i]!=null)
					for(int j=0;j<Cage.qiu_sum;j++){
						if(Cage.qiu[j]!=null){
							
							System.out.println("ZiDanX"+ZiDan.getLocalx(Cage.zidan[i]));
							System.out.println("ZiDanY"+ZiDan.getLocaly(Cage.zidan[i]));
							System.out.println("Qiux"+Qiu.getLocala(Cage.qiu[j]));
							System.out.println("Qiuy"+Qiu.getLocalb(Cage.qiu[j]));
							if(ZiDan.getLocalx(Cage.zidan[i])<Qiu.getLocala(Cage.qiu[j])+25&&ZiDan.getLocalx(Cage.zidan[i])>Qiu.getLocala(Cage.qiu[j])-25){
								if(ZiDan.getLocaly(Cage.zidan[i])<Qiu.getLocalb(Cage.qiu[j])+25&&ZiDan.getLocaly(Cage.zidan[i])>Qiu.getLocalb(Cage.qiu[j])-25){
									System.out.println("打中");
									++MingZhongSum;
									Cage.drawLabel2();
									try {
										Thread.sleep(10);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									Qiu.setLocala(Cage.qiu[i]);
									Qiu.setLocalb(Cage.qiu[i]);
									ZiDan.setLocala(Cage.zidan[j]);
									ZiDan.setLocalb(Cage.zidan[j]);
									try {
										Thread.sleep(10);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									
									Cage.qiu[i].stop();
									Cage.zidan[j].stop();
									try {
										Thread.sleep(10);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									
									//Cage.qiu[i]=null;
									//Cage.zidan[j]=null;
								}
							
						}
						
							
								
						}
						else 
							continue;
						
					}
				else continue;
			}

	}
		}
	}
	*/
	public void run(){
	
		
		while(gameover){
		//	System.out.println("ok2");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			jiance();
		}
		
	}
}
