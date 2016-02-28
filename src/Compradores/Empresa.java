package Compradores;

import java.util.Collection;

import Excepciones.FalloEnCompraExcepcion;
import Paquetes.*;

public class Empresa extends Cliente{

	public Empresa(double unSaldo) {
		super(unSaldo);
	}
	
	public void comprarVarios(Collection<Paquete> unosPaquetes) throws FalloEnCompraExcepcion{
	
		for (Paquete paq : unosPaquetes){
			comprarPaquete(paq);
		}
	}
	
	

}
