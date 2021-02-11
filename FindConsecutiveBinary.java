package binaryCount;

public class FindConsecutiveBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int i = countSubString("00011100011");
		System.out.println(i);

	}
	
	public static int countSubString(String string) {
		
		int countSubString = 0;
		
		for (int i = 0; i<string.length(); i++) {
			
			if ((i+1) < string.length() && (string.charAt(i) != string.charAt(i+1))) {
				
				System.out.println(string.substring(i, i+1+1));
				countSubString++;
				
				for (int j=1;j<=i;j++) {
					
					if ((i+j+1) < string.length() && (string.charAt(i-j) == string.charAt(i)) && (string.charAt(i+1) == string.charAt(i+j+1))) {
						
						System.out.println(string.substring(i-j, i+j+1+1));
						countSubString++;
					}
					
				}
			}
		}
		
		return countSubString;
	}

}
