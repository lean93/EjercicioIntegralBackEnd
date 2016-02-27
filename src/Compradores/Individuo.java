package Compradores;

import Paquetes.*;
import Excepciones.*;

public class Individuo extends Cliente {
	
	Paquete enReserva;

	public Individuo(double unSaldo) {
		super(unSaldo);
		// TODO Auto-generated constructor stub
	}

	public void reservarPaquete(Paquete unPaquete) throws SinSaldoException{
		
		realizarPago(unPaquete.getMedioPrecio(this));
		enReserva = unPaquete;
	}
	
	public void terminarCompra() throws SinSaldoException{
		
		realizarPago(enReserva.getMedioPrecio(this));
		añadirPaquete(enReserva);
		enReserva = null;
	}
	
	public Paquete getPaqueteEnReserva(){
		return enReserva;
	}
	
}
