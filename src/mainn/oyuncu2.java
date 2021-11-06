package mainn;

public class oyuncu2 {
	int altinmiktari;
	int konum_x=0;
	int konum_y=0;
	int satir=0,sutun=0;
        int hamlemaliyeti;
        int hedefbelirlememaliyeti;
	public void hamle()
	{
		altinmiktari=altinmiktari-hamlemaliyeti;
	}
	public void hedefbelirleme()
	{
		altinmiktari=altinmiktari-hedefbelirlememaliyeti;;
	}
	public void setkonum(int konum_x,int konum_y)
	{
		this.konum_x+=konum_x;
		this.konum_y+=konum_y;
	}
	public int getkonum_x()
	{
		return konum_x;
	}
	public int getkonum_y()
	{
		return konum_y;
	}
	public void setsatir_sutun(int satir,int sutun)
	{
		this.satir+=satir;
		this.sutun+=sutun;
	}
	public int getsatir()
	{
		return satir;
	}
	public int getsutun()
	{
		return sutun;
	}
}