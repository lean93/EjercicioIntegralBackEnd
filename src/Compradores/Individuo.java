package Compradores;

import Paquetes.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Excepciones.*;

public class Individuo extends Cliente {
	
	private static final Logger logger = LogManager.getLogger();
	Paquete enReserva;

	public Individuo(double unSaldo) {
		super(unSaldo);
		// TODO Auto-generated constructor stub
	}

	public void reservarPaquete(Paquete unPaquete) throws SinSaldoException{
		logger.info("Reservando El Paquete");
		realizarPago(unPaquete.getMedioPrecio(this));
		enReserva = unPaquete;
		logger.info("Reserva Realizada con Exito");
	}
	
	public void terminarCompra() throws SinSaldoException{
		logger.info("Terminando operacion de reserva, Pagando la segunda mitad del paquete");
		realizarPago(enReserva.getMedioPrecio(this));
		añadirPaquete(enReserva);
		enReserva = null;
		logger.info("Compra realizada, ya no tiene reservas");
	}
	
	public Paquete getPaqueteEnReserva(){
		return enReserva;
	}
	
}
