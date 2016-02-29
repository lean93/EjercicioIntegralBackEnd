package Compradores;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Excepciones.FalloEnCompraExcepcion;
import Paquetes.*;

public class Empresa extends Cliente{
	
	private static final  Logger LOGGER = LoggerFactory.getLogger(Empresa.class);

	public Empresa(double unSaldo) {
		super(unSaldo);
	}
	
	public void comprarVarios(Collection<Paquete> unosPaquetes) throws FalloEnCompraExcepcion{
	
		LOGGER.info("Empiezo de proceso de varias compras al mismo tiempo");
		for (Paquete paq : unosPaquetes){
			comprarPaquete(paq);
		}
		LOGGER.info("Todos los paquetes fueron comprado con exito");
	}
	
	

}
