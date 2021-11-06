package mainn;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;



public class mainn extends JPanel {
	static int width;
	
static int  xCord=0,yCord=0;
	 static int karex_uzunluk;
    static int karey_uzunluk;
	 static oyuncu1 oyuncu_1=new oyuncu1();
   static oyuncu2 oyuncu_2=new oyuncu2();
    static oyuncu3 oyuncu_3=new oyuncu3();
    static oyuncu4 oyuncu_4=new oyuncu4();
   // static int karepozitif=50;
   // static int karenegatif=-50;
    static boolean karetutucu=true;
	static JFrame frame = new JFrame();
	public static JPanel panel=new JPanel();
	public static boolean [][] dizi;
	public static boolean [][] gizlidizi;
	//static main m=new main();
	
	protected  void paintComponent(Graphics g)
	{
		super.paintComponent(g); 
		// repaint();
		//System.out.println("helloe");
		
		//super.paintComponents(g);
	     for(int i=0;i<width;i++)
	    	 for(int j=0;j<width;j++)
	    	 {
	    		 
	
				if(dizi[i][j]==true)
				{
					
					g.setColor(Color.yellow);
					g.fillRect((karex_uzunluk)*j, (karey_uzunluk)*i,karex_uzunluk,karey_uzunluk);
					
				}
				else if(gizlidizi[i][j]==true)
				{
					
					g.setColor(Color.GRAY);
					g.fillRect((karex_uzunluk)*j, (karey_uzunluk)*i,karex_uzunluk,karey_uzunluk);
					
				}
				//g.drawLine(xCord,yCord,xCord+50,yCord);
	           	//g.drawLine(xCord, yCord+(j-1)*50, xCord, yCord+j*50);
	    			 
	}
	     
	    		 
	     
	       g.setColor(Color.RED);
	    
	       g.fillRect(oyuncu_1.getkonum_x(),oyuncu_1.getkonum_y(), karex_uzunluk, karey_uzunluk);
	     

	      // System.out.println("oyuncu konum:"+oyuncu_1.getkonum_x()+","+oyuncu_1.getkonum_y());
	       g.setColor(Color.GREEN);
	       g.fillRect(oyuncu_2.getkonum_x(),oyuncu_2.getkonum_y(), karex_uzunluk, karey_uzunluk);
	       //System.out.println("oyuncu konum:"+oyuncu_2.getkonum_x()+","+oyuncu_2.getkynum_y());
	      // oyuncu_1.setkonum(0,0);
	       //oyuncu_1.setkonum(0,0);
	       g.setColor(Color.BLACK);
	       g.fillRect(oyuncu_3.getkonum_x(),oyuncu_3.getkonum_y() ,karex_uzunluk,karey_uzunluk);
              
              g.setColor(Color.BLUE);
	       g.fillRect(oyuncu_4.getkonum_x(),oyuncu_4.getkonum_y() ,karex_uzunluk,karey_uzunluk);
	       xCord=0;
	       yCord=0;
	       while ((yCord) < 1000) {
	           
	           int sut=0;
	           
	            if ((xCord + karex_uzunluk) > 1000) {
	                xCord = 0;
	               
	                yCord += karey_uzunluk;
	              
	            }
	            
	            else {
	              
	            	sut++;
	            	g.drawLine(xCord,yCord,xCord+karex_uzunluk,yCord);
	            	g.drawLine(xCord, yCord+(sut-1)*karey_uzunluk, xCord, yCord+sut*karey_uzunluk);
	            	xCord += karex_uzunluk;
	              
	            }
	            
	       }
	       
	      // g.setColor(Color.BLUE);
	       //g.fillRect(karex_uzunluk*(width-1),karey_uzunluk*0,50, 50); 
	       
	} 
	
	public static void main(String[]args) throws IOException  {
		// TODO Auto-generated method stub
		 Scanner sc=new Scanner(System.in);
			System.out.println("Satir ve sütun giriniz:");
			width=sc.nextInt();
                       
                       int altinorani;
                       int gizlialtinorani;
                       int adim;
                       int hamle;
                       int hedefbelirleme1,hedefbelirleme3;
                       int hedefbelirleme2,hedefbelirleme4;
                       int altinmiktari;
                       int toplamaltinmiktari = -1;
                       int toplamadımsayisi1=0,toplamadımsayisi2=0;
                       int toplamadımsayisi3=0,toplamadımsayisi4=0;
                       
                       int harcananaltinmiktari1=0,harcananaltinmiktari2=0;
                       int harcananaltinmiktari3=0,harcananaltinmiktari4=0;
                       
                       int toplananaltinmiktari1=0,toplananaltinmiktari2=0;
                       int toplananaltinmiktari3=0,toplananaltinmiktari4=0;
                       
                       System.out.println("Her bir oyuncunun baslangıc altın miktarını yazınız:");
                       altinmiktari=sc.nextInt();
                       
                       System.out.println("Yüzde kaci altın olsun?");
                       altinorani=sc.nextInt();
                       
                       System.out.println("Altinin yuzde kaci gizli altin olsun ?");
                       gizlialtinorani=sc.nextInt();
                         
                      System.out.println("Adim sayisi giriniz:");
                       adim=sc.nextInt();  
                       
                       System.out.println("Hamle maliyeti giriniz:");
                       hamle=sc.nextInt();
                             
                       
                       System.out.println("1.oyuncunun hedef belirleme maliyeti giriniz:");
                       hedefbelirleme1=sc.nextInt();
                       
                       System.out.println("2.oyuncunun hedef belirleme maliyeti giriniz:");
                       hedefbelirleme2=sc.nextInt();

                        System.out.println("3.oyuncunun hedef belirleme giriniz:");
                       hedefbelirleme3=sc.nextInt();
                       
                        System.out.println("4.oyuncunun hedef belirleme giriniz:");
                       hedefbelirleme4=sc.nextInt();
                       
                       
                       
                       
			oyuncu_1.hamlemaliyeti=hamle;
                        oyuncu_2.hamlemaliyeti=hamle;                       
                        oyuncu_3.hamlemaliyeti=hamle;
                        oyuncu_4.hamlemaliyeti=hamle;
                       
                        oyuncu_1.altinmiktari=altinmiktari;
                        oyuncu_2.altinmiktari=altinmiktari;
                        oyuncu_3.altinmiktari=altinmiktari;
                        oyuncu_4.altinmiktari=altinmiktari;
                        
                        oyuncu_1.hedefbelirlememaliyeti=hedefbelirleme1;
                        oyuncu_2.hedefbelirlememaliyeti=hedefbelirleme2;                       
                        oyuncu_3.hedefbelirlememaliyeti=hedefbelirleme3;
                        oyuncu_4.hedefbelirlememaliyeti=hedefbelirleme4;
                       
                       
		        //JFrame frame = new JFrame();
		      
		      
		        
			 mainn m=new mainn();
	    	  //frame.setExtendedState(JFrame.NORMAL);
	    	  frame.setLocation(0, 0);
	         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        frame.setSize(1020,1050);
		       JPanel panel=new JPanel();
		       
		       panel.setSize(1000,1000);
                      karex_uzunluk=panel.getWidth()/width;
                      karey_uzunluk=panel.getHeight()/width;
                      
                      dizi=new boolean[width][width];
                      gizlidizi=new boolean[width][width];
		       panel.setLocation(0,0);
		       panel.add(m);
		       m.revalidate();
		       
				// frame.add(m);
		        
				
		      
		        
		       
		        frame.setVisible(true);
		        frame.add(m);
		        oyuncu_1.setkonum(0, 0);
                       oyuncu_1.setsatir_sutun(0,0);
		        oyuncu_2.setkonum((width-1)*karex_uzunluk,0);
		        oyuncu_2.setsatir_sutun(0,width-1);
		        oyuncu_3.setkonum(0,(width-1)*karey_uzunluk);
		        oyuncu_3.setsatir_sutun(width-1,0);
		        oyuncu_4.setkonum((width-1)*karex_uzunluk,(width-1)*karey_uzunluk);
		        oyuncu_4.setsatir_sutun(width-1,width-1);   
			
	
       
	 
        
		
        ArrayList<Integer> arrlist=new ArrayList<Integer>();
        
        Random rand=new Random();               
        boolean hatali=false;
        int x;
        float p=(float)(width*width)/100*altinorani;
        float c=((width*width)/100*altinorani)*gizlialtinorani/100;
        while(arrlist.size()<p)
        {
        	x=rand.nextInt(width*width);
        	if(x==0 || x==width-1 || x==width*(width-1)|| x== width*width-1)
         {
             hatali=true;

         }
           for(int i=0;i<arrlist.size();i++)
           {
        	   if(arrlist.get(i)==x)
        	   {
        		   hatali=true;
        	   }
               if(x==0 || x==width-1 || x==width*(width-1)|| x== width*width-1)
               {
                   hatali=true;

               }
        	   
           }
        	if(hatali==false)
        		arrlist.add(x);
        	 hatali=false;
        }
        //System.out.println(arrlist.get(20));
        
        
        Altin altin1[]=new Altin[((width*width)/100*altinorani)];
        ArrayList<Altin>arr_altin=new ArrayList<Altin>();
        ArrayList<Altin>arr_yardimcialtin=new ArrayList<Altin>();
        
        for(int i=0;i<width;i++)
     	   for(int j=0;j<width;j++)
     	   {
     		   dizi[i][j]=false;
     	   }
        m.repaint();
     
        for(int i=0;i<width;i++)
       	   for(int j=0;j<width;j++)
       	   {
       		   gizlidizi[i][j]=false;
       	   }
   	   
        for(int a=0;a<p-c;a++)
        { 
     	 
       	 altin1[a]=new Altin();
        	int sutun=arrlist.get(a)% width;
        	int satir=(arrlist.get(a)-sutun)/width;
        	dizi[satir][sutun]=true;
        	
        	altin1[a].setAltin_satirsutun(satir, sutun);
        	int konum_x=karex_uzunluk*sutun;
   	    int konum_y=karey_uzunluk*satir;
   	    altin1[a].setAltinkonumhesapla(konum_x,konum_y);
   	    altin1[a].setAltinmiktari();
        	arr_altin.add(altin1[a]);
                arr_yardimcialtin.add(altin1[a]);
        	
           
        	
        
        }
  
     m.repaint();
     panel.setVisible(true);
     //System.out.println(c);
        ArrayList<Altin> arr_gizlialtin=new ArrayList<Altin>();
        Altin gizlialtin[]=new Altin[((width*width)/100*altinorani)];
        for(int a=(int)(p-c);a<arrlist.size();a++)
        {
     	   
     	   altin1[a]=new Altin();
            	int sutun=arrlist.get(a)% width;
            	int satir=(arrlist.get(a)-sutun)/width;
            	gizlidizi[satir][sutun]=true;
            	altin1[a].setAltin_satirsutun(satir, sutun);
            	int konum_x=karex_uzunluk*sutun;
       	    int konum_y=karey_uzunluk*satir;
       	 
       	 
       	 altin1[a].setAltinkonumhesapla(konum_x,konum_y);
       	 altin1[a].setAltinmiktari();
            	arr_gizlialtin.add(altin1[a]);
               
         	
         	
        }
        
        m.repaint();
	
        boolean hedefbelirle=true;
        boolean hedefbelirle2=true;
        boolean hedefbelirle3=true;
        boolean hedefbelirle4=true;
        int tutus=0;
        int alper=0;
        int index=0;
        int index5=-1,index6=0;
        int index4=0;
        int index3=0;
        int index7 = 0;
        int index10 = -1;
        int index11 =-1;
        int index12=-1;
        int gizliindex=0;
        int index2 = 0;
        int [] hedefaltin=new int[arr_altin.size()+arr_gizlialtin.size()];
        hedefaltin[0]=  (int) Math.pow(1000,2)*2;
        hedefaltin[1]=  (int) Math.pow(1000,2)*2;
        int altintoplami=1; 
       File oyuncu1 = new File("oyuncu1.txt");
       File oyuncu2 = new File("oyuncu2.txt");
       File oyuncu3 = new File("oyuncu3.txt");
       File oyuncu4 = new File("oyuncu4.txt");
       File oyuncularr = new File("oyuncularr.txt");
       
       BufferedWriter br1 = new BufferedWriter(new FileWriter(oyuncu1));
       BufferedWriter br2 = new BufferedWriter(new FileWriter(oyuncu2));
       BufferedWriter br3 = new BufferedWriter(new FileWriter(oyuncu3));
       BufferedWriter br4 = new BufferedWriter(new FileWriter(oyuncu4));
       BufferedWriter oyuncular = new BufferedWriter(new FileWriter(oyuncularr));
       while(altintoplami!=0)
       {
                 
     try
    {
    br1.write("("+oyuncu_1.getsutun()+","+oyuncu_1.getsatir()+")");
    br1.newLine();
    br1.flush();
    } 
     catch (IOException e) {
    System.out.println("Dosya bulunamadi");
    }
           try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	   altintoplami=0;	 
      
      toplamaltinmiktari=0;
      
 
       for(int i=0;i<arr_altin.size();i++)
       {
    	   if(i<arr_altin.size())
           {
           toplamaltinmiktari+=arr_altin.get(i).getAltinmiktari();
           altintoplami+=arr_altin.get(i).getAltinmiktari();
           }
    	   
    	   if(i<arr_gizlialtin.size())
    		   altintoplami+=arr_gizlialtin.get(i).getAltinmiktari();
       }
      
      
      
      
      
      
      
      if(oyuncu_1.altinmiktari>0 && toplamaltinmiktari!=0)
   {   
      if(hedefbelirle==true)
       {
        for(int i=0;i<arr_altin.size();i++)
        {
        	int uzaklik=(int) ((int) Math.pow(((oyuncu_1.getkonum_x())-arr_altin.get(i).getAltinkonumhesapla_x()),2)+Math.pow(((oyuncu_1.getkonum_y())-arr_altin.get(i).getAltinkonumhesapla_y()),2));
            if(uzaklik<hedefaltin[0] && ((oyuncu_1.getkonum_x()-arr_altin.get(i).getAltinkonumhesapla_x())!=0 || (oyuncu_1.getkonum_y()- arr_altin.get(i).getAltinkonumhesapla_y()!=0))&&(arr_altin.get(i).getAltinmiktari()!=0)&& arr_altin.get(i).getAltinmiktari()!=0)
            {
            	hedefaltin[0]=uzaklik;
            	index=i;
            	index4=i;
            	
            }
        }
          // System.out.println("sa");
           oyuncu_1.hedefbelirleme();
           harcananaltinmiktari1+=hedefbelirleme1;
       }
       
       
       //Timer timer = new Timer();
       
      // TimerTask tasknew=new Helper();
       
       int satir1=0,sutun1=0;
       
    //  int y= Math.abs(oyuncu_1.getsatir()-(arr_altin.get(index).getAltin_satir()))+Math.abs(oyuncu_1.getsutun()-(arr_altin.get(index).getAltin_sutun()));
      
  // g.setColor(Color.RED);
  
     for(int j=0;j<adim;j++)
     {
         try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
         
         if(arr_altin.get(index).getAltinmiktari()==0)
         {
         
         for(int i=0;i<arr_altin.size();i++)
        {
        	int uzaklik=(int) ((int) Math.pow(((oyuncu_1.getkonum_x())-arr_altin.get(i).getAltinkonumhesapla_x()),2)+Math.pow(((oyuncu_1.getkonum_y())-arr_altin.get(i).getAltinkonumhesapla_y()),2));
            if(uzaklik<hedefaltin[0] && ((oyuncu_1.getkonum_x()-arr_altin.get(i).getAltinkonumhesapla_x())!=0 || (oyuncu_1.getkonum_y()- arr_altin.get(i).getAltinkonumhesapla_y()!=0))&&(arr_altin.get(i).getAltinmiktari()!=0)&& arr_altin.get(i).getAltinmiktari()!=0 && i!=index)
            {
            	hedefaltin[0]=uzaklik;
            	index=i;
            	index4=i;
            	
            }
            
        }
         oyuncu_1.hedefbelirleme();
           harcananaltinmiktari1+=hedefbelirleme1;
         }
         
    	 //g.setColor(getBackground());
    	if(oyuncu_1.getsatir()-arr_altin.get(index).getAltin_satir()<0)
     	    {       
    			   satir1++;
    			
    			oyuncu_1.setsatir_sutun(1,0);
     		       oyuncu_1.setkonum(0,karey_uzunluk);
     		       
     		       m.repaint();
     		     
     		
     		     
       	}
       	else if(oyuncu_1.getsatir()-arr_altin.get(index).getAltin_satir()>0)
       	{   
       		satir1--;
       		
            oyuncu_1.setsatir_sutun(-1,0);
       		oyuncu_1.setkonum(0,-karey_uzunluk);
       		m.repaint();
       	
       	
       	}
               else if(oyuncu_1.getsutun()-arr_altin.get(index).getAltin_sutun()<0)
       	{      
            	   sutun1++;
            	
            oyuncu_1.setsatir_sutun(0,1);
       		oyuncu_1.setkonum(karex_uzunluk, 0);
       		m.repaint();
       		
       	}
       	else if(oyuncu_1.getsutun()-arr_altin.get(index).getAltin_sutun()>0)
       	{
       		sutun1--;
       	
            oyuncu_1.setsatir_sutun(0,-1);
       		oyuncu_1.setkonum(-karex_uzunluk, 0);
       		m.repaint();
       	
       	}
               
    	//	m.repaint();
    		for(int k=0;k<c;k++)
            {
                if(oyuncu_1.getkonum_x()==arr_gizlialtin.get(k).getAltinkonumhesapla_x() && oyuncu_1.getkonum_y()==arr_gizlialtin.get(k).getAltinkonumhesapla_y() && arr_gizlialtin.get(k).getAltinmiktari()!=0)
                {
                    gizlidizi[arr_gizlialtin.get(k).getAltin_satir()][arr_gizlialtin.get(k).getAltin_sutun()]=false;
                    dizi[arr_gizlialtin.get(k).getAltin_satir()][arr_gizlialtin.get(k).getAltin_sutun()]=true;
                    arr_altin.add(arr_gizlialtin.get(k));
                    arr_yardimcialtin.add(arr_gizlialtin.get(k));
                    arr_gizlialtin.remove(k);
                    c=c-1;


                }
            }
    		toplamadımsayisi1++;
               
       if((oyuncu_1.getkonum_x()==arr_altin.get(index).getAltinkonumhesapla_x() && oyuncu_1.getkonum_y()==arr_altin.get(index).getAltinkonumhesapla_y()))
       {
           toplananaltinmiktari1+=arr_altin.get(index).getAltinmiktari();
           oyuncu_1.altinmiktari+=arr_altin.get(index).getAltinmiktari();
    	   arr_altin.get(index).altinsifirla();
    	  dizi[arr_altin.get(index).getAltin_satir()][arr_altin.get(index).getAltin_sutun()]=false;
         hedefbelirle=true;
          if(arr_yardimcialtin.size()>=1)
              arr_yardimcialtin.remove(arr_yardimcialtin.size()-1);

    	   break;
    	  
    	 
       } 
       hedefbelirle=false;
       
     
     }
     oyuncu_1.hamle();
     harcananaltinmiktari1+=hamle;
     
    // int [] hedefaltin=new int[arr_altin.size()+arr_gizlialtin.size()];
   }
     
       // hedefaltin[0]=(int) ((int) Math.pow(((oyuncu_1.getkonum_x())-arr_altin.get(0).getAltinkonumhesapla_x()),2)+Math.pow(((oyuncu_1.getkonum_y())-arr_altin.get(0).getAltinkonumhesapla_y()),2));
        hedefaltin[0]=  (int) Math.pow(1000,2)*2;
        hedefaltin[1]=  (int) Math.pow(1000,2)*2;
        
          try
    {
    br2.write("("+oyuncu_2.getsutun()+","+oyuncu_2.getsatir()+")");
    br2.newLine();
    br2.flush();
    } 
     catch (IOException e) {
    System.out.println("Dosya bulunamadi");
    }
      
          
       try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
     
     toplamaltinmiktari=0;
     
        //alper++; 
       for(int i=0;i<arr_altin.size();i++)
       {
    	   if(i<arr_altin.size())
           {
           toplamaltinmiktari+=arr_altin.get(i).getAltinmiktari();
           altintoplami+=arr_altin.get(i).getAltinmiktari();
           }
    	   
    	   if(i<arr_gizlialtin.size())
    		   altintoplami+=arr_gizlialtin.get(i).getAltinmiktari();
       }
    
  
      

       
       
       
     if(oyuncu_2.altinmiktari>0 && toplamaltinmiktari!=0)
      {   
       int adimsayisi;
       
       int karlialtin=arr_altin.get(0).getAltinmiktari()-(5*(((2*width-2)-1/3)+1));
       
      
       for(int i=0;i<arr_altin.size();i++)
       {
           adimsayisi=Math.abs(oyuncu_2.getsatir()-(arr_altin.get(i).getAltin_satir()))+(int)Math.abs(oyuncu_2.getsutun()-(arr_altin.get(i).getAltin_sutun()));
           int enkarlialtin=arr_altin.get(i).getAltinmiktari()-(5*(adimsayisi-1/3)+1); 
           if(enkarlialtin>karlialtin && ((oyuncu_2.getkonum_x()-arr_altin.get(i).getAltinkonumhesapla_x())!=0 || (oyuncu_2.getkonum_y()- arr_altin.get(i).getAltinkonumhesapla_y()!=0))&&(arr_altin.get(i).getAltinmiktari()!=0))
           {
           	karlialtin=enkarlialtin;
           	index2=i;
               
           }
       }
       
       if(index2!=index5)
       {
       harcananaltinmiktari2+=hedefbelirleme2;
       oyuncu_2.hedefbelirleme();
       }
       
       index5=index2;
         //System.out.println("En yakin altin: "+arr_altin.get(index2).getAltinkonumhesapla_x()+","+arr_altin.get(index2).getAltinkonumhesapla_y());
 
       
      // int z=Math.abs(oyuncu_2.getsatir()-(arr_altin.get(index2).getAltin_satir()))+Math.abs(oyuncu_2.getsutun()-(arr_altin.get(index2).getAltin_sutun()));
     
       for(int i=0;i<adim;i++)
       {
           try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
           
        if(arr_altin.get(index2).getAltinmiktari()==0)
        {
        
          for(int k=0;k<arr_altin.size();k++)
          {
           adimsayisi=Math.abs(oyuncu_2.getsatir()-(arr_altin.get(k).getAltin_satir()))+(int)Math.abs(oyuncu_2.getsutun()-(arr_altin.get(k).getAltin_sutun()));
           int enkarlialtin=arr_altin.get(k).getAltinmiktari()-(5*(adimsayisi-1/3)+1); 
           if(enkarlialtin>karlialtin && ((oyuncu_2.getkonum_x()-arr_altin.get(k).getAltinkonumhesapla_x())!=0 || (oyuncu_2.getkonum_y()- arr_altin.get(k).getAltinkonumhesapla_y()!=0))&&(arr_altin.get(k).getAltinmiktari()!=0) && k!=index2)
           {
           	karlialtin=enkarlialtin;
           	index2=k;
               
           }
           }
                oyuncu_2.hedefbelirleme();
                harcananaltinmiktari2+=hedefbelirleme2;
        }
       	if(oyuncu_2.getsatir()-arr_altin.get(index2).getAltin_satir()<0)
       	{
             
                       oyuncu_2.setsatir_sutun(1,0);
       		oyuncu_2.setkonum(0, karey_uzunluk);
       		m.repaint();
       	}
       	else if(oyuncu_2.getsatir()-arr_altin.get(index2).getAltin_satir()>0)
       	{
           
                       oyuncu_2.setsatir_sutun(-1,0);
       		oyuncu_2.setkonum(0, -karey_uzunluk);
       		m.repaint();
       	}
       	else if(oyuncu_2.getsutun()-arr_altin.get(index2).getAltin_sutun()<0)
       	{
          
                       oyuncu_2.setsatir_sutun(0,1);
       		oyuncu_2.setkonum(karex_uzunluk, 0);
       		m.repaint();
       	}
       	else if(oyuncu_2.getsutun()-arr_altin.get(index2).getAltin_sutun()>0)
       	{
                  
                       oyuncu_2.setsatir_sutun(0,-1);
       		oyuncu_2.setkonum(-karex_uzunluk, 0);
       		m.repaint();
       	}
               
              
             for(int k=0;k<c;k++)
            {
                if(oyuncu_2.getkonum_x()==arr_gizlialtin.get(k).getAltinkonumhesapla_x() && oyuncu_2.getkonum_y()==arr_gizlialtin.get(k).getAltinkonumhesapla_y() && arr_gizlialtin.get(k).getAltinmiktari()!=0)
                {
                    gizlidizi[arr_gizlialtin.get(k).getAltin_satir()][arr_gizlialtin.get(k).getAltin_sutun()]=false;
                    dizi[arr_gizlialtin.get(k).getAltin_satir()][arr_gizlialtin.get(k).getAltin_sutun()]=true;
                    arr_altin.add(arr_gizlialtin.get(k));
                    arr_yardimcialtin.add(arr_gizlialtin.get(k));
                    arr_gizlialtin.remove(k);
                    c=c-1;


                }
            }
             toplamadımsayisi2++;
       //	System.out.println(oyuncu_2.getkonum_x()+" ,"+oyuncu_2.getkonum_y());
           if((oyuncu_2.getkonum_x()==arr_altin.get(index2).getAltinkonumhesapla_x() && oyuncu_2.getkonum_y()==arr_altin.get(index2).getAltinkonumhesapla_y()))
           {
                  toplananaltinmiktari2+=arr_altin.get(index2).getAltinmiktari();
           	
        	   oyuncu_2.altinmiktari+=arr_altin.get(index2).getAltinmiktari();
           	dizi[arr_altin.get(index2).getAltin_satir()][arr_altin.get(index2).getAltin_sutun()]=false;
           	arr_altin.get(index2).altinsifirla();
                if(arr_yardimcialtin.size()>=1)
                arr_yardimcialtin.remove(arr_yardimcialtin.size()-1);
                
        	   break;
                   
                 
           }
        
        
      
    
       }
       harcananaltinmiktari2+=hamle;
       oyuncu_2.hamle();
      }
        //adimsayisi=Math.abs(oyuncu_2.getsatir()-(arr_altin.get(0).getAltin_satir()))+(int)Math.abs(oyuncu_2.getsutun()-(arr_altin.get(0).getAltin_sutun()));
       
       //karlialtin=arr_altin.get(0).getAltinmiktari()-(5*((adimsayisi-1/3)+1));
       //index2 = 0;
              
        
        
 
      
        
        try {
 			TimeUnit.SECONDS.sleep(1);
 		} catch (InterruptedException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		} 
        //---------------------OYUNCU 3--------------------
        
        
        
           try
    {
    br3.write("("+oyuncu_3.getsutun()+","+oyuncu_3.getsatir()+")");
    br3.newLine();
    br3.flush();
    } 
     catch (IOException e) {
    System.out.println("Dosya bulunamadi");
    }
           altintoplami=0;
                  for(int i=0;i<arr_altin.size();i++)
       {
    	   if(i<arr_altin.size())
           {
           toplamaltinmiktari+=arr_altin.get(i).getAltinmiktari();
           altintoplami+=arr_altin.get(i).getAltinmiktari();
           }
    	   
    	   if(i<arr_gizlialtin.size())
    		   altintoplami+=arr_gizlialtin.get(i).getAltinmiktari();
       }
        boolean altintipisec=true;
        
        int tut1=0;
        int adimsayisi2 = 0;
        int sari_kontrol=0;
        int karlialtin2=arr_altin.get(0).getAltinmiktari()-(5*(((2*width-2)-1)/3+1));

        tut1=0;
       if(oyuncu_3.altinmiktari>0 && altintoplami!=0)
     {
        for(int i=0;i<arr_altin.size();i++)
        {
           adimsayisi2=Math.abs(oyuncu_3.getsatir()-(arr_altin.get(i).getAltin_satir()))+(int)Math.abs(oyuncu_3.getsutun()-(arr_altin.get(i).getAltin_sutun()));
            int enkarlialtin=arr_altin.get(i).getAltinmiktari()-(5*((adimsayisi2-1)/3+1)); 
            
            if(enkarlialtin>karlialtin2 && ((oyuncu_3.getkonum_x()-arr_altin.get(i).getAltinkonumhesapla_x())!=0 || (oyuncu_3.getkonum_y()- arr_altin.get(i).getAltinkonumhesapla_y()!=0))&&(arr_altin.get(i).getAltinmiktari()!=0) )
            {
            	karlialtin2=enkarlialtin;
            	index7=i;
                altintipisec=true;
                sari_kontrol++;
            }
        }
        
        for(int i=0;i<arr_gizlialtin.size();i++)
        {
        	adimsayisi2=Math.abs(oyuncu_3.getsatir()-(arr_gizlialtin.get(i).getAltin_satir()))+(int)Math.abs(oyuncu_3.getsutun()-(arr_gizlialtin.get(i).getAltin_sutun()));
        	int enkarlialtin=arr_gizlialtin.get(i).getAltinmiktari()-(5*((adimsayisi2-1)/3+1)); 
        	if(enkarlialtin>karlialtin2 && ((oyuncu_3.getkonum_x()-arr_gizlialtin.get(i).getAltinkonumhesapla_x())!=0 || (oyuncu_3.getkonum_y()- arr_gizlialtin.get(i).getAltinkonumhesapla_y()!=0))&&(arr_gizlialtin.get(i).getAltinmiktari()!=0))
        	{
        		karlialtin2=enkarlialtin;
        		gizliindex=i;
        		altintipisec=false;
                        tut1++;
                        
        	}
        }
        
      if(tut1!=0)
      {
          oyuncu_3.hedefbelirleme();
          harcananaltinmiktari3+=hedefbelirleme3;
      }
      else
      {
      oyuncu_3.hedefbelirleme();
          harcananaltinmiktari3+=hedefbelirleme3;
      }

        if(sari_kontrol==0)
        {
        	for(int i=0;i<arr_gizlialtin.size();i++)
            {
        		adimsayisi2=Math.abs(oyuncu_3.getsatir()-(arr_gizlialtin.get(i).getAltin_satir()))+(int)Math.abs(oyuncu_3.getsutun()-(arr_gizlialtin.get(i).getAltin_sutun()));
                int enkarlialtin=arr_gizlialtin.get(i).getAltinmiktari()-(5*((adimsayisi2-1)/3+1)); 
                
                if(enkarlialtin>karlialtin2 && ((oyuncu_3.getkonum_x()-arr_gizlialtin.get(i).getAltinkonumhesapla_x())!=0 || (oyuncu_3.getkonum_y()- arr_gizlialtin.get(i).getAltinkonumhesapla_y()!=0))&&(arr_gizlialtin.get(i).getAltinmiktari()!=0) )
                {
                	karlialtin2=enkarlialtin;

                	gizliindex=i;
                    altintipisec=false;
        		
        		
            }
            }
        	
          oyuncu_3.hedefbelirleme();
          harcananaltinmiktari3+=hedefbelirleme3;
        	
        }
        
        
        
        
       
    
        
      
      
        

     
for(int i=0;i<adim;i++)
        {
            try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        	if(altintipisec==true)
        	{
        	if(oyuncu_3.getsatir()-arr_altin.get(index7).getAltin_satir()<0)
        	{
              
                        oyuncu_3.setsatir_sutun(1,0);
        		oyuncu_3.setkonum(0, karey_uzunluk);
        		m.repaint();
        	}
        	else if(oyuncu_3.getsatir()-arr_altin.get(index7).getAltin_satir()>0)
        	{
            
                        oyuncu_3.setsatir_sutun(-1,0);
        		oyuncu_3.setkonum(0, -karey_uzunluk);
        		m.repaint();
        	}
        	else if(oyuncu_3.getsutun()-arr_altin.get(index7).getAltin_sutun()<0)
        	{
           
                        oyuncu_3.setsatir_sutun(0,1);
        		oyuncu_3.setkonum(karex_uzunluk, 0);
        		m.repaint();
        	}
        	else if(oyuncu_3.getsutun()-arr_altin.get(index7).getAltin_sutun()>0)
        	{
                   
                        oyuncu_3.setsatir_sutun(0,-1);
        		oyuncu_3.setkonum(-karex_uzunluk, 0);
        		m.repaint();
        	}
              
                for(int k=0;k<c;k++)
            {
                if(oyuncu_3.getkonum_x()==arr_gizlialtin.get(k).getAltinkonumhesapla_x() && oyuncu_3.getkonum_y()==arr_gizlialtin.get(k).getAltinkonumhesapla_y() && arr_gizlialtin.get(k).getAltinmiktari()!=0)
                {
                    gizlidizi[arr_gizlialtin.get(k).getAltin_satir()][arr_gizlialtin.get(k).getAltin_sutun()]=false;
                    dizi[arr_gizlialtin.get(k).getAltin_satir()][arr_gizlialtin.get(k).getAltin_sutun()]=true;
                    arr_altin.add(arr_gizlialtin.get(k));
                    arr_yardimcialtin.add(arr_gizlialtin.get(k));
                    arr_gizlialtin.remove(k);
                    c=c-1;


                }
            }
        	
            if((oyuncu_3.getkonum_x()==arr_altin.get(index7).getAltinkonumhesapla_x() && oyuncu_3.getkonum_y()==arr_altin.get(index7).getAltinkonumhesapla_y()))
            {
                oyuncu_3.altinmiktari+=arr_altin.get(index7).getAltinmiktari();
         	   toplananaltinmiktari3+=arr_altin.get(index7).getAltinmiktari();
         	   arr_altin.get(index7).altinsifirla();
         	 dizi[arr_altin.get(index7).getAltin_satir()][arr_altin.get(index7).getAltin_sutun()]=false;
         	   hedefbelirle3=true;
                   if(arr_yardimcialtin.size()>=1)
              arr_yardimcialtin.remove(arr_yardimcialtin.size()-1);
         	 break;
            }
            toplamadımsayisi3++;
        	}
        	else
        	{
                    try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
                    
        	if(oyuncu_3.getsatir()-arr_gizlialtin.get(gizliindex).getAltin_satir()<0)
            	{
                  
                        oyuncu_3.setsatir_sutun(1,0);
            		oyuncu_3.setkonum(0, karey_uzunluk);
            		m.repaint();
            	}
            	else if(oyuncu_3.getsatir()-arr_gizlialtin.get(gizliindex).getAltin_satir()>0)
            	{
                
                            oyuncu_3.setsatir_sutun(-1,0);
            		oyuncu_3.setkonum(0, -karey_uzunluk);
            		m.repaint();
            	}
            	else if(oyuncu_3.getsutun()-arr_gizlialtin.get(gizliindex).getAltin_sutun()<0)
            	{
               
                            oyuncu_3.setsatir_sutun(0,1);
            		oyuncu_3.setkonum(karex_uzunluk, 0);
            		m.repaint();
            	}
            	else if(oyuncu_3.getsutun()-arr_gizlialtin.get(gizliindex).getAltin_sutun()>0)
            	{
                       
                            oyuncu_3.setsatir_sutun(0,-1);
            		oyuncu_3.setkonum(-karex_uzunluk, 0);
            		m.repaint();
            	}
          
           

                if((oyuncu_3.getkonum_x()==arr_gizlialtin.get(gizliindex).getAltinkonumhesapla_x() && oyuncu_3.getkonum_y()==arr_gizlialtin.get(gizliindex).getAltinkonumhesapla_y()))
                {
             	   oyuncu_3.altinmiktari+=arr_gizlialtin.get(gizliindex).getAltinmiktari();
         	   toplananaltinmiktari3+=arr_gizlialtin.get(gizliindex).getAltinmiktari();
             	   arr_gizlialtin.get(gizliindex).altinsifirla();
             	 gizlidizi[arr_gizlialtin.get(gizliindex).getAltin_satir()][arr_gizlialtin.get(gizliindex).getAltin_sutun()]=false;
             	   hedefbelirle3=true;
                   
             	 break;
                }
        		
     toplamadımsayisi3++;
        	}
               
               
           hedefbelirle3=false;  
       
        }
        oyuncu_3.hamle();
        harcananaltinmiktari3+=hamle;
     } 

        
    try
    {
    br4.write("("+oyuncu_4.getsutun()+","+oyuncu_4.getsatir()+")");
    br4.newLine();
    br4.flush();
    } 
     catch (IOException e) {
    System.out.println("Dosya bulunamadi");
    }
      
                
                
                
         try {
 			TimeUnit.SECONDS.sleep(1);
 		} catch (InterruptedException e) {
 			e.printStackTrace();
 		} 
         
        
        
 
        
       //---------------------OYUNCU 4--------------------
        toplamaltinmiktari=0;

       for(int i=0;i<arr_altin.size();i++)
       {
    	   if(i<arr_altin.size())
           {
           toplamaltinmiktari+=arr_altin.get(i).getAltinmiktari();
           altintoplami+=arr_altin.get(i).getAltinmiktari();
           }
    	   
    	   if(i<arr_gizlialtin.size())
    		   altintoplami+=arr_gizlialtin.get(i).getAltinmiktari();
       }
         
       int adimsayisi4;
       int adimsayisioyuncu2=0;
       int adimsayisioyuncu1=0;
       int adimsayisioyuncu3=0;
       int karlialtin4=arr_altin.get(0).getAltinmiktari()-(5*((2*width-2)-1/3+1));
      
       if(oyuncu_4.altinmiktari>0 && toplamaltinmiktari!=0 && tutus==0 )
       {
       for(int i=0;i<arr_altin.size();i++)
       {
           adimsayisi4=Math.abs(oyuncu_4.getsatir()-(arr_altin.get(i).getAltin_satir()))+(int)Math.abs(oyuncu_4.getsutun()-(arr_altin.get(i).getAltin_sutun()));
           int enkarlialtin=arr_altin.get(i).getAltinmiktari()-(5*(adimsayisi4-1/3)+1); 
           if(enkarlialtin>karlialtin4 && ((oyuncu_4.getkonum_x()-arr_altin.get(i).getAltinkonumhesapla_x())!=0 || (oyuncu_4.getkonum_y()- arr_altin.get(i).getAltinkonumhesapla_y()!=0))&&(arr_altin.get(i).getAltinmiktari()!=0))
           {
           	karlialtin4=enkarlialtin;
           	index10=i;
                index11=i;
               
           }
       }
       
    adimsayisioyuncu1=Math.abs(oyuncu_1.getsatir()-(arr_altin.get(index10).getAltin_satir()))+(int)Math.abs(oyuncu_1.getsutun()-(arr_altin.get(index10).getAltin_sutun()));
    adimsayisi4=Math.abs(oyuncu_4.getsatir()-(arr_altin.get(index10).getAltin_satir()))+(int)Math.abs(oyuncu_4.getsutun()-(arr_altin.get(index10).getAltin_sutun()));
    adimsayisioyuncu2=Math.abs(oyuncu_2.getsatir()-(arr_altin.get(index10).getAltin_satir()))+(int)Math.abs(oyuncu_2.getsutun()-(arr_altin.get(index10).getAltin_sutun()));
    adimsayisioyuncu3=Math.abs(oyuncu_3.getsatir()-(arr_altin.get(index10).getAltin_satir()))+(int)Math.abs(oyuncu_3.getsutun()-(arr_altin.get(index10).getAltin_sutun()));
     int hamle4=(adimsayisi4-1/3)+1;
     int hamle3=(adimsayisioyuncu3-1/3)+1;
     int hamle2=(adimsayisioyuncu2-1/3)+1;
     int hamle1=(adimsayisioyuncu1-1/3)+1;
    
      
      if(hamle4<=hamle3 && hamle4<=hamle2 && hamle4<=hamle1)
      {
          oyuncu_4.hedefbelirleme();
          harcananaltinmiktari4+=hedefbelirleme4;    
      for(int i=0;i<adim;i++)
       {
           try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
           
       	if(oyuncu_4.getsatir()-arr_altin.get(index10).getAltin_satir()<0)
       	{
       	  oyuncu_4.setsatir_sutun(1,0);
     		oyuncu_4.setkonum(0, karey_uzunluk);
                       
       		m.repaint();
       	}
       	else if(oyuncu_4.getsatir()-arr_altin.get(index10).getAltin_satir()>0)
       	{
           
                       oyuncu_4.setsatir_sutun(-1,0);
       		oyuncu_4.setkonum(0, -karey_uzunluk);
       		m.repaint();
       	}
       	else if(oyuncu_4.getsutun()-arr_altin.get(index10).getAltin_sutun()<0)
       	{
          
                       oyuncu_4.setsatir_sutun(0,1);
       		oyuncu_4.setkonum(karex_uzunluk, 0);
       		m.repaint();
       	}
       	else if(oyuncu_4.getsutun()-arr_altin.get(index10).getAltin_sutun()>0)
       	{
                  
                       oyuncu_4.setsatir_sutun(0,-1);
       		oyuncu_4.setkonum(-karex_uzunluk, 0);
       		m.repaint();
       	}
                 
                for(int k=0;k<c;k++)
            {
                if(oyuncu_4.getkonum_x()==arr_gizlialtin.get(k).getAltinkonumhesapla_x() && oyuncu_4.getkonum_y()==arr_gizlialtin.get(k).getAltinkonumhesapla_y()&& arr_gizlialtin.get(k).getAltinmiktari()!=0)
                {
                    gizlidizi[arr_gizlialtin.get(k).getAltin_satir()][arr_gizlialtin.get(k).getAltin_sutun()]=false;
                    dizi[arr_gizlialtin.get(k).getAltin_satir()][arr_gizlialtin.get(k).getAltin_sutun()]=true;
                    arr_altin.add(arr_gizlialtin.get(k));
                    arr_yardimcialtin.add(arr_gizlialtin.get(k));
                    arr_gizlialtin.remove(k);
                    c=c-1;


                }
            }
                toplamadımsayisi4++;

           if((oyuncu_4.getkonum_x()==arr_altin.get(index10).getAltinkonumhesapla_x() && oyuncu_4.getkonum_y()==arr_altin.get(index10).getAltinkonumhesapla_y()))
           {

           	oyuncu_4.altinmiktari+=arr_altin.get(index10).getAltinmiktari();
         	toplananaltinmiktari4+=arr_altin.get(index10).getAltinmiktari();

           	dizi[arr_altin.get(index10).getAltin_satir()][arr_altin.get(index10).getAltin_sutun()]=false;
           	arr_altin.get(index10).altinsifirla();
                if(arr_yardimcialtin.size()>=1)
              arr_yardimcialtin.remove(arr_yardimcialtin.size()-1);
           	
        	   break;
           }
          // oyuncuadım2++;
          
        
       
       
       }
     harcananaltinmiktari4+=hamle;
     oyuncu_4.hamle();
      
      }
      else
      {
          //System.out.println("Birinci else");
    	  for(int i=0;i<arr_altin.size();i++)
          {
              adimsayisi4=Math.abs(oyuncu_4.getsatir()-(arr_altin.get(i).getAltin_satir()))+(int)Math.abs(oyuncu_4.getsutun()-(arr_altin.get(i).getAltin_sutun()));
              int enkarlialtin=arr_altin.get(i).getAltinmiktari()-(5*(adimsayisi4-1/3)+1); 
              if(enkarlialtin>karlialtin4 && ((oyuncu_4.getkonum_x()-arr_altin.get(i).getAltinkonumhesapla_x())!=0 || (oyuncu_4.getkonum_y()- arr_altin.get(i).getAltinkonumhesapla_y()!=0))&&(arr_altin.get(i).getAltinmiktari()!=0)&& i!=index11)
              {
              	karlialtin4=enkarlialtin;
              	index10=i;
                index12=i;

              }
          }
    adimsayisioyuncu1=Math.abs(oyuncu_1.getsatir()-(arr_altin.get(index10).getAltin_satir()))+(int)Math.abs(oyuncu_1.getsutun()-(arr_altin.get(index10).getAltin_sutun()));
    adimsayisi4=Math.abs(oyuncu_4.getsatir()-(arr_altin.get(index10).getAltin_satir()))+(int)Math.abs(oyuncu_4.getsutun()-(arr_altin.get(index10).getAltin_sutun()));
    adimsayisioyuncu2=Math.abs(oyuncu_2.getsatir()-(arr_altin.get(index10).getAltin_satir()))+(int)Math.abs(oyuncu_2.getsutun()-(arr_altin.get(index10).getAltin_sutun()));
    adimsayisioyuncu3=Math.abs(oyuncu_3.getsatir()-(arr_altin.get(index10).getAltin_satir()))+(int)Math.abs(oyuncu_3.getsutun()-(arr_altin.get(index10).getAltin_sutun()));
     hamle4=(adimsayisi4-1/3)+1;
     hamle3=(adimsayisioyuncu3-1/3)+1;
     hamle2=(adimsayisioyuncu2-1/3)+1;
     hamle1=(adimsayisioyuncu1-1/3)+1;
    	  
    	  
    if(hamle4<=hamle3 && hamle4<=hamle2 && hamle4<=hamle1)	
    {
          oyuncu_4.hedefbelirleme();
          harcananaltinmiktari4+=hedefbelirleme4;
       // System.out.println("İkinci if");
        for(int i=0;i<adim;i++)
       {
           try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
           
       	if(oyuncu_4.getsatir()-arr_altin.get(index10).getAltin_satir()<0)
       	{
             
                oyuncu_4.setsatir_sutun(1,0);
       		oyuncu_4.setkonum(0, karey_uzunluk);
       		m.repaint();
       	}
       	else if(oyuncu_4.getsatir()-arr_altin.get(index10).getAltin_satir()>0)
       	{
           
                       oyuncu_4.setsatir_sutun(-1,0);
       		oyuncu_4.setkonum(0, -karey_uzunluk);
       		m.repaint();
       	}
       	else if(oyuncu_4.getsutun()-arr_altin.get(index10).getAltin_sutun()<0)
       	{
          
                       oyuncu_4.setsatir_sutun(0,1);
       		oyuncu_4.setkonum(karex_uzunluk, 0);
       		m.repaint();
       	}
       	else if(oyuncu_4.getsutun()-arr_altin.get(index10).getAltin_sutun()>0)
       	{
                  
                       oyuncu_4.setsatir_sutun(0,-1);
       		oyuncu_4.setkonum(-karex_uzunluk, 0);
       		m.repaint();
       	}
              
                for(int k=0;k<c;k++)
            {
                if(oyuncu_4.getkonum_x()==arr_gizlialtin.get(k).getAltinkonumhesapla_x() && oyuncu_4.getkonum_y()==arr_gizlialtin.get(k).getAltinkonumhesapla_y()&& arr_gizlialtin.get(k).getAltinmiktari()!=0)
                {
                    gizlidizi[arr_gizlialtin.get(k).getAltin_satir()][arr_gizlialtin.get(k).getAltin_sutun()]=false;
                    dizi[arr_gizlialtin.get(k).getAltin_satir()][arr_gizlialtin.get(k).getAltin_sutun()]=true;
                    arr_altin.add(arr_gizlialtin.get(k));
                    arr_yardimcialtin.add(arr_gizlialtin.get(k));
                    arr_gizlialtin.remove(k);
                    c=c-1;

                }
            }
                toplamadımsayisi4++;

           if((oyuncu_4.getkonum_x()==arr_altin.get(index10).getAltinkonumhesapla_x() && oyuncu_4.getkonum_y()==arr_altin.get(index10).getAltinkonumhesapla_y()))
           {
                  //oyuncutoplanan2=arr_altin.get(index2).getAltinmiktari();
           	oyuncu_4.altinmiktari+=arr_altin.get(index10).getAltinmiktari();
         	toplananaltinmiktari4+=arr_altin.get(index10).getAltinmiktari();
        	   //oyuncu_2.altinmiktari+=arr_altin.get(index2).getAltinmiktari();
           	dizi[arr_altin.get(index10).getAltin_satir()][arr_altin.get(index10).getAltin_sutun()]=false;
           	arr_altin.get(index10).altinsifirla();
                if(arr_yardimcialtin.size()>=1)
              arr_yardimcialtin.remove(arr_yardimcialtin.size()-1);
        	   break;
           }
     
          
        
       
       
       }
     harcananaltinmiktari4+=hamle;
     oyuncu_4.hamle();
        
        
    }
      else
        {
            
           // System.out.println("İkinci else");
                
         for(int i=0;i<arr_altin.size();i++)
          {
              adimsayisi4=Math.abs(oyuncu_4.getsatir()-(arr_altin.get(i).getAltin_satir()))+(int)Math.abs(oyuncu_4.getsutun()-(arr_altin.get(i).getAltin_sutun()));
              int enkarlialtin=arr_altin.get(i).getAltinmiktari()-(5*(adimsayisi4-1/3)+1); 
              if(enkarlialtin>karlialtin4 && ((oyuncu_4.getkonum_x()-arr_altin.get(i).getAltinkonumhesapla_x())!=0 || (oyuncu_4.getkonum_y()- arr_altin.get(i).getAltinkonumhesapla_y()!=0))&&(arr_altin.get(i).getAltinmiktari()!=0)&& i!=index11 && i!=index12)
              {
              	karlialtin4=enkarlialtin;
              	index10=i;
                index11=i;
              }
          }
           oyuncu_4.hedefbelirleme();
          harcananaltinmiktari4+=hedefbelirleme4;
     adimsayisioyuncu1=Math.abs(oyuncu_1.getsatir()-(arr_altin.get(index10).getAltin_satir()))+(int)Math.abs(oyuncu_1.getsutun()-(arr_altin.get(index10).getAltin_sutun()));
     adimsayisi4=Math.abs(oyuncu_4.getsatir()-(arr_altin.get(index10).getAltin_satir()))+(int)Math.abs(oyuncu_4.getsutun()-(arr_altin.get(index10).getAltin_sutun()));
     adimsayisioyuncu2=Math.abs(oyuncu_2.getsatir()-(arr_altin.get(index10).getAltin_satir()))+(int)Math.abs(oyuncu_2.getsutun()-(arr_altin.get(index10).getAltin_sutun()));
     adimsayisioyuncu3=Math.abs(oyuncu_3.getsatir()-(arr_altin.get(index10).getAltin_satir()))+(int)Math.abs(oyuncu_3.getsutun()-(arr_altin.get(index10).getAltin_sutun()));
     hamle4=(adimsayisi4-1/3)+1;
     hamle3=(adimsayisioyuncu3-1/3)+1;
     hamle2=(adimsayisioyuncu2-1/3)+1;
     hamle1=(adimsayisioyuncu1-1/3)+1;
     
         for(int i=0;i<adim;i++)
       {
           try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
           if(arr_yardimcialtin.size()<=2 && (hamle4>hamle3 || hamle4>hamle2 || hamle4>hamle1) )
           {
               tutus++;
               break;
           }
       	if(oyuncu_4.getsatir()-arr_altin.get(index10).getAltin_satir()<0)
       	{
             
                oyuncu_4.setsatir_sutun(1,0);
       		oyuncu_4.setkonum(0, karey_uzunluk);
       		m.repaint();
       	}
       	else if(oyuncu_4.getsatir()-arr_altin.get(index10).getAltin_satir()>0)
       	{
           
                       oyuncu_4.setsatir_sutun(-1,0);
       		oyuncu_4.setkonum(0, -karey_uzunluk);
       		m.repaint();
       	}
       	else if(oyuncu_4.getsutun()-arr_altin.get(index10).getAltin_sutun()<0)
       	{
          
                       oyuncu_4.setsatir_sutun(0,1);
       		oyuncu_4.setkonum(karex_uzunluk, 0);
       		m.repaint();
       	}
       	else if(oyuncu_4.getsutun()-arr_altin.get(index10).getAltin_sutun()>0)
       	{
                  
                       oyuncu_4.setsatir_sutun(0,-1);
       		oyuncu_4.setkonum(-karex_uzunluk, 0);
       		m.repaint();
       	}
              
                for(int k=0;k<c;k++)
               {
                if(oyuncu_4.getkonum_x()==arr_gizlialtin.get(k).getAltinkonumhesapla_x() && oyuncu_4.getkonum_y()==arr_gizlialtin.get(k).getAltinkonumhesapla_y()&& arr_gizlialtin.get(k).getAltinmiktari()!=0)
                {
                    gizlidizi[arr_gizlialtin.get(k).getAltin_satir()][arr_gizlialtin.get(k).getAltin_sutun()]=false;
                    dizi[arr_gizlialtin.get(k).getAltin_satir()][arr_gizlialtin.get(k).getAltin_sutun()]=true;
                    arr_altin.add(arr_gizlialtin.get(k));
                    arr_yardimcialtin.add(arr_gizlialtin.get(k));
                    arr_gizlialtin.remove(k);
                    c=c-1;


                }
            }
                toplamadımsayisi4++;
     
           if((oyuncu_4.getkonum_x()==arr_altin.get(index10).getAltinkonumhesapla_x() && oyuncu_4.getkonum_y()==arr_altin.get(index10).getAltinkonumhesapla_y()))
           {
                  //oyuncutoplanan2=arr_altin.get(index2).getAltinmiktari();
           	oyuncu_4.altinmiktari+=arr_altin.get(index10).getAltinmiktari();
         	toplananaltinmiktari4+=arr_altin.get(index10).getAltinmiktari();
        	   //oyuncu_2.altinmiktari+=arr_altin.get(index2).getAltinmiktari();
           	dizi[arr_altin.get(index10).getAltin_satir()][arr_altin.get(index10).getAltin_sutun()]=false;
           	arr_altin.get(index10).altinsifirla();
                if(arr_yardimcialtin.size()>=1)
              arr_yardimcialtin.remove(arr_yardimcialtin.size()-1);
           
        	   break;
           }
       
          
        
       
       
       }
         
     harcananaltinmiktari4+=hamle;
     oyuncu_4.hamle(); 
        }
      }
       }
      
        
      
      
      toplamaltinmiktari=0;
        //alper++; 
       for(int i=0;i<arr_altin.size();i++)
       {
    	   if(i<arr_altin.size())
           {
           toplamaltinmiktari+=arr_altin.get(i).getAltinmiktari();
           altintoplami+=arr_altin.get(i).getAltinmiktari();
           }
    	   
    	   if(i<arr_gizlialtin.size())
    		   altintoplami+=arr_gizlialtin.get(i).getAltinmiktari();
       }
       
       
       
       }
    try
    {
    br3.write("("+oyuncu_3.getsutun()+","+oyuncu_3.getsatir()+")");
    br3.newLine();
    br3.flush();
    } 
    catch (IOException e) {
    System.out.println("Dosya bulunamadi");
    }
    try
    {
    oyuncular.write("Oyuncu1'in kasadaki altın miktarı:"+oyuncu_1.altinmiktari);
    oyuncular.newLine();
    oyuncular.write("Oyuncu1'in toplanan altın miktarı:"+toplananaltinmiktari1);
    oyuncular.newLine();
    oyuncular.write("Oyuncu1'in harcanan altın miktarı:"+harcananaltinmiktari1);
    oyuncular.newLine();
    oyuncular.write("Oyuncu1'in toplam adım sayısı :"+toplamadımsayisi1);
    oyuncular.newLine();
    oyuncular.newLine();
    oyuncular.newLine();
    oyuncular.flush();
    
    oyuncular.write("Oyuncu2'nin kasadaki altın miktarı:"+oyuncu_2.altinmiktari);
    oyuncular.newLine();
    oyuncular.write("Oyuncu2'nin toplanan altın miktarı:"+toplananaltinmiktari2);
    oyuncular.newLine();
    oyuncular.write("Oyuncu2'nin harcanan altın miktarı:"+harcananaltinmiktari2);
    oyuncular.newLine();
    oyuncular.write("Oyuncu2'nin toplam adım sayısı :"+toplamadımsayisi2);
    oyuncular.newLine();
    oyuncular.newLine();
    oyuncular.newLine();
    oyuncular.flush();
    
    oyuncular.write("Oyuncu3'un kasadaki altın miktarı:"+oyuncu_3.altinmiktari);
    oyuncular.newLine();
    oyuncular.write("Oyuncu3'un toplanan altın miktarı:"+toplananaltinmiktari3);
    oyuncular.newLine();
    oyuncular.write("Oyuncu3'un harcanan altın miktarı:"+harcananaltinmiktari3);
    oyuncular.newLine();
    oyuncular.write("Oyuncu3'un toplam adım sayısı :"+toplamadımsayisi3);
    oyuncular.newLine();
    oyuncular.newLine();
    oyuncular.newLine();
    oyuncular.flush();
    
    oyuncular.write("Oyuncu4'un kasadaki altın miktarı:"+oyuncu_4.altinmiktari);
    oyuncular.newLine();
    oyuncular.write("Oyuncu4'un toplanan altın miktarı:"+toplananaltinmiktari4);
    oyuncular.newLine();
    oyuncular.write("Oyuncu4'un harcanan altın miktarı:"+harcananaltinmiktari4);
    oyuncular.newLine();
    oyuncular.write("Oyuncu4'un toplam adım sayısı :"+toplamadımsayisi4);
    oyuncular.flush();
    } 
    catch (IOException e) {
    System.out.println("Dosya bulunamadi");
    }
   
}
}