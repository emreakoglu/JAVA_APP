package singletonPattern;

public class SingletonPatternDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SingletonClass singletonObject = SingletonClass.getInstance();
		
		try {
			SingletonClass singletonObject_ = (SingletonClass) singletonObject.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
