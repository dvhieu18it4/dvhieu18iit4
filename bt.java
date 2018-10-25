public class Time {
	private int hour ;		// 0-23
	private int minute ;	// 0-59		
	private int second;		//0-59
// Phương thức khơi tạo
	public Time(int h,int m,int s) 
	{
		// gọi hàm thiết lập giờ phút giây
	setTime(h,m,s);
	}
// định nghĩa hàm giờ phút giây
	public void setTime(int h,int m ,int s) {
		setHour  (h);
		setMinute(m);
		setSecond(s);
	}
// Định nghĩa hàm giờ
	public void setHour(int h)
	{
		hour=((h>=0 && h<24)  ? h : 0);
	}
// định nghĩa hàm phút
	public void setMinute(int m ) 
	{
		minute=((m>=0 && m<59) ? m :0);
	}
// định nghĩa hàm giây
	public void setSecond(int s) {
		second=((s>=0 && s< 60 ) ? s : 0);
	}
// định dạng buổi nếu <12h thì là AM còn sau 12h là PM
	public String toString() {
		return ((hour==12||hour==0) ?12 :hour %12) +":" + 
	(minute< 10 ? "0"  : "" ) +minute + ":" + 
	(second  < 10 ? "0" :"") + second +
	( hour < 12 ?"AM" : "PM" );
	}
	// tăng 1 giây đơn vị
	public void tick() 
	{
		setSecond (second + 1 );
/*	 nếu giấy tang lên 60 thì hàm sencond đc thiết laapj là giây = 0 và 
 * 	do đó cần tăng lên 1 phút
*/		
		if (second == 0) incrementMinute();
	}
	// tăng phút lên 1 đơn vị
	public void incrementMinute() 
	{
		if(minute == 0 ) incrementHour();
	}
	// tăng giờ lên 1 đơn vị nếu lên 24h thì thiết lập lại = 0
	public void incrementHour() 
	{
		setHour( hour +1);
		
	}
	public static void main(String[] args) {
		Time A=new Time(10,41,0);
		System.out.println(" Thời gian đã thiết lập là  = "+A.toString());
	// tạo vòng lặp vĩnh cửu
		while (true)
		{
			// hiện thời gian hiện tại
			System.out.println(A.toString());
			try {
				Thread.sleep(1000);
				A.tick();
			}
			catch(Exception e)
			{
				
			}
		}
	}
}
