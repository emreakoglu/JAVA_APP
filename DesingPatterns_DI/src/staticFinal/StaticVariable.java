package staticFinal;

import java.text.SimpleDateFormat;

public class StaticVariable {
	
	static SimpleDateFormat simpleDateFormat = new  SimpleDateFormat("HH:mm:ss yyyy-MM-dd");
	
	static String callEveryWhere () {
		return "her yerden çaðýrabilirsin";
	}

}
