package w2.esercizio3.d1;

public class BancaException extends Exception {

	private String msg;
	
	public BancaException(String msg) {
		super(msg);
		this.msg = msg;
		
		
		
	}

	@Override
	public String toString() {
		return this.msg;
	}

	
}
