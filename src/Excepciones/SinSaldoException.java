package Excepciones;

public class SinSaldoException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public SinSaldoException(String mensaje){
		super (mensaje);
	}
	

}
