package Excepciones;

public class FalloEnCompraExcepcion extends Exception{
	
	private static final long serialVersionUID = 1L;

	public FalloEnCompraExcepcion(String mensaje){
		super (mensaje);
	}

}
