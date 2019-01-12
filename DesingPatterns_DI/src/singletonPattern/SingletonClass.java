package singletonPattern;

public class SingletonClass {
	
	// Tek bir sefer oluþturulmasýný saðlar
	private static SingletonClass instance = null;
	
	private SingletonClass() {
		
		System.out.println("Sýnýf tek seferligine olusturuldu");
		
	}
	
	//synchronized anahtar kelimemiz ile metodun ayný anda çalýþmasýný engelledik.
	public synchronized static SingletonClass getInstance() {
		
		System.out.println("Sýnýf getInstance metodu sayesinde cagrilacak");
		
		if (instance == null) {
			instance = new SingletonClass();
		}
		
		return instance;
	}
	
	@Override
    public Object clone() throws CloneNotSupportedException
    {
        throw new CloneNotSupportedException("Bu sýnýf clonelanamaz");
    }

}
