package builderPattern;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Araba araba = new Araba.Builder(0).klima(true).ekran(true).abs(true).build();
		
		System.out.println(araba.toString());

	}

}
