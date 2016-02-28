package Compradores;

import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Excepciones.FalloEnCompraExcepcion;
import Paquetes.*;

public class Empresa extends Cliente{
	private static final Logger logger = LogManager.getLogger();

	public Empresa(double unSaldo) {
		super(unSaldo);
	}
	
	public void comprarVarios(Collection<Paquete> unosPaquetes) throws FalloEnCompraExcepcion{
	
		logger.info("Empiezo de proceso de varias compras al mismo tiempo");
		for (Paquete paq : unosPaquetes){
			comprarPaquete(paq);
		}
		logger.info("Todos los paquetes fueron comprado con exito");
	}
	
	

}
