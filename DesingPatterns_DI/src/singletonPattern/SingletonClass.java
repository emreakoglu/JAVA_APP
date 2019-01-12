package singletonPattern;

public class SingletonClass {
	
	// Tek bir sefer olu�turulmas�n� sa�lar
	private static SingletonClass instance = null;
	
	private SingletonClass() {
		
		System.out.println("S�n�f tek seferligine olusturuldu");
		
	}
	
	//synchronized anahtar kelimemiz ile metodun ayn� anda �al��mas�n� engelledik.
	public synchronized static SingletonClass getInstance() {
		
		System.out.println("S�n�f getInstance metodu sayesinde cagrilacak");
		
		if (instance == null) {
			instance = new SingletonClass();
		}
		
		return instance;
	}
	
	@Override
    public Object clone() throws CloneNotSupportedException
    {
        throw new CloneNotSupportedException("Bu s�n�f clonelanamaz");
    }

}
