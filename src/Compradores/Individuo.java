package Compradores;

import Paquetes.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Excepciones.*;

public class Individuo extends Cliente {
	

	private static final  Logger LOGGER = LoggerFactory.getLogger(Cliente.class);
	Paquete enReserva = null;

	public Individuo(double unSaldo) {
		super(unSaldo);
	}

	public void reservarPaquete(Paquete unPaquete) throws SinSaldoException{
		LOGGER.info("Reservando El Paquete");
		realizarPago(unPaquete.getMedioPrecio(this));
		enReserva = unPaquete;
		LOGGER.info("Reserva Realizada con Exito");
	}
	
	public void terminarCompra() throws SinSaldoException{
		LOGGER.info("Terminando operacion de reserva, Pagando la segunda mitad del paquete");
		realizarPago(enReserva.getMedioPrecio(this));
		añadirPaquete(enReserva);
		enReserva = null;
		LOGGER.info("Compra realizada, ya no tiene reservas");
	}
	
	public Paquete getPaqueteEnReserva(){
		return enReserva;
	}
	
	public void comprarPaquete(Paquete unPaquete) throws FalloEnCompraExcepcion{
		
		if (enReserva == null){
			super.comprarPaquete(unPaquete);
		} else {
			throw new VariasComprasException("ya tenes una reserva, no podes comprar otro paquete");
		}
		
	}
	
}
