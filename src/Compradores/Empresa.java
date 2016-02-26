package Compradores;

import java.util.Collection;
import Paquetes.*;

public class Empresa extends Cliente{

	public Empresa(double unSaldo) {
		super(unSaldo);
	}
	
	public void comprarVarios(Collection<Paquete> unosPaquetes){
	
		for (Paquete paq : unosPaquetes){
			comprarPaquete(paq);
		}
	}
	
	

}
