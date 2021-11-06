package mainn;

public class Altin {
	int satir;
	   int sutun;
	   int kare_x,kare_y;
	   int konum_x,konum_y;
	   int randomsayi;
	   public Altin()
	   {
		  
	   }
	   public void setAltin_satirsutun(int satir,int sutun)
	   {
		   this.satir=satir;
		   this.sutun=sutun;
		   
		   
	   }
	  
	  
		public void setAltinkonumhesapla(int konum_x,int konum_y)
		{
			this.konum_x=konum_x;
			this.konum_y=konum_y;
			
			
		}
		public int getAltinkonumhesapla_x()
		{
			return konum_x;
			
		}
		public int getAltinkonumhesapla_y()
		{
			return konum_y;
			
		}
		public int getAltin_satir()
		{
			return satir;
		}
		public int getAltin_sutun()
		{
			return sutun;
		}
		public void setAltinmiktari()
		{
			//Random random1=new Random();
			 
		     randomsayi=(int) ((Math.random() * 4) + 1);
			 randomsayi=randomsayi*5;
			
		}
		public void altinsifirla()
		{
			randomsayi=0; 
		}
		public int getAltinmiktari()
		{
			return randomsayi;
		}
}