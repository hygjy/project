package webadv.s16204215.demo.tools;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeConverTools {
	
	public static String getCurTime() {
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat fmt=new SimpleDateFormat("yyy-MM-dd");
		String str=fmt.format(cal.getTime());
		return str;
	}
	
	public static String getMultiCurTime() {
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat fmt=new SimpleDateFormat("yyy-MM-dd hh:mm:ss");
		String str=fmt.format(cal.getTime());
		return str;
	}


}
