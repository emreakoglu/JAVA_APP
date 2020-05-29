package staticFinal;

import java.util.Date;

public class Demo {

	private static int a = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		a = 5;
		
		String date = StaticVariable.simpleDateFormat.format(new Date());
		
		String response = StaticVariable.callEveryWhere(); // Bu Sýnýftan nesne oluþturmadan metodu kullanmýþ olduk.
	}

}
