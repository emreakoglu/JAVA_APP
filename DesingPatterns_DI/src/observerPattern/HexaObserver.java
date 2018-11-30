package observerPattern;

public class HexaObserver extends Observer {

	public HexaObserver(Subject subject) {
		this.subject = subject; // konu eklendi
		this.subject.attach(this); // observer listesine bu HexaObserver eklendi
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println( "Hex String: " + Integer.toHexString( subject.getState() ).toUpperCase() ); 
	}

}
